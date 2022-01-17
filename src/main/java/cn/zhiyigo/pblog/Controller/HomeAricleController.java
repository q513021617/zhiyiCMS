package cn.zhiyigo.pblog.Controller;

import cn.zhiyigo.pblog.Dao.ArticleDao;
import cn.zhiyigo.pblog.Model.Article;
import cn.zhiyigo.pblog.Model.ArticleCommit;
import cn.zhiyigo.pblog.Model.ArticleCommitVo;
import cn.zhiyigo.pblog.Model.Response;
import cn.zhiyigo.pblog.Servcie.ArticleCommitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/aricle")
public class HomeAricleController  {
    @Autowired
    private ArticleDao articleDao;

    @Autowired
    ArticleCommitService articleCommitService;

    @GetMapping("/{page}/{size}")
    public Iterable<Article> getArticleList(@PathVariable("page")String page, @PathVariable("size")int size){
        Pageable pageable = new PageRequest(Integer.parseInt(page),size);

        return articleDao.findAll(pageable);
    }

    @GetMapping("/articleCommit/{id}")
    public Response getArticleCommitList(@PathVariable("id")Integer id){
        List<ArticleCommitVo> articleCommit = articleCommitService.getArticleCommit(id);

        return Response.success(articleCommit);
    }

    @PostMapping("/addArticleCommit")
    public Response addArticleCommit(@RequestBody ArticleCommit articleCommit){

         articleCommitService.addArticleCommit(articleCommit);

        return Response.success();
    }

    @GetMapping("/{id}")
    public Article getArticleByid(@PathVariable("id")Integer id){

        return  articleDao.findById(id).get();
    }

    @GetMapping("/search/{word}")
    public Iterable<Article> getArticleBysearch(@PathVariable("word")String word){

        return  articleDao.findAllByWord(word);
    }
}
