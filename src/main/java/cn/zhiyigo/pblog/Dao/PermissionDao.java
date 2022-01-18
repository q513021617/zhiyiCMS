package cn.zhiyigo.pblog.Dao;

import cn.zhiyigo.pblog.Model.Banner;
import cn.zhiyigo.pblog.Model.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface PermissionDao extends JpaRepository<Permission,Integer> {
    @Modifying
    @Query(value="select permission.*\n" +
            "from user\n" +
            "left join user_role\n" +
            "on user.id = user_role.userid\n" +
            "left join role\n" +
            "on role.id = user_role.roleid\n" +
            "left join role_permission\n" +
            "on role_permission.role_id = role.id\n" +
            "left join permission\n" +
            "on permission.id = role_permission.permission_id\n" +
            "where user.id:userid",nativeQuery = true)
    @Transactional
    List<Permission> selectByUserId(@Param("userid") Integer userid);

    List<Permission> findAllByEnname(String name);
}
