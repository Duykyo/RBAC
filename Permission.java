/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package racb;

/**
 *
 * @author Administrator
 */
public class Permission {
        private String permissionName;
        
        public Permission(String name){
            this.permissionName = name;
        }
        public String getName(){
            return permissionName;
        }
    @Override
    public boolean equals(Object obj){
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Permission that = (Permission) obj;
        return permissionName.equals(that.permissionName);
    }
    @Override
    public int hashCode(){
        return permissionName.hashCode();
    }
}
