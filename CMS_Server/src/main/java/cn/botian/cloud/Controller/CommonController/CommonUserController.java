package cn.botian.cloud.Controller.CommonController;

import cn.botian.cloud.Model.WebUser;
import cn.botian.cloud.Dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public class CommonUserController {

    @Autowired
    private UserDao userDao;

    @GetMapping("/")
    public List<WebUser> getUserList(){

        return userDao.findAll();
    }


    @GetMapping("/{page}/{size}")
    public Iterable<WebUser> getUserList(@PathVariable("page")String page,@PathVariable("size")int size){
        Pageable pageable = new PageRequest(Integer.parseInt(page),size);

        return userDao.findAll(pageable);
    }

    @GetMapping("/{id}")
    public WebUser getUserByid(@PathVariable("id")Integer userid){

      Optional<WebUser> tempuser=userDao.findById(userid);
        return tempuser.orElse(null);
    }

    @PutMapping("/")
    public WebUser updateUser(WebUser webUser){


        return  userDao.save(webUser);
    }

    @PostMapping("/")
    public WebUser addUser(WebUser webUser){


        return  userDao.save(webUser);
    }

    @PostMapping("/del/")
    public Object delOneUser(WebUser webUser){

        userDao.delete(webUser);
        return new HashMap<>();
    }

    @DeleteMapping("/all")
    public Object delAllUser(){

        userDao.deleteAll();
        return new HashMap<>();
    }

}
