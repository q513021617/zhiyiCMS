package cn.zhiyigo.pblog.Controller.CommonController;

import cn.zhiyigo.pblog.Dao.PermissionDao;
import cn.zhiyigo.pblog.Dao.PermissionDao;
import cn.zhiyigo.pblog.Model.Permission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class CommonPermissionController {
    @Autowired
    private PermissionDao permissionDao;

    @GetMapping
    public List<Permission> getPermissioList(){

        return permissionDao.findAll();
    }

    @GetMapping("/{id}")
    public Permission getPermissionByid(@PathVariable("id")Integer id){

        return  permissionDao.findById(id).get();
    }



    @PostMapping
    public Permission addPermission(@RequestBody Permission permission){


        return  permissionDao.save(permission);
    }

    @DeleteMapping
    public void delOnePermission(@RequestBody Permission permission){

        permissionDao.delete(permission);
    }

    @DeleteMapping("/all")
    public void delAllPermission(){

        permissionDao.deleteAll();
    }
}
