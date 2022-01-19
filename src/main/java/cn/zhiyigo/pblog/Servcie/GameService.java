package cn.zhiyigo.pblog.Servcie;

import cn.zhiyigo.pblog.Model.Book;
import cn.zhiyigo.pblog.Model.Game;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface GameService {

    Page<Game> getGames(PageRequest pageRequest,String name);
    List<Game> getAllGames();
    void addGame(Game game);

    Game getGameById(Integer id);

    void DelGame(Integer id);
}
