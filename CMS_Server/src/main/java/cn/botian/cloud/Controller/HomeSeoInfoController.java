package cn.botian.cloud.Controller;

import cn.botian.cloud.Controller.CommonController.CommonSeoInfoController;
import cn.botian.cloud.Dao.SeoInfoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/seoInfo")
public class HomeSeoInfoController extends CommonSeoInfoController {

    @Autowired
    private SeoInfoDao seoInfoDao;

}
