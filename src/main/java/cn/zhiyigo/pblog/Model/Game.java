package cn.zhiyigo.pblog.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@JsonIgnoreProperties(value={"hibernateLazyInitializer","handler","fieldHandler"})
@Table(name = "game")
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(name = "game_name")
    String gameName;

    @Column(name = "pic_url")
    String picUrl;

    @Column(name = "rom_url")
    String romUrl;

    @Column(name = "create_time")
    Timestamp createTime;

    @Column(name = "update_time")
    Timestamp updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getRomUrl() {
        return romUrl;
    }

    public void setRomUrl(String romUrl) {
        this.romUrl = romUrl;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }
}
