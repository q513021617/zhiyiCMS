package cn.botian.cloud.Dao;


import cn.botian.cloud.Model.WebUser;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.domain.Pageable;

public interface UserDao extends JpaRepository<WebUser,Integer> {

    WebUser findByusername(String userName);
    Page<WebUser> findAll(Pageable pageable);
}
