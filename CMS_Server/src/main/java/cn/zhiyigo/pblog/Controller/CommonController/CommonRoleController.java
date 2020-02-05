package cn.zhiyigo.pblog.Controller.CommonController;

import cn.zhiyigo.pblog.Dao.RoleDao;
import cn.zhiyigo.pblog.Model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class CommonRoleController {

    @Autowired
    private RoleDao roleDao;


    @GetMapping("/")
    public List<Role> getRoleList(){

        return roleDao.findAll();
    }

    @GetMapping("/{id}")
    public Role getRoleByid(@PathVariable("id")Integer id){

        return  roleDao.findById(id).get();
    }

    @PutMapping("/")
    public Role updateRole(Role role){


        return  roleDao.save(role);
    }

    @PostMapping("/")
    public Role addRole(Role role){


        return  roleDao.save(role);
    }

    @DeleteMapping("/")
    public void delOneRole(Role role){

        roleDao.delete(role);
    }

    @DeleteMapping("/all")
    public void delAllRole(){

        roleDao.deleteAll();
    }


}
