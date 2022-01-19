package cn.zhiyigo.pblog.Controller;

import cn.zhiyigo.pblog.Model.Game;
import cn.zhiyigo.pblog.Model.Response;
import cn.zhiyigo.pblog.Servcie.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/game")
public class HomeGameController {

    @Autowired
    private GameService gameService;

    @GetMapping
    public Response getGameList(@RequestParam(value = "page",required = false)Integer page, @RequestParam(value = "size",required = false)Integer size,@RequestParam(value = "keyword",required = false)String keyword){
        if(page==null){
            List<Game> allGames = gameService.getAllGames();
            return Response.success(allGames);
        }
        PageRequest pageRequest = new PageRequest(page,size);

        Page<Game> Games = gameService.getGames(pageRequest,keyword);

        return Response.success(Games);
    }

    @GetMapping("/{id}")
    public Response getGameByid(@PathVariable("id")Integer id){
        Game Games = gameService.getGameById(id);
        return Response.success(Games);
    }



    @PostMapping
    public Response addGame(@RequestBody Game Game){

        gameService.addGame(Game);
        return  Response.success();
    }

    @DeleteMapping
    public Response delOneGame(@RequestBody Game game){
        gameService.DelGame(game.getId());
        return  Response.success();
    }
}
