package cn.zhiyigo.pblog.Servcie;

import cn.zhiyigo.pblog.Model.Book;
import cn.zhiyigo.pblog.Model.Music;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface MusicService {

    Page<Music> getMusics(PageRequest pageRequest);
    List<Music> getAllMusics();
    void addMusic(Music book);
    Music getMusicById(Integer id);
    void DelMusic(Integer id);
}
