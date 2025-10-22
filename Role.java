/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package racb;

/**
 *
 * @author Administrator
 */
public class Role {
    private String roleName;
    
    public Role(String name){
        this.roleName = name;
    }
    public String getName() {
        return roleName;
    }
    @Override
    public boolean equals(Object obj){
        if(this == obj) return true;
        if(obj == null || getClass() != obj.getClass()) return false;
        Role role = (Role) obj;
        return roleName.equals(role.roleName);
    }
    @Override
    public int hashCode(){
        return roleName.hashCode();
    }
}
