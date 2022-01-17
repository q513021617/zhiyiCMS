package cn.zhiyigo.pblog.ServcieImpl;

import cn.zhiyigo.pblog.Dao.MusicDao;
import cn.zhiyigo.pblog.Model.Music;
import cn.zhiyigo.pblog.Servcie.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class MusicServiceImpl implements MusicService {

    @Autowired
    MusicDao musicDao;

    @Override
    public Page<Music> getMusics(PageRequest pageRequest) {

        return musicDao.findAll(pageRequest);
    }

    @Override
    public void addMusic(Music music) {
        musicDao.save(music);
    }

    @Override
    public Music getMusicById(Integer id) {

        return musicDao.getOne(id);
    }

    @Override
    public void DelMusic(Integer id) {
        musicDao.deleteById(id);
    }
}
