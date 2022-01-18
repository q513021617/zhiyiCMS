package cn.zhiyigo.pblog.Controller;

import cn.zhiyigo.pblog.Dao.UserDao;
import cn.zhiyigo.pblog.Model.*;
import cn.zhiyigo.pblog.Servcie.FiledService;
import cn.zhiyigo.pblog.Servcie.PermissionService;
import cn.zhiyigo.pblog.ServcieImpl.UserAuthenticationService;
import cn.zhiyigo.pblog.Utils.JwtTokenUtils;
import cn.zhiyigo.pblog.enums.ResultStatusEnum;
import cn.zhiyigo.pblog.enums.UserRole;
import com.mysql.jdbc.StringUtils;
import com.qiniu.util.Auth;
import com.qiniu.util.StringMap;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
@Controller
public class IndexController {

    @Autowired
    private UserDao userDao;


    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    FiledService filedService;
    @Autowired
    AuthenticationManagerBuilder authenticationManagerBuilder;

    @Autowired
    PermissionService permissionService;

    private static Map tablename=new ConcurrentHashMap();

    String loginByUser(String user,String role,String password){
        // 登陆验证
        UsernamePasswordAuthenticationToken token =
                new UsernamePasswordAuthenticationToken(user, password);
        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(token);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token1 = JwtTokenUtils.createToken(user,role, false);
        return token1;
    }

    @GetMapping("/getUserNum/{num}")
    @ResponseBody
    public Response getUserByRandom(@PathVariable("num")String num){

        Object user = HomeUserController.map.get(num);
        if(user==null){
            return Response.failed(ResultStatusEnum.UNKOWN_REASON,"不存在此用户");
        }
        return Response.success(user);
    }

    @PostMapping("/isExtisUser")
    public Object isExtisUser(@RequestBody WebUser webUser){

        WebUser tempWebUser = userDao.findByemail(webUser.getEmail());

        return tempWebUser != null;
    }

    @PostMapping("/webLogin")
    @ResponseBody
    public Object userlogin(@RequestBody WebUser webUser){

        WebUser tempWebUser =userDao.findByemail(webUser.getEmail());
        try {
            String userToken = loginByUser(tempWebUser.getUsername(), UserRole.USER.getRoleName(), webUser.getPassword());
            tempWebUser.setToken(userToken);
            userDao.saveAndFlush(tempWebUser);
        } catch (BadCredentialsException exception){
            log.info(exception.getMessage());
            return Response.failed(ResultStatusEnum.ACCESS_DENIED,exception.getMessage());
        }
        return Response.success(tempWebUser);
    }

    @PostMapping("/adminlogin")
    @ResponseBody
    public Object adminlogin(@RequestBody WebUser webUser){
        WebUser tempWebUser = userDao.findByusername(webUser.getUsername());
        try {
            String userToken = loginByUser(webUser.getUsername(), UserRole.ADMIN.getRoleName(), passwordEncoder.encode(webUser.getPassword()));
            tempWebUser.setToken(userToken);
        }catch (Exception exception){
            return Response.failed(ResultStatusEnum.ACCESS_DENIED,exception.getMessage());
        }
        userDao.saveAndFlush(tempWebUser);
        return Response.success(tempWebUser);
    }

    @PostMapping("/register")
    @ResponseBody
    public Object userRegister(@RequestBody WebUser webUser){

        webUser.setPassword(passwordEncoder.encode(webUser.getPassword()));
        String token = JwtTokenUtils.createToken(webUser.getPassword(), UserRole.USER.getRoleName(), true);
        webUser.setToken(token);
        webUser.setRole(UserRole.USER.getRoleNum());
        return userDao.saveAndFlush(webUser);
    }

    @RequestMapping("/")
    public String index(){

        return "index";
    }

    @RequestMapping("/callback")
    public void callback(@RequestParam("url") String url, HttpServletResponse response) throws IOException {

        response.sendRedirect(url);
    }

    @GetMapping("/path")
    public String indexPageRoute(@RequestParam("url") String url,
                                 @RequestParam(value = "mod",required = false) String mod,
                                 @RequestParam(value = "api",required = false) String api) {
        if(!StringUtils.isNullOrEmpty(mod)){
            tablename.put("mod",mod);
            tablename.put("api",api);
        }

        return url;
    }

    @GetMapping("/mod")
    @ResponseBody
    public Response getMod() {
        String modename=(String) tablename.get("mod");
        List<Permission> permissions = permissionService.selectByName(modename);
        List<Filed> fileds = filedService.getFiledByTableName(permissions.get(0).getTableName());
        tablename.put("columns",fileds);
        return Response.success(tablename);
    }

    @RequestMapping("/getQiniuToken")
    @ResponseBody
    public QiNiu getQiniuToken(){
        QiNiu qiNiu = new QiNiu();
        String accessKey = "M6xnfG6jheYvd0gLHKkaZJztEGxmC5UW1jrfYjVG";
        String secretKey = "j2i1juXzp-Qg4yOuUNTcK362dAuPF1NY41UFdXyU";
        String bucket = "zhiyigo";
        long expireSeconds = 600;   //过期时间
        StringMap putPolicy = new StringMap();
        Auth auth = Auth.create(accessKey, secretKey);
        String upToken = auth.uploadToken(bucket,null, expireSeconds,putPolicy);
        qiNiu.setKey(UUID.randomUUID().toString().replaceAll("\\-", ""));
        qiNiu.setToken(upToken);
        return qiNiu;
    }

}
