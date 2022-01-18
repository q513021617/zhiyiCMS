package cn.zhiyigo.pblog.Controller.CommonController;

import cn.zhiyigo.pblog.Dao.BannerDao;
import cn.zhiyigo.pblog.Model.Banner;
import cn.zhiyigo.pblog.Model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class CommonBannerController {

    @Autowired
    private BannerDao bannerDao;


    @GetMapping
    public Response getBannerList(){

        List<Banner> bannerList = bannerDao.findAll();
        return Response.success(bannerList);
    }

    @GetMapping("/{id}")
    public Response getBannerByid(@PathVariable("id")Integer id){
        Banner banner = bannerDao.findById(id).get();
        return Response.success(banner);
    }

    @PostMapping
    public Response addBanner(@RequestBody Banner banner){


        Banner save = bannerDao.save(banner);
        return Response.success(save);
    }

    @DeleteMapping
    public void delOneBanner(@RequestBody Banner banner){

        bannerDao.delete(banner);
    }

    @DeleteMapping("/all")
    public void delAllBanner(){

        bannerDao.deleteAll();
    }
}
