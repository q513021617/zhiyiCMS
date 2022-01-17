package cn.zhiyigo.pblog.Controller;

import cn.zhiyigo.pblog.Controller.CommonController.CommonPhotoController;
import cn.zhiyigo.pblog.Dao.PhotoDao;
import cn.zhiyigo.pblog.Model.Photo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/photo")
public class HomePhotoController extends CommonPhotoController {


    @Autowired
    private PhotoDao photoDao;


}
