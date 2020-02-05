package cn.zhiyigo.pblog.Dao;

import cn.zhiyigo.pblog.Model.Role;
import cn.zhiyigo.pblog.Model.SeoInfo;
import org.springframework.data.jpa.repository.JpaRepository;


public interface SeoInfoDao extends JpaRepository<SeoInfo,Integer> {

}
