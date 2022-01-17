package cn.zhiyigo.pblog.Controller.CommonController;

import cn.zhiyigo.pblog.Dao.ArticleDao;
import cn.zhiyigo.pblog.Model.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public class CommonAricleController {

        @Autowired
       private ArticleDao articleDao;

    @GetMapping("/")
    public List<Article> getArticleList(){

        return articleDao.findAll();
    }

    @GetMapping("/{id}")
    public Article getArticleByid(@PathVariable("id")Integer id){

        return  articleDao.findById(id).get();
    }

    @PutMapping("/")
    public Article updateArticle(@RequestBody Article article){

        article.setPostTime(new Timestamp(new Date().getTime()));
        article.setUpdateTime(new Timestamp(new Date().getTime()));
        return  articleDao.save(article);
    }

    @GetMapping("/{page}/{size}")
    public Iterable<Article> getArticleList(@PathVariable("page")String page, @PathVariable("size")int size){
        Pageable pageable = new PageRequest(Integer.parseInt(page),size);

        return articleDao.findAll(pageable);
    }

    @PostMapping("/")
    public Article addArticle(@RequestBody Article article){

        article.setPostTime(new Timestamp(new Date().getTime()));
        article.setUpdateTime(new Timestamp(new Date().getTime()));
        return  articleDao.save(article);
    }

    @DeleteMapping("/")
    public void delOneArticle(@RequestBody Article article){

        articleDao.delete(article);
    }

    @DeleteMapping("/all")
    public void delAllArticle(){

        articleDao.deleteAll();
    }
}
