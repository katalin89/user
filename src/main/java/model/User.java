package model;

public class User {
    private int id;
    private String username;
    private String created_at;

    public  User(int id,String username,String created_at){
        this.id=id;
        this.username=username;
        this.created_at=created_at;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    @Override
    public  String toString(){
        String text="";
        text+=id+","+username+","+created_at;
        return  text;
    }

    @Override
    public boolean equals(Object obj){
        User user=(User) obj;
        return user.created_at==this.created_at;
    }
}
