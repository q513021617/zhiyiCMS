package cn.zhiyigo.pblog.Servcie;

import cn.zhiyigo.pblog.Model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface BookService {

   Page<Book> getBooks(PageRequest pageRequest);
   void addBook(Book book);
   Book getBookById(Integer id);
   void DelBook(Integer id);
   List<Book> getAllBooks();
}
