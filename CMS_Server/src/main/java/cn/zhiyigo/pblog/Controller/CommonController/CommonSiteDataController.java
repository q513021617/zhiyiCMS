package cn.zhiyigo.pblog.Controller.CommonController;

import cn.zhiyigo.pblog.Dao.SiteDataDao;
import cn.zhiyigo.pblog.Dao.SiteDataDao;
import cn.zhiyigo.pblog.Model.SiteData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class CommonSiteDataController {
    

    @Autowired
    private SiteDataDao siteDataDao;


    @GetMapping("/")
    public List<SiteData> getSiteDataList(){

        return siteDataDao.findAll();
    }

    @GetMapping("/{id}")
    public SiteData getSiteDataByid(@PathVariable("id")Integer id){

        return  siteDataDao.findById(id).get();
    }

    @PutMapping("/")
    public SiteData updateSiteData(SiteData siteData){


        return  siteDataDao.save(siteData);
    }

    @PostMapping("/")
    public SiteData addSiteData(SiteData siteData){


        return  siteDataDao.save(siteData);
    }

    @DeleteMapping("/")
    public void delOneSiteData(SiteData siteData){

        siteDataDao.delete(siteData);
    }

    @DeleteMapping("/all")
    public void delAllSiteData(){

        siteDataDao.deleteAll();
    }
}
