package cn.zhiyigo.pblog.Model;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "book_mark_tag")
public class BookMarkTag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(name = "book_id")
    Integer bookId;

    @Column(name = "user_id")
    Integer userId;

    @Column(name = "book_page")
    Integer bookPage;

    @Column(name = "book_mark_tag_content")
    String bookTagContent;

    @Column(name = "create_time")
    Timestamp createTime;

    @Column(name = "update_time")
    Timestamp updateTime;
}
