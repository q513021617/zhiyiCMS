package cn.zhiyigo.pblog.Model;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "article_commit")
public class ArticleCommit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;


    @Column(name = "user_id")
    Integer userId;


    @Column(name = "article_id")
    String articleId;

    @Column(name = "commit_content")
    String commitContent;

    @Column(name = "create_time")
    Timestamp createTime;

    @Column(name = "update_time")
    Timestamp updateTime;
}
