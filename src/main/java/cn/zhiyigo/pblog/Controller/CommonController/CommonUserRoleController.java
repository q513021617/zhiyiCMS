package cn.zhiyigo.pblog.Controller.CommonController;

import cn.zhiyigo.pblog.Dao.UserRoleDao;
import cn.zhiyigo.pblog.Dao.UserRoleDao;
import cn.zhiyigo.pblog.Model.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class CommonUserRoleController {
    @Autowired
    private UserRoleDao userRoleDao;

    @GetMapping("/")
    public List<UserRole> getPermissioList(){

        return userRoleDao.findAll();
    }

    @GetMapping("/{id}")
    public UserRole getUserRoleByid(@PathVariable("id")Integer id){

        return  userRoleDao.findById(id).get();
    }

    @PutMapping("/")
    public UserRole updateUserRole(UserRole userRole){


        return  userRoleDao.save(userRole);
    }

    @PostMapping("/")
    public UserRole addUserRole(UserRole userRole){


        return  userRoleDao.save(userRole);
    }

    @DeleteMapping("/")
    public void delOneUserRole(UserRole userRole){

        userRoleDao.delete(userRole);
    }

    @DeleteMapping("/all")
    public void delAllUserRole(){

        userRoleDao.deleteAll();
    }
}
