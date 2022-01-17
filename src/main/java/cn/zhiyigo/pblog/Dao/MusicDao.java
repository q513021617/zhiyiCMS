package cn.zhiyigo.pblog.Dao;

import cn.zhiyigo.pblog.Model.Book;
import cn.zhiyigo.pblog.Model.Music;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MusicDao extends JpaRepository<Music,Integer> {

}
