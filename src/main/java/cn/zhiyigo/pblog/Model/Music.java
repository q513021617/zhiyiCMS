package cn.zhiyigo.pblog.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;


@Entity
@JsonIgnoreProperties(value={"hibernateLazyInitializer","handler","fieldHandler"})
@Table(name = "music")
public class Music {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String title;
    String author;
    String url;
    String pic;
//    歌词文本
    String lrc;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getLrc() {
        return lrc;
    }

    public void setLrc(String lrc) {
        this.lrc = lrc;
    }
}
