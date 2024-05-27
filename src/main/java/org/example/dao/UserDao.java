package org.example.dao;

import org.example.pojo.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jackasher
 * @version 1.0
 * @className UserDao
 * @since 1.0
 **/

@Repository
public class UserDao {

    private static List<User> users = new ArrayList<>();

    static {
        User user1 = new User("1","jack",20);
        User user2 = new User("2", "flp",21);
        User user3 = new User("3", "leo",22);

        users.add(user1);
        users.add(user2);
        users.add(user3);
    }

    public List<User> selectAll(){

        return users;
    }

    /**
     * 插入数据
     * @return
     */
    public int insert(User user){
        users.add(user);
        return 1;
    }

    public User selectById(String id){
        User user1 = users.stream().filter(user -> user.getId().equals(id)).findFirst().get();
        return user1;
    }

    public void update(User user){

        String id = user.getId();
        Logger logger = LoggerFactory.getLogger(UserDao.class);
        logger.info("user is      " + user);

        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId().equals(user.getId())) {
                users.set(i,user);
                return ;
            }
        }

    }
    public void delete(String id){
        for (int i = 0; i < users.size(); i++) {
            System.out.println("delete的id是: " + users.get(i).getId() + "传入的id是" + id);
            if (users.get(i).getId().equals(id)) {
                users.remove(i);
                System.out.println("users is " + users);
                return;
            }
        }
    }
}
