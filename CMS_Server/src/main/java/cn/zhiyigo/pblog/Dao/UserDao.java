package cn.zhiyigo.pblog.Dao;


import cn.zhiyigo.pblog.Model.WebUser;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.domain.Pageable;
import java.util.List;

public interface UserDao extends JpaRepository<WebUser,Integer> {

    WebUser findByusername(String userName);
    Page<WebUser> findAll(Pageable pageable);
}
