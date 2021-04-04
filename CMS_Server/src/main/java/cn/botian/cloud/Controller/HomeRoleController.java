package cn.botian.cloud.Controller;

import cn.botian.cloud.Controller.CommonController.CommonRoleController;
import cn.botian.cloud.Dao.RoleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/role")
public class HomeRoleController extends CommonRoleController {

    @Autowired
    private RoleDao roleDao;




}
