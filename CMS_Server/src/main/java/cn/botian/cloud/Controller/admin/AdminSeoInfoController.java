package cn.botian.cloud.Controller.admin;

import cn.botian.cloud.Controller.CommonController.CommonSeoInfoController;
import cn.botian.cloud.Dao.SeoInfoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/seoInfo")
public class AdminSeoInfoController extends CommonSeoInfoController {

    @Autowired
    private SeoInfoDao seoInfoDao;



}
