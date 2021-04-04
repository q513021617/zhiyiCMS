package cn.botian.cloud.Controller;

import cn.botian.cloud.Controller.CommonController.CommonPhotoController;
import cn.botian.cloud.Dao.PhotoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/photo")
public class HomePhotoController extends CommonPhotoController {


    @Autowired
    private PhotoDao photoDao;


}
