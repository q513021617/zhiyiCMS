package cn.zhiyigo.pblog.Dao;

import cn.zhiyigo.pblog.Model.ArticleCommit;

import cn.zhiyigo.pblog.Model.ArticleCommitVo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ArticleCommitDao extends JpaRepository<ArticleCommit,Integer> {

    @Query(nativeQuery=true,value="select article_commit.id as id ,article_commit.user_id,article_id,article_commit.commit_content,article_commit.create_time,article_commit.update_time,`user`.username as user_name,`user`.avatar as user_avatars \n" +
            "from article_commit\n" +
            "LEFT JOIN article on article.id=article_commit.article_id\n" +
            "LEFT JOIN `user` on article_commit.user_id = `user`.id\n" +
            "WHERE article.id = ?1")
    List<ArticleCommitVo> getArticleCommitListByArticleId(Integer articleid);
}
