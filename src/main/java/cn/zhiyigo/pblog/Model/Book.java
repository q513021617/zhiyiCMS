package cn.zhiyigo.pblog.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@JsonIgnoreProperties(value={"hibernateLazyInitializer","handler","fieldHandler"})
@Table(name = "book")
public class Book implements Serializable {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(name = "bookname")
    String bookname;
    @Column(name = "author")
    String author;
    @Column(name = "imgurl")
    String imgurl;
    @Column(name = "bookdes")
    String bookdes;
    @Column(name = "bookUrl")
    String bookUrl;
}
