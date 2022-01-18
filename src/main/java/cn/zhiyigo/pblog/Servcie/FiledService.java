package cn.zhiyigo.pblog.Servcie;

import cn.zhiyigo.pblog.Model.Filed;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface FiledService {
    Page<Filed> getFileds(PageRequest pageRequest);
    void addFiled(Filed book);
    Filed getFiledById(Integer id);
    List<Filed> getFiledByTableName(String table);
    void DelFiled(Integer id);
}
