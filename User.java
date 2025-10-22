/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package racb;

/**
 *
 * @author Administrator
 */
public class User {
    private String userName;
    public User(String name){
        this.userName = name;
    }
    public String getName(){
        return userName;
    }
    @Override
    public boolean equals(Object obj){
        if(this == obj) return true;
        if(obj == null || getClass() != obj.getClass()) return false;
        User user = (User) obj;
        return userName.equals(user.userName);
    }
    @Override
    public int hashCode(){
        return userName.hashCode();
    }
}
