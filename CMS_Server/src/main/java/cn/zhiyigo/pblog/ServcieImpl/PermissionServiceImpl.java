package cn.zhiyigo.pblog.ServcieImpl;

import cn.zhiyigo.pblog.Dao.PermissionDao;
import cn.zhiyigo.pblog.Model.Permission;
import cn.zhiyigo.pblog.Servcie.PermissionService;
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
