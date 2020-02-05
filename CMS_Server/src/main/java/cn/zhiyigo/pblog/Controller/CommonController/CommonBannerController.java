package cn.zhiyigo.pblog.Controller.CommonController;

import cn.zhiyigo.pblog.Dao.BannerDao;
import cn.zhiyigo.pblog.Model.Banner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class CommonBannerController {
    @Autowired
    private BannerDao bannerDao;


    @GetMapping("/")
    public List<Banner> getBannerList(){

        return bannerDao.findAll();
    }

    @GetMapping("/{id}")
    public Banner getBannerByid(@PathVariable("id")Integer id){

        return  bannerDao.findById(id).get();
    }

    @PutMapping("/")
    public Banner updateMenu(Banner banner){


        return  bannerDao.save(banner);
    }

    @PostMapping("/")
    public Banner addBanner(Banner banner){


        return  bannerDao.save(banner);
    }

    @DeleteMapping("/")
    public void delOneBanner(Banner banner){

        bannerDao.delete(banner);
    }

    @DeleteMapping("/all")
    public void delAllBanner(){

        bannerDao.deleteAll();
    }
}
