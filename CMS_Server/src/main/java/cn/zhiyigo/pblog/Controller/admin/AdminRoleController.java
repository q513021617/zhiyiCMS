package cn.zhiyigo.pblog.Controller.admin;

import cn.zhiyigo.pblog.Controller.CommonController.CommonPhotoController;
import cn.zhiyigo.pblog.Controller.CommonController.CommonRoleController;
import cn.zhiyigo.pblog.Dao.RoleDao;
import cn.zhiyigo.pblog.Model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/admin/role")
public class AdminRoleController extends CommonRoleController {

    @Autowired
    private RoleDao roleDao;




}
