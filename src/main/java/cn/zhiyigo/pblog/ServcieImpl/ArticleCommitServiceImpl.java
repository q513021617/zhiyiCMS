package cn.zhiyigo.pblog.ServcieImpl;

import cn.zhiyigo.pblog.Dao.ArticleCommitDao;
import cn.zhiyigo.pblog.Dao.BookMarkTagDao;
import cn.zhiyigo.pblog.Dao.UserDao;
import cn.zhiyigo.pblog.Model.ArticleCommit;
import cn.zhiyigo.pblog.Model.ArticleCommitVo;
import cn.zhiyigo.pblog.Model.WebUser;
import cn.zhiyigo.pblog.Servcie.ArticleCommitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ArticleCommitServiceImpl implements ArticleCommitService {

    @Autowired
    ArticleCommitDao articleCommitDao;

    @Autowired
    UserDao userDao;

    @Override
    public List<ArticleCommitVo> getArticleCommit(Integer article) {

        return articleCommitDao.getArticleCommitListByArticleId(article);
    }

    @Override
    public void addArticleCommit(ArticleCommit articleCommit) {

        articleCommit.setCreateTime(new Timestamp(new Date().getTime()));
        articleCommit.setUpdateTime(new Timestamp(new Date().getTime()));
        articleCommitDao.save(articleCommit);
    }


}
