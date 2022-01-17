package cn.zhiyigo.pblog.Servcie;

import cn.zhiyigo.pblog.Model.ArticleCommit;
import cn.zhiyigo.pblog.Model.ArticleCommitVo;


import java.util.List;

public interface ArticleCommitService {

    List<ArticleCommitVo> getArticleCommit(Integer article);

    void addArticleCommit(ArticleCommit articleCommit);
}
