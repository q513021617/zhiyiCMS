package cn.zhiyigo.pblog.Model;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "seoinfo")
public class SeoInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(name = "site_name")
    String siteName;
    @Column(name = "site_description")
    String siteDescription;
    @Column(name = "update_time")
    Timestamp updateTime;
    @Column(name = "keywords")
    String keywords;
}
