package cn.botian.cloud.Controller.CommonController;

import cn.botian.cloud.Dao.PermissionDao;
import cn.botian.cloud.Model.Permission;
import cn.botian.cloud.Model.WebUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class CommonPermissionController {
    @Autowired
    private PermissionDao permissionDao;

    @GetMapping("/")
    public List<Permission> getPermissioList(){

        return permissionDao.findAll();
    }

    @GetMapping("/{page}/{size}")
    public Iterable<Permission> getListBypage(@PathVariable("page")String page, @PathVariable("size")int size){
        Pageable pageable = new PageRequest(Integer.parseInt(page),size);

        return permissionDao.findAll(pageable);
    }

    @GetMapping("/{id}")
    public Permission getPermissionByid(@PathVariable("id")Integer id){

        return  permissionDao.findById(id).get();
    }

    @PutMapping("/")
    public Permission updateMenu(Permission permission){


        return  permissionDao.save(permission);
    }

    @PostMapping("/")
    public Permission addPermission(Permission permission){


        return  permissionDao.save(permission);
    }

    @PostMapping("/del")
    public void delOnePermission(Permission permission){

        permissionDao.delete(permission);
    }

    @DeleteMapping("/all")
    public void delAllPermission(){

        permissionDao.deleteAll();
    }
}
