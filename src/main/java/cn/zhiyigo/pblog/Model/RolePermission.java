package cn.zhiyigo.pblog.Model;

import lombok.Data;

import javax.persistence.*;
import java.math.BigInteger;

@Data
@Entity
@Table(name = "role_permission")
public class RolePermission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @Column(name = "role_id")
    Integer roleId;
    @Column(name = "permission_id")
    Integer permissionId;
}
