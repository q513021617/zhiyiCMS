package cn.zhiyigo.pblog.Controller;

import cn.zhiyigo.pblog.Model.Book;
import cn.zhiyigo.pblog.Model.BookMarkTag;
import cn.zhiyigo.pblog.Model.Response;
import cn.zhiyigo.pblog.Servcie.BookMarkTagService;
import cn.zhiyigo.pblog.Servcie.BookService;
import cn.zhiyigo.pblog.enums.ResultStatusEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/bookmarktag")
public class HomeBookMarkTagController {

    @Autowired
    private BookMarkTagService bookService;

    @GetMapping("/")
    public Response getBookMarkTagList(@RequestParam("page")Integer page,@RequestParam("size")Integer size,@RequestParam(value = "userid",required = false)Integer userid){
        PageRequest pageRequest = new PageRequest(page,size);
        Page<BookMarkTag> bookMarkTags = bookService.getBookMarkTags(pageRequest,userid);

        return Response.success(bookMarkTags);
    }

    @GetMapping("/{id}/{userid}")
    public Response geBookMarkTagByid(@PathVariable("id")Integer id,@PathVariable("userid")Integer userid){
        BookMarkTag bookMark =null;
        try {
            bookMark = bookService.getBookMarkTagById(id,userid);
        }catch (Exception e){
            return Response.failed(ResultStatusEnum.UNKOWN_ERROR,"查询失败");
        }


        return Response.success(bookMark);
    }



    @PostMapping("/")
    public Response addBookMarkTag(@RequestBody BookMarkTag book){

        bookService.addBookMarkTag(book);
        return  Response.success();
    }

    @DeleteMapping("/{id}")
    public Response delOneBookMarkTag(@PathVariable("id") Integer id){
        bookService.delBookMarkTag(id);
        return  Response.success();
    }

}
