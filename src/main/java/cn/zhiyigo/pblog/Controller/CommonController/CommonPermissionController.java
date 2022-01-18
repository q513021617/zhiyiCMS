package cn.zhiyigo.pblog.Controller.CommonController;

import cn.zhiyigo.pblog.Dao.PermissionDao;
import cn.zhiyigo.pblog.Dao.PermissionDao;
import cn.zhiyigo.pblog.Model.Permission;
import cn.zhiyigo.pblog.Model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class CommonPermissionController {
    @Autowired
    private PermissionDao permissionDao;

    @GetMapping
    public Response getPermissioList(){
        List<Permission> permissionDaoAll = permissionDao.findAll();
        return Response.success(permissionDaoAll);
    }

    @GetMapping("/{id}")
    public Response getPermissionByid(@PathVariable("id")Integer id){

        Permission permission = permissionDao.findById(id).get();
        return Response.success(permission);
    }



    @PostMapping
    public Response addPermission(@RequestBody Permission permission){


        Permission save = permissionDao.save(permission);
        return Response.success(save);
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
