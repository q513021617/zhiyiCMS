package cn.zhiyigo.pblog.Servcie;

import cn.zhiyigo.pblog.Model.WebUser;

public interface UserService {

    WebUser findByusername(String userName);
}
