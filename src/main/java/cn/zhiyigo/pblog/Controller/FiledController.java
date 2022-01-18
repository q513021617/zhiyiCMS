package cn.zhiyigo.pblog.Controller;

import cn.zhiyigo.pblog.Dao.FiledDao;
import cn.zhiyigo.pblog.Model.Filed;
import cn.zhiyigo.pblog.Model.Response;
import cn.zhiyigo.pblog.Servcie.FiledService;
import com.mysql.jdbc.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/filed")
public class FiledController {
    
    @Autowired
    private FiledDao filedDao;

    @Autowired
    FiledService filedService;

    @GetMapping
    public Response getFiledList(@RequestParam(value = "page",required =false)String page, @RequestParam(value = "size",required = false)String size){
        if(StringUtils.isNullOrEmpty(page)){
            List<Filed> daoAll = filedDao.findAll();
            return Response.success(daoAll);
        }
        Pageable pageable = new PageRequest(Integer.parseInt(page),Integer.parseInt(size));

        Page<Filed> filedDaoAll = filedDao.findAll(pageable);
        return Response.success(filedDaoAll);
    }

    @GetMapping("/{id}")
    public Response getFiledList(@PathVariable("id")Integer id){
        Filed filed = filedService.getFiledById(id);

        return Response.success(filed);
    }

    @GetMapping("/table")
    public Response getFiledListByTable(@RequestParam("name")String table){
        List<Filed> filedList = filedService.getFiledByTableName(table);

        return Response.success(filedList);
    }

    @PostMapping
    public Response addFiled(@RequestBody Filed filed){

        filedService.addFiled(filed);

        return Response.success();
    }
    @DeleteMapping
    public Response delFiled(@RequestBody Filed filed){

        filedService.addFiled(filed);

        return Response.success();
    }
}
