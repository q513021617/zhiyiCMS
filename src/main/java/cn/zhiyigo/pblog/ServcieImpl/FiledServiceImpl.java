package cn.zhiyigo.pblog.ServcieImpl;

import cn.zhiyigo.pblog.Dao.FiledDao;
import cn.zhiyigo.pblog.Model.Filed;
import cn.zhiyigo.pblog.Model.Filed;
import cn.zhiyigo.pblog.Servcie.FiledService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FiledServiceImpl implements FiledService {

    @Autowired
    FiledDao filedDao;

    @Override
    public Page<Filed> getFileds(PageRequest pageRequest) {

        return filedDao.findAll(pageRequest);
    }

    @Override
    public void addFiled(Filed filed) {
        filedDao.save(filed);
    }

    @Override
    public Filed getFiledById(Integer id) {

        Filed filed =null;
        if(filedDao.existsById(id)){
            filed = filedDao.getOne(id);
        }
        return filed;
    }

    @Override
    public List<Filed> getFiledByTableName(String table) {

        return filedDao.findAllByTableName(table);
    }

    @Override
    public void DelFiled(Integer id) {
        Filed filed=new Filed();
        filed.setId(id);
        filedDao.delete(filed);
    }
}
