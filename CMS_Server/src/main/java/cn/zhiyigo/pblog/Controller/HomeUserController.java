package cn.zhiyigo.pblog.Controller;

import cn.zhiyigo.pblog.Controller.CommonController.CommonUserController;
import cn.zhiyigo.pblog.Dao.UserDao;
import cn.zhiyigo.pblog.Model.WebUser;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/user")
public class HomeUserController {

    @Autowired
    private UserDao userDao;

    @PostMapping("/login")
    public Object userlogin(WebUser webUser){

        WebUser tempWebUser =userDao.findByusername(webUser.getUsername());

        if (tempWebUser != null && tempWebUser.getPassword().equals(webUser.getPassword())) {


            return tempWebUser;
        }
        return null;
    }
}
