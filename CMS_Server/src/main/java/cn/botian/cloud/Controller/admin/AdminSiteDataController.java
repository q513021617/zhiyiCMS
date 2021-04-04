package cn.botian.cloud.Controller.admin;

import cn.botian.cloud.Controller.CommonController.CommonSiteDataController;
import cn.botian.cloud.Dao.SiteDataDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/siteData")
public class AdminSiteDataController extends CommonSiteDataController {
    

    @Autowired
    private SiteDataDao siteDataDao;


}
