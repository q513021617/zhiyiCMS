package cn.zhiyigo.pblog.Servcie;

import cn.zhiyigo.pblog.Model.BookMarkTag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public interface BookMarkTagService {

   Page<BookMarkTag> getBookMarkTags(PageRequest pageRequest,Integer userid);

   void addBookMarkTag(BookMarkTag bookMarkTag);

   BookMarkTag getBookMarkTagById(Integer id,Integer userId);

   void delBookMarkTag(Integer id);
}
