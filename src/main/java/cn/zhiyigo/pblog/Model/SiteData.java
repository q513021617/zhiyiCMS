package cn.zhiyigo.pblog.Model;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "sitedata")
public class SiteData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    //站点浏览量
    @Column(name = "site_pv")
    Integer sitePV;
    //站点访客量  按IP算
    @Column(name = "site_uv")
    Integer siteUV;
//   页面浏览量
    @Column(name = "page_pv")
    Integer pagePV;
//    页面访客量
    @Column(name = "page_uv")
    Integer pageUV;
//    注册用户数
    @Column(name = "register_count")
    Integer registerCount;
//    登录用户数
    @Column(name = "login_count")
    Integer loginCount;
    @Column(name = "count_time")
    Timestamp countTime;
}
