package cn.zhiyigo.pblog.Controller.CommonController;

import cn.zhiyigo.pblog.Dao.UserDao;
import cn.zhiyigo.pblog.Model.Response;
import cn.zhiyigo.pblog.Model.WebUser;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

public class CommonUserController {

    @Autowired
    private UserDao userDao;

    @GetMapping
    public Response getUserList(){

        List<WebUser> userDaoAll = userDao.findAll();
        return Response.success(userDaoAll);
    }


    @GetMapping("/{page}/{size}")
    public Response getUserList(@PathVariable("page")String page,@PathVariable("size")int size){
        Pageable pageable = new PageRequest(Integer.parseInt(page),size);

        Page<WebUser> webUsers = userDao.findAll(pageable);
        return Response.success(webUsers);
    }

    @GetMapping("/{id}")
    public Response getUserByid(@PathVariable("id")Integer userid){

      Optional<WebUser> tempuser=userDao.findById(userid);
        WebUser webUser = tempuser.orElse(null);
        return Response.success(webUser);
    }


    @PostMapping
    public Response addUser(@RequestBody WebUser webUser){


        WebUser user = userDao.save(webUser);
        return Response.success(user);
    }

    @DeleteMapping
    public void delOneUser(@RequestBody WebUser webUser){

        userDao.delete(webUser);
    }

    @DeleteMapping("/all")
    public void delAllUser(){

        userDao.deleteAll();
    }

}
