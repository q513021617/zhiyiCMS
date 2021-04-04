package cn.botian.cloud.Controller.CommonController;

import cn.botian.cloud.Dao.PhotoDao;
import cn.botian.cloud.Model.Photo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class CommonPhotoController {


    @Autowired
    private PhotoDao photoDao;


    @GetMapping("/")
    public List<Photo> getPhotoList(){

        return photoDao.findAll();
    }

    @GetMapping("/{id}")
    public Photo getPhotoByid(@PathVariable("id")Integer id){

        return  photoDao.findById(id).get();
    }

    @PutMapping("/")
    public Photo updatePhoto(Photo photo){


        return  photoDao.save(photo);
    }

    @PostMapping("/")
    public Photo addPhoto(Photo photo){


        return  photoDao.save(photo);
    }

    @PostMapping("/delete")
    public void delOnePhoto(Photo photo){

        photoDao.delete(photo);
    }

    @DeleteMapping("/all")
    public void delAllPhoto(){

        photoDao.deleteAll();
    }

}
