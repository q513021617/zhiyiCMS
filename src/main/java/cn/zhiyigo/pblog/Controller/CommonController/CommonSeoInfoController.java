package cn.zhiyigo.pblog.Controller.CommonController;

import cn.zhiyigo.pblog.Dao.RoleDao;
import cn.zhiyigo.pblog.Dao.SeoInfoDao;
import cn.zhiyigo.pblog.Model.Response;
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


    @GetMapping
    public Response getSeoInfoList(){

        List<SeoInfo> seoInfoDaoAll = seoInfoDao.findAll();
        return Response.success(seoInfoDaoAll);
    }

    @GetMapping("/getOne")
    public Response getSeoInfoByid(){
        SeoInfo seoInfo=new SeoInfo();
        Example<SeoInfo> infoExample = Example.of(seoInfo);
        Optional<SeoInfo> infoDaoOne = seoInfoDao.findOne(infoExample);

        SeoInfo tempSeoInfo=infoDaoOne.isPresent()?infoDaoOne.get():seoInfo;
        return Response.success(tempSeoInfo);
    }



    @PostMapping
    public Response addSeoInfo(@RequestBody  SeoInfo seoInfo){


        SeoInfo save = seoInfoDao.save(seoInfo);
        return Response.success(save);
    }

    @DeleteMapping
    public void delOneSeoInfo(@RequestBody  SeoInfo seoInfo){

        seoInfoDao.delete(seoInfo);
    }

    @DeleteMapping("/all")
    public void delAllSeoInfo(){

        seoInfoDao.deleteAll();
    }
}
