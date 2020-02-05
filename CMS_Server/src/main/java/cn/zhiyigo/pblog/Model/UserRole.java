package cn.zhiyigo.pblog.Model;

import lombok.Data;

import javax.persistence.*;
import java.math.BigInteger;

@Data
@Entity
@Table(name = "user_role")
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "userid")
    private Integer userid;

    @Column(name = "roleid")
    private Integer roleid;
}
