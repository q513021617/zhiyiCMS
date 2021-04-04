package cn.botian.cloud.Controller.admin;

import cn.botian.cloud.Controller.CommonController.CommonPhotoController;
import cn.botian.cloud.Dao.PhotoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/photo")
public class AdminPhotoController extends CommonPhotoController {


    @Autowired
    private PhotoDao photoDao;



}
