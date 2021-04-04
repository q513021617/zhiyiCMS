package cn.botian.cloud.Servcie;

import cn.botian.cloud.Model.Permission;

import java.util.List;

public interface PermissionService {

    List<Permission> selectByUserId(Integer userid);
}
