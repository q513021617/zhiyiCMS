package cn.zhiyigo.pblog.Controller;

import cn.zhiyigo.pblog.Dao.UserDao;
import cn.zhiyigo.pblog.Model.Response;
import cn.zhiyigo.pblog.Model.WebUser;
import cn.zhiyigo.pblog.Utils.JwtTokenUtils;
import cn.zhiyigo.pblog.enums.ResultStatusEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@RestController
@RequestMapping("/api/user")
public class HomeUserController {

    @Autowired
    private UserDao userDao;
    final static Map map = new ConcurrentHashMap();

    @GetMapping("/{id}")
    public WebUser getUserByid(@PathVariable("id")Integer userid){

        Optional<WebUser> tempuser=userDao.findById(userid);
        return tempuser.orElse(null);
    }

    @PostMapping("/loginByToken")
    @ResponseBody
    public Response loginByToken(@RequestParam("num")String num,@RequestBody Map reqMap){

        String token = (String)reqMap.get("token");
        String userName = JwtTokenUtils.getUserName(token);
        WebUser webUser = userDao.findByusername(userName);
        map.put(num,webUser);
        if(webUser==null){
            return Response.failed(ResultStatusEnum.INTERNAL_ERROR,"token非法");
        }
        return Response.success(webUser);
    }

}
