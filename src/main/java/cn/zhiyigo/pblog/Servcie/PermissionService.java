package cn.zhiyigo.pblog.Servcie;

import cn.zhiyigo.pblog.Model.Permission;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PermissionService {

    List<Permission> selectByUserId(Integer userid);
    List<Permission> selectByName(String name);
}
