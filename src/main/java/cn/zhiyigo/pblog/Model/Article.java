package cn.zhiyigo.pblog.Model;


import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "article")
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(name = "title")
    String title;
    @Column(name = "article_content")
    String articleContent;
    @Column(name = "article_comment_id")
    Integer articleCommentId;

    @Column(name = "post_time")
    Timestamp postTime;
    @Column(name = "update_time")
    Timestamp updateTime;
}
