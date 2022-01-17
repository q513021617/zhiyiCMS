package cn.zhiyigo.pblog.Dao;

import cn.zhiyigo.pblog.Model.Permission;
import cn.zhiyigo.pblog.Model.RolePermission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolePermissionDao extends JpaRepository<RolePermission,Integer> {

}
