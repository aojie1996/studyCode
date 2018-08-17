package test;

import dao.UserMappering;
import model.Article;
import org.apache.ibatis.session.SqlSession;
import util.SqlSessionFactoryUtil;

import java.util.List;

public class Test2 {
    public static void main(String[] args) {
            SqlSession session=SqlSessionFactoryUtil.getSession();
        try {
            UserMappering mapper = session.getMapper(UserMappering.class);
            List<Article> list=mapper.getUserArticles(1);
            for (Article article:list){
                System.out.println(article.getTitle()+":"
                        +article.getContent()+
                        ":作者是:"+article.getUser().getUserName()+
                        ":地址:"+ article.getUser().getUserAddress());
            }
        }finally {
            session.close();
        }


    }
}
