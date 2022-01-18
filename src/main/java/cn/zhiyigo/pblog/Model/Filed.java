package cn.zhiyigo.pblog.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@JsonIgnoreProperties(value={"hibernateLazyInitializer","handler","fieldHandler"})
@Table(name = "filed")
public class Filed {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(name = "filed_name")
    String filedName;

    @Column(name = "filed_cn_name")
    String filedCnName;

    @Column(name = "table_name")
    String tableName;


    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFiledName() {
        return filedName;
    }

    public void setFiledName(String filedName) {
        this.filedName = filedName;
    }

    public String getFiledCnName() {
        return filedCnName;
    }

    public void setFiledCnName(String filedCnName) {
        this.filedCnName = filedCnName;
    }
}
