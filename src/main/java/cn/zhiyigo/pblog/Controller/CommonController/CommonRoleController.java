package cn.zhiyigo.pblog.Controller.CommonController;

import cn.zhiyigo.pblog.Dao.RoleDao;
import cn.zhiyigo.pblog.Model.Response;
import cn.zhiyigo.pblog.Model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class CommonRoleController {

    @Autowired
    private RoleDao roleDao;


    @GetMapping
    public Response getRoleList(){

        List<Role> roleDaoAll = roleDao.findAll();
        return Response.success(roleDaoAll);
    }

    @GetMapping("/{id}")
    public Response getRoleByid(@PathVariable("id")Integer id){

        Role role = roleDao.findById(id).get();
        return Response.success(role);
    }



    @PostMapping
    public Response addRole(@RequestBody Role role){


        Role save = roleDao.save(role);
        return Response.success(save);
    }

    @DeleteMapping("/")
    public void delOneRole(@RequestBody Role role){

        roleDao.delete(role);
    }

    @DeleteMapping("/all")
    public void delAllRole(){

        roleDao.deleteAll();
    }


}
