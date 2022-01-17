package cn.zhiyigo.pblog.ServcieImpl;

import cn.zhiyigo.pblog.Dao.GameDao;
import cn.zhiyigo.pblog.Model.Game;
import cn.zhiyigo.pblog.Servcie.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class GameServiceImpl implements GameService {

    @Autowired
    GameDao gameDao;

    @Override
    public Page<Game> getGames(PageRequest pageRequest,String name) {
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withMatcher("gameName", ExampleMatcher.GenericPropertyMatchers.startsWith());

        Game game=new Game();
        game.setGameName(name);
        Example<Game> example = Example.of(game,matcher);

        return gameDao.findAll(example,pageRequest);
    }

    @Override
    public void addGame(Game game) {
        gameDao.save(game);
    }

    @Override
    public Game getGameById(Integer id) {

        return gameDao.getOne(id);
    }

    @Override
    public void DelGame(Integer id) {
        gameDao.deleteById(id);
    }

}
