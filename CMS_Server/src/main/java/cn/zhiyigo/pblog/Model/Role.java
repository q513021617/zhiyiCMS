package cn.zhiyigo.pblog.Model;

import lombok.Data;

import javax.persistence.*;
import java.math.BigInteger;
import java.sql.Date;

@Data
@Entity
@Table(name = "role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(name = "parent_id")
    Integer parentId;
//角色名
    @Column(name = "name")
    String name;
    //角色名_英文
    @Column(name = "enname")
    String enname;

    @Column(name = "description")
    String description;

    @Column(name = "created")
    Date created;

    @Column(name = "updated")
    Date updated;
}
