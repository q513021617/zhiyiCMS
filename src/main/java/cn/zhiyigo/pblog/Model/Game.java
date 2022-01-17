package cn.zhiyigo.pblog.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
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
}
