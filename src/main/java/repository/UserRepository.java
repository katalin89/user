package repository;

import model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepository {

    private  String JdbURL="jdbc:mysql://localhost:3306/ig_clone";
    private String username="root";
    private String password="root";
    private Connection connection=null;
    private Statement statement=null;



    public UserRepository(){

        try{
            connection= DriverManager.getConnection(JdbURL,username,password);
            statement=connection.createStatement();

        }catch (SQLException e){
            System.out.println("eroare conectare baza de date");
        }
    }

    private void executeStatement(String execute){
        try{
            statement.execute(execute);

        }catch ( SQLException exc){
            System.out.println("Nu am reusit"+execute);
        }
    }

    public  void insertUser(User user){
        String insertTo="";
        insertTo+="insert into users";
        insertTo+="(username,created_at)";
        insertTo+="values(";
        insertTo+=String.format("'%s','%s'",user.getUsername(),user.getCreated_at());
        insertTo+=")";
        executeStatement(insertTo);
    }

    public  void  stergeUserById(int id){

        String text=String.format("delete  from users where id=%d",id);


        executeStatement(text);//cu ajutorul acestei functii va executa
    }

    public void updateCreatedAt(String username,String created_at){
        String update=String.format("update  users set created_at ='%s' where username='%s'",created_at,username);
        executeStatement(update);


    }



    public  void deleteUsername(String username){
        String delete=String.format("delete  from users where username ='%s'",username);
        executeStatement(delete);
    }

    private ResultSet allUser(){
        executeStatement("select * from users");
        try{
            return  statement.getResultSet();
        }catch (Exception e){
            System.out.println("Nu sa executat schita");
            return  null;
        }
    }

    public List<User > allUsers(){
        ResultSet set=allUser();
        List<User>users=new ArrayList<>();
        try{
            while( set.next()){
                users.add(new User(set.getInt(1),set.getString(2),set.getString(3)));
            }
        }catch ( Exception e){
            System.out.println("Nu s-a creat lista");
        }
        return  users;
    }





}
