package repository;

import model.User;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserRepositoryTest {

    @Test
    public  void insertUser(){
        UserRepository userRepository=new UserRepository();
        User user=new User(110,"marius","2000-01-01");
        userRepository.insertUser(user);
    }

    @Test
    public void stergeById(){
        UserRepository userRepository=new UserRepository();
        userRepository.stergeUserById(101);
    }

    @Test
    public  void updateCreatedAt(){
        UserRepository userRepository=new UserRepository();
        userRepository.updateCreatedAt("marius","1999-01-28");

    }



    @Test
    public  void deleteUsername(){
        UserRepository userRepository=new UserRepository();
        userRepository.deleteUsername("Odessa2");

    }

    @Test
    public  void allUsers(){
        UserRepository userRepository=new UserRepository();
        List<User >users=userRepository.allUsers();
        for(User u:users){
            System.out.println(u.toString());
        }
    }



}