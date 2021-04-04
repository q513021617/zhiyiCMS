package cn.botian.cloud.Controller.admin;

import cn.botian.cloud.Controller.CommonController.CommonRoleController;
import cn.botian.cloud.Dao.RoleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/role")
public class AdminRoleController extends CommonRoleController {

    @Autowired
    private RoleDao roleDao;




}
