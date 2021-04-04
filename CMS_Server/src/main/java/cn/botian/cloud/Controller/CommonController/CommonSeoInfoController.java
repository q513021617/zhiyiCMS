package cn.botian.cloud.Controller.CommonController;

import cn.botian.cloud.Model.SeoInfo;
import cn.botian.cloud.Dao.SeoInfoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class CommonSeoInfoController {

    @Autowired
    private SeoInfoDao seoInfoDao;


    @GetMapping("/")
    public List<SeoInfo> getSeoInfoList(){

        return seoInfoDao.findAll();
    }

    @GetMapping("/{id}")
    public SeoInfo getSeoInfoByid(@PathVariable("id")Integer id){

        return  seoInfoDao.findById(id).get();
    }

    @PutMapping("/")
    public SeoInfo updateSeoInfo(SeoInfo seoInfo){


        return  seoInfoDao.save(seoInfo);
    }

    @PostMapping("/")
    public SeoInfo addSeoInfo(SeoInfo seoInfo){


        return  seoInfoDao.save(seoInfo);
    }

    @DeleteMapping("/")
    public void delOneSeoInfo(SeoInfo seoInfo){

        seoInfoDao.delete(seoInfo);
    }

    @DeleteMapping("/all")
    public void delAllSeoInfo(){

        seoInfoDao.deleteAll();
    }
}
