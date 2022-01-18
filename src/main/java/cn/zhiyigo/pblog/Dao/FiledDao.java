package cn.zhiyigo.pblog.Dao;

import cn.zhiyigo.pblog.Model.Article;
import cn.zhiyigo.pblog.Model.Filed;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FiledDao extends JpaRepository<Filed,Integer> {

    List<Filed> findAllByTableName(String word);
}
