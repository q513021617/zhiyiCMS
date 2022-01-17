package cn.zhiyigo.pblog.Controller;

import cn.zhiyigo.pblog.Model.Book;

import cn.zhiyigo.pblog.Model.Response;
import cn.zhiyigo.pblog.Servcie.BookService;
import cn.zhiyigo.pblog.enums.ResultStatusEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/book")
public class HomeBookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/")
    public Response getBookList(@RequestParam("page")Integer page,@RequestParam("size")Integer size){
        PageRequest pageRequest = new PageRequest(page,size);
        Page<Book> books = bookService.getBooks(pageRequest);

        return Response.success(books);
    }

    @GetMapping("/{id}")
    public Response getBookByid(@PathVariable("id")Integer id){
        Book book = bookService.getBookById(id);
        if(book==null){
            return Response.failed(ResultStatusEnum.UNKOWN_ERROR,"查找的书籍不存在");
        }
        return Response.success(book);
    }



    @PostMapping("/")
    public Response addBook(@RequestBody Book book){

        bookService.addBook(book);
        return  Response.success();
    }

    @DeleteMapping("/{id}")
    public Response delOneBook(@PathVariable("id") Integer id){
        bookService.DelBook(id);
        return  Response.success();
    }

}
