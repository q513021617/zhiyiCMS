package cn.zhiyigo.pblog.Dao;

import cn.zhiyigo.pblog.Model.RolePermission;
import cn.zhiyigo.pblog.Model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRoleDao  extends JpaRepository<UserRole,Integer> {

}
