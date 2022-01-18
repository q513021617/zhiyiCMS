package cn.zhiyigo.pblog.Controller.CommonController;

import cn.zhiyigo.pblog.Dao.ArticleDao;
import cn.zhiyigo.pblog.Model.Article;
import cn.zhiyigo.pblog.Model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public class CommonAricleController {

        @Autowired
       private ArticleDao articleDao;

    @GetMapping
    public Response getArticleList(){

        List<Article> articleList = articleDao.findAll();
        return Response.success(articleList);
    }

    @GetMapping("/{id}")
    public Response getArticleByid(@PathVariable("id")Integer id){

        Article article = articleDao.findById(id).get();
        return Response.success(article);
    }


    @GetMapping("/{page}/{size}")
    public Response getArticleList(@PathVariable("page")String page, @PathVariable("size")int size){
        Pageable pageable = new PageRequest(Integer.parseInt(page),size);

        Page<Article> articles = articleDao.findAll(pageable);
        return Response.success(articles);
    }

    @PostMapping
    public Response addArticle(@RequestBody Article article){

        article.setPostTime(new Timestamp(new Date().getTime()));
        article.setUpdateTime(new Timestamp(new Date().getTime()));

        Article save = articleDao.save(article);
        return  Response.success(save);
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
