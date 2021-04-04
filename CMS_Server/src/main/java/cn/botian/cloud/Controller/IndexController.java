package cn.botian.cloud.Controller;

import cn.botian.cloud.Dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
public class IndexController {

    @Autowired
    UserDao userDao;



    @RequestMapping("/")
    public String index(Map<String,Object> map){
//        List<User> userList=userDao.findAll();
//        map.put("data",userList);
        return "index";
    }

    @RequestMapping("/skill")
    public String skill(Map<String,Object> map){
//        List<User> userList=userDao.findAll();
//        map.put("data",userList);
        return "skilltree";
    }
}
