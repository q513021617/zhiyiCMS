package cn.zhiyigo.pblog.Dao;

import cn.zhiyigo.pblog.Model.Book;
import cn.zhiyigo.pblog.Model.Permission;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BookDao extends JpaRepository<Book,Integer> {

}
