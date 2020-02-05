package cn.zhiyigo.pblog.Controller.admin;

import cn.zhiyigo.pblog.Controller.CommonController.CommonPhotoController;
import cn.zhiyigo.pblog.Dao.PhotoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/photo")
public class AdminPhotoController extends CommonPhotoController {


    @Autowired
    private PhotoDao photoDao;



}
