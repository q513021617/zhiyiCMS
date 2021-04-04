package cn.botian.cloud.Controller;

import cn.botian.cloud.Dao.UserDao;
import cn.botian.cloud.Model.WebUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
