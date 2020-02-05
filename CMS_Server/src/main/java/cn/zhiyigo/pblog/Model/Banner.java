package cn.zhiyigo.pblog.Model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "banner")
public class Banner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;


    @Column(name = "banner_name")
    String bannerName;


    @Column(name = "banner_url")
    String bannerUrl;
}
