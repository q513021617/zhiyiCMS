package cn.botian.cloud.Controller.admin;

import cn.botian.cloud.Controller.CommonController.CommonUserController;
import cn.botian.cloud.Dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/webUser")
public class AdminUserController extends CommonUserController{

    @Autowired
    private UserDao userDao;



}
