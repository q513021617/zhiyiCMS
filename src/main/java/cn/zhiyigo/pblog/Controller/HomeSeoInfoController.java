package cn.zhiyigo.pblog.Controller;

import cn.zhiyigo.pblog.Controller.CommonController.CommonSeoInfoController;
import cn.zhiyigo.pblog.Dao.SeoInfoDao;
import cn.zhiyigo.pblog.Model.SeoInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/seoInfo")
public class HomeSeoInfoController extends CommonSeoInfoController {

    @Autowired
    private SeoInfoDao seoInfoDao;

}
