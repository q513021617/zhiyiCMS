package cn.botian.cloud.Model;

import lombok.Data;

import javax.persistence.*;
import java.math.BigInteger;
import java.sql.Date;

@Data
@Entity
@Table(name = "permission")
public class Permission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(name = "parent_id")
    Integer parent_id;
//    权限中文名称
    @Column(name = "name")
    String name;
//权限英文名
    @Column(name = "enname")
    String enname;

    @Column(name = "url")
    String url;

    @Column(name = "description")
    String description;

    @Column(name = "created")
    Date created;

    @Column(name = "updated")
    Date updated;




}
