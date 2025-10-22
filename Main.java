/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package racb;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
public class Main {
    public static void main(String[] args){
        AccessControlService rbac = new AccessControlService();
        
        Map<String, User> userMap = new HashMap<>();
        Map<String, Role> roleMap = new HashMap<>();
        Map<String, Permission> permMap = new HashMap<>();
        
        User alice = new User("alice");
        userMap.put("alice", alice);
        User bob = new User("bob");
        userMap.put("bob", bob);
        User charlie = new User("charlie");
        userMap.put("charlie", charlie);
        
        Role adminRole = new Role("ADMIN");
        roleMap.put("ADMIN", adminRole);
        Role editorRole = new Role("EDITOR");
        roleMap.put("EDITOR", editorRole);
        Role guestRole = new Role("GUEST");
        roleMap.put("GUEST", guestRole);
        
        Permission readPerm = new Permission("READ_DATA");
        permMap.put("READ_DATA", readPerm);
        Permission writePerm = new Permission("WRITE_DATA");
        permMap.put("WRITE_DATA", writePerm);
        Permission deletePerm = new Permission("DELETE_USER");
        permMap.put("DELETE_USER", deletePerm);
        
        rbac.grantPermissionToRole(adminRole, readPerm);
        rbac.grantPermissionToRole(adminRole, writePerm);
        rbac.grantPermissionToRole(adminRole, deletePerm);
        
        rbac.grantPermissionToRole(editorRole, readPerm);
        rbac.grantPermissionToRole(editorRole, writePerm);
        
        rbac.grantPermissionToRole(guestRole, readPerm);
        
        rbac.assignRoleToUser(alice, adminRole);
        rbac.assignRoleToUser(bob, editorRole);
        rbac.assignRoleToUser(charlie, guestRole);
        rbac.assignRoleToUser(charlie, editorRole);
        
        Scanner Scanner = new Scanner(System.in);
        System.out.println("--- He thong kiem tra quyen truy cap ---");
        System.out.println("Chao mung! Du lieu mau da duoc tai.");
        System.out.println("Nguoi dung co san: alice, bob, charlie");
        System.out.println("Quyen co san: READ_DATA, WRITE_DATA, DELETE_USER");
        System.out.println("----------------------------------------");
        System.out.println("Nhap 'exit' bat cu luc nao de thoat.");
        
        while(true){
            System.out.print("\nNhap ten nguoi dung vd(alice): ");
            String userName = Scanner.nextLine();
            if("exit".equalsIgnoreCase(userName)){
                break;
            }
             System.out.print("Nhap ten quyen (vd: WRITE_DATA): ");
            String permName = Scanner.nextLine();
            if ("exit".equalsIgnoreCase(permName)) {
                break;
            }
            User user = userMap.get(userName);
            Permission perm = permMap.get(permName);
            if(user == null){
                System.out.print("Eror: Khong tim thay nguoi dung '" + userName + "'. Vui long thu lai.");
                continue;
            }
            if (perm == null) {
                System.out.println("Eror: Khong tim thay quyen '" + permName + "'. Vui lòng thử lại.");
                continue;
            }
            boolean hasAccess = rbac.checkAccess(user, perm);
            System.out.println("==> Ket qua: Nguoi dung '" + userName + "' co quyen '" + permName + "'? " + (hasAccess ? "CO" : "KHONG"));
            //System.out.println("==> Kết quả: Người dùng '" + username + "' có quyền '" + permName + "'? " + (hasAccess ? "CÓ" : "KHÔNG"));
        }
        System.out.println("\nCảm ơn đã sử dụng. Tạm biệt!");
        Scanner.close();
    }
}
