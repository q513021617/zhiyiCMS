package cn.zhiyigo.pblog.ServcieImpl;

import cn.zhiyigo.pblog.Dao.UserDao;
import cn.zhiyigo.pblog.Model.WebUser;
import cn.zhiyigo.pblog.Servcie.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDao userDao;

    @Override
    public WebUser findByusername(String userName) {
        return userDao.findByusername(userName);
    }
}
