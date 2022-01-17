package cn.zhiyigo.pblog.Controller.CommonController;

import cn.zhiyigo.pblog.Dao.RoleDao;
import cn.zhiyigo.pblog.Dao.SeoInfoDao;
import cn.zhiyigo.pblog.Model.Role;
import cn.zhiyigo.pblog.Model.SeoInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

public class CommonSeoInfoController {

    @Autowired
    private SeoInfoDao seoInfoDao;


    @GetMapping("/")
    public List<SeoInfo> getSeoInfoList(){

        return seoInfoDao.findAll();
    }

    @GetMapping("/getOne")
    public SeoInfo getSeoInfoByid(){
        SeoInfo seoInfo=new SeoInfo();
        Example<SeoInfo> infoExample = Example.of(seoInfo);
        Optional<SeoInfo> infoDaoOne = seoInfoDao.findOne(infoExample);

        return  infoDaoOne.isPresent()?infoDaoOne.get():seoInfo;
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
