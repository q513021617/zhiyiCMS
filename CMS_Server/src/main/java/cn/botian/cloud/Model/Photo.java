package cn.botian.cloud.Model;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "photo")
public class Photo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(name = "photo_name")
    String photoName;

    @Column(name = "src_url")
    String srcUrl;

    @Column(name = "upload_time")
    Timestamp uploadTime;

}
