package cn.zhiyigo.pblog.Controller.CommonController;

import cn.zhiyigo.pblog.Dao.SiteDataDao;
import cn.zhiyigo.pblog.Dao.SiteDataDao;
import cn.zhiyigo.pblog.Model.Response;
import cn.zhiyigo.pblog.Model.SiteData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class CommonSiteDataController {
    

    @Autowired
    private SiteDataDao siteDataDao;


    @GetMapping
    public List<SiteData> getSiteDataList(){

        return siteDataDao.findAll();
    }

    @GetMapping("/{id}")
    public Response getSiteDataByid(@PathVariable("id")Integer id){

        SiteData siteData = siteDataDao.findById(id).get();
        return Response.success(siteData);
    }


    @PostMapping
    public Response addSiteData(@RequestBody SiteData siteData){


        SiteData save = siteDataDao.save(siteData);
        return Response.success(save);
    }

    @DeleteMapping
    public void delOneSiteData(@RequestBody SiteData siteData){

        siteDataDao.delete(siteData);
    }

    @DeleteMapping("/all")
    public void delAllSiteData(){

        siteDataDao.deleteAll();
    }
}
