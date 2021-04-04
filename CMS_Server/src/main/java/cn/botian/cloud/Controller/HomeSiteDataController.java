package cn.botian.cloud.Controller;

import cn.botian.cloud.Controller.CommonController.CommonSiteDataController;
import cn.botian.cloud.Dao.SiteDataDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/siteData")
public class HomeSiteDataController extends CommonSiteDataController {
    

    @Autowired
    private SiteDataDao siteDataDao;

}
