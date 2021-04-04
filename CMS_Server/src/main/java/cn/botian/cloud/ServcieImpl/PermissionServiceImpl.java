package cn.botian.cloud.ServcieImpl;

import cn.botian.cloud.Dao.PermissionDao;
import cn.botian.cloud.Model.Permission;
import cn.botian.cloud.Servcie.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionDao permissionDao;

    @Override
    public List<Permission> selectByUserId(Integer userid) {

        return permissionDao.selectByUserId(userid);

    }

}
