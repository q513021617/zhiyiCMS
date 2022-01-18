package cn.zhiyigo.pblog.Controller.CommonController;

import cn.zhiyigo.pblog.Dao.PhotoDao;
import cn.zhiyigo.pblog.Model.Photo;
import cn.zhiyigo.pblog.Model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class CommonPhotoController {


    @Autowired
    private PhotoDao photoDao;


    @GetMapping
    public Response getPhotoList(){

        List<Photo> photoDaoAll = photoDao.findAll();
        return Response.success(photoDaoAll);
    }

    @GetMapping("/{id}")
    public Response getPhotoByid(@PathVariable("id")Integer id){

        Photo photo = photoDao.findById(id).get();
        return Response.success(photo);
    }



    @PostMapping("/")
    public Response addPhoto(@RequestBody Photo photo){


        Photo photosave = photoDao.save(photo);
        return Response.success(photosave);
    }

    @DeleteMapping("/")
    public void delOnePhoto(@RequestBody Photo photo){

        photoDao.delete(photo);
    }

    @DeleteMapping("/all")
    public void delAllPhoto(){

        photoDao.deleteAll();
    }

}
