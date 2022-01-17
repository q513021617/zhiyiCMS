package cn.zhiyigo.pblog.Model;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Transient;

@Entity
public class ArticleCommitVo extends ArticleCommit{
    @Column(name = "user_name")
    String userName;
    @Column(name = "user_avatars")
    String userAvatars;

    @Transient
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }


    @Transient
    public String getUserAvatars() {
        return userAvatars;
    }

    public void setUserAvatars(String userAvatars) {
        this.userAvatars = userAvatars;
    }
}
