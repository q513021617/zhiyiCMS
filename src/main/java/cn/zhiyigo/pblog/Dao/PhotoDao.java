package cn.zhiyigo.pblog.Dao;

import cn.zhiyigo.pblog.Model.Photo;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PhotoDao extends JpaRepository<Photo,Integer> {

}
