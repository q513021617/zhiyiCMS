package cn.zhiyigo.pblog.Dao;

import cn.zhiyigo.pblog.Model.Article;
import cn.zhiyigo.pblog.Model.Banner;
import cn.zhiyigo.pblog.Model.WebUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ArticleDao extends JpaRepository<Article,Integer> {

    Page<Article> findAll(Pageable pageable);
    @Query(value="select * from article where article_content like %?1% or title like %?1%",nativeQuery=true)
    List<Article> findAllByWord(String word);
}
