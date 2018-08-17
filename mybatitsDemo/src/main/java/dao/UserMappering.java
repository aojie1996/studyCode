package dao;

import model.Article;
import model.User;

import java.util.List;

public interface UserMappering {
   User selectUserByID(int id);
   List selectUsers(String name);
   void addUser(User user);
   void updateUser(User user);
   void deleteUser(int id);
   List<Article> getUserArticles(int id);
}
