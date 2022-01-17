package cn.zhiyigo.pblog.ServcieImpl;

import cn.zhiyigo.pblog.Dao.BookMarkTagDao;
import cn.zhiyigo.pblog.Model.BookMarkTag;
import cn.zhiyigo.pblog.Servcie.BookMarkTagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;

@Service
public class BookMarkTagServiceImpl implements BookMarkTagService {

    @Autowired
    BookMarkTagDao bookMarkTagDao;

    @Override
    public Page<BookMarkTag> getBookMarkTags(PageRequest pageRequest,Integer userid) {
        BookMarkTag bookMarkTag=new BookMarkTag();
        if(userid!=null){
            bookMarkTag.setUserId(userid);
        }
        Example<BookMarkTag> tagExample = Example.of(bookMarkTag);
        Page<BookMarkTag> articleTagDaoAll = bookMarkTagDao.findAll(tagExample,pageRequest);
        return articleTagDaoAll;
    }

    @Override
    public void addBookMarkTag(BookMarkTag bookMarkTag) {

        bookMarkTag.setCreateTime(new Timestamp(new Date().getTime()));
        bookMarkTag.setUpdateTime(new Timestamp(new Date().getTime()));
        bookMarkTagDao.save(bookMarkTag);
    }

    @Override
    public BookMarkTag getBookMarkTagById(Integer id,Integer userId) {
        BookMarkTag bookMarkTag=new BookMarkTag();
        bookMarkTag.setBookId(id);
        bookMarkTag.setUserId(userId);
        Example<BookMarkTag> tagExample = Example.of(bookMarkTag);
        boolean present = bookMarkTagDao.findOne(tagExample).isPresent();
        BookMarkTag markTag =null;
        if(present){
            markTag = bookMarkTagDao.findOne(tagExample).get();
        }

        return markTag;
    }

    @Override
    public void delBookMarkTag(Integer id) {
        bookMarkTagDao.deleteById(id);
    }
}
