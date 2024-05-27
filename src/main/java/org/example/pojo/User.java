package org.example.pojo;

import org.springframework.stereotype.Repository;

/**
 * @author Jackasher
 * @version 1.0
 * @className User
 * @since 1.0
 **/

@Repository
public class User {
    private String id;
    private String username;
    private int age;

    public void setId(String id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public User() {
    }

    public User(String id, String username, int age) {
        this.id = id;
        this.username = username;
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", age=" + age +
                '}';
    }
}
