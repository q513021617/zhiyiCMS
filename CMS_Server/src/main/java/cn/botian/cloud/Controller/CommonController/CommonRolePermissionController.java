package cn.botian.cloud.Controller.CommonController;

import cn.botian.cloud.Dao.RolePermissionDao;
import cn.botian.cloud.Model.RolePermission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class CommonRolePermissionController {

    @Autowired
    private RolePermissionDao rolePermissionDao;

    @GetMapping("/")
    public List<RolePermission> getPermissioList(){

        return rolePermissionDao.findAll();
    }

//    @GetMapping("/{id}")
//    public RolePermission getRolePermissionByid(@PathVariable("id")Integer id){
//
//        return  rolePermissionDao.findById(id).get();
//    }

    @PutMapping("/")
    public RolePermission updateRolePermission(RolePermission rolePermission){


        return  rolePermissionDao.save(rolePermission);
    }

    @PostMapping("/")
    public RolePermission addRolePermission(RolePermission rolePermission){


        return  rolePermissionDao.save(rolePermission);
    }

    @DeleteMapping("/")
    public void delOneRolePermission(RolePermission rolePermission){

        rolePermissionDao.delete(rolePermission);
    }

    @DeleteMapping("/all")
    public void delAllRolePermission(){

        rolePermissionDao.deleteAll();
    }
}
