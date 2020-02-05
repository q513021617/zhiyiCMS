package cn.zhiyigo.pblog.Controller;

import cn.zhiyigo.pblog.Controller.CommonController.CommonRoleController;
import cn.zhiyigo.pblog.Dao.RoleDao;
import cn.zhiyigo.pblog.Model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/role")
public class HomeRoleController extends CommonRoleController {

    @Autowired
    private RoleDao roleDao;




}
