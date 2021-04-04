package cn.botian.cloud.Servcie;

import cn.botian.cloud.Model.WebUser;

public interface UserService {

    WebUser findByusername(String userName);
}
