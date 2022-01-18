package cn.zhiyigo.pblog.ServcieImpl;

import cn.zhiyigo.pblog.Dao.BookDao;
import cn.zhiyigo.pblog.Model.Book;
import cn.zhiyigo.pblog.Servcie.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    BookDao bookDao;

    @Override
    public Page<Book> getBooks(PageRequest pageRequest) {

        return bookDao.findAll(pageRequest);
    }

    @Override
    public void addBook(Book book) {
        bookDao.save(book);
    }

    @Override
    public Book getBookById(Integer id) {

        Book book =null;
        if(bookDao.existsById(id)){
            book = bookDao.getOne(id);
        }
        return book;
    }

    @Override
    public void DelBook(Integer id) {
        Book book=new Book();
        book.setId(id);
        bookDao.delete(book);
    }

    @Override
    public List<Book> getAllBooks() {
        return bookDao.findAll();
    }
}
