package cn.zhiyigo.pblog.Controller;

import cn.zhiyigo.pblog.Model.Book;
import cn.zhiyigo.pblog.Model.Game;
import cn.zhiyigo.pblog.Model.Music;
import cn.zhiyigo.pblog.Model.Response;
import cn.zhiyigo.pblog.Servcie.BookService;
import cn.zhiyigo.pblog.Servcie.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/music")
public class HomeMusicController {

    @Autowired
    private MusicService musicService;

    @GetMapping
    public Response getMusicList(@RequestParam(value = "page",required = false)Integer page,@RequestParam(value = "size",required = false)Integer size){
        if(page==null){
            List<Music> allGames = musicService.getAllMusics();
            return Response.success(allGames);
        }
        PageRequest pageRequest = new PageRequest(page,size);
        Page<Music> musics = musicService.getMusics(pageRequest);

        return Response.success(musics);
    }

    @GetMapping("/{id}")
    public Response getMusicByid(@PathVariable("id")Integer id){
        Music musics = musicService.getMusicById(id);
        return Response.success(musics);
    }



    @PostMapping
    public Response addMusic(@RequestBody Music music){

        musicService.addMusic(music);
        return  Response.success();
    }

    @DeleteMapping
    public Response delOneMusic(@RequestBody Music music){
        musicService.DelMusic(music.getId());
        return  Response.success();
    }

}
