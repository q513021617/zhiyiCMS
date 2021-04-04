package cn.botian.cloud.ServcieImpl;

import cn.botian.cloud.Dao.UserDao;
import cn.botian.cloud.Model.WebUser;
import cn.botian.cloud.Servcie.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public WebUser findByusername(String userName) {
        return userDao.findByusername(userName);
    }
}
