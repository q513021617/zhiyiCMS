package cn.zhiyigo.pblog.Dao;

import cn.zhiyigo.pblog.Model.BookMarkTag;
import cn.zhiyigo.pblog.Model.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameDao extends JpaRepository<Game,Integer> {

}
