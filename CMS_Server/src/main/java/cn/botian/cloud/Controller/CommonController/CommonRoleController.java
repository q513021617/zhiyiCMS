package cn.botian.cloud.Controller.CommonController;

import cn.botian.cloud.Dao.RoleDao;
import cn.botian.cloud.Model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class CommonRoleController {

    @Autowired
    private RoleDao roleDao;


    @GetMapping("/")
    public List<Role> getRoleList(){

        return roleDao.findAll();
    }

    @GetMapping("/{page}/{size}")
    public Page<Role> getListBypage(@PathVariable("page")String page, @PathVariable("size")int size){
        Pageable pageable = new PageRequest(Integer.parseInt(page),size);

        return roleDao.findAll(pageable);
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

    @PostMapping("/del")
    public void delOneRole(Role role){

        roleDao.delete(role);
    }

    @DeleteMapping("/all")
    public void delAllRole(){

        roleDao.deleteAll();
    }


}
