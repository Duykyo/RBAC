package racb;
import java.util.Set;
import java.util.HashSet;
public class Role {
    private String roleName;
    private Set<Role> inheritedRoles;
    
    public Role(String name){
        this.roleName = name;
        this.inheritedRoles = new HashSet<>();
    }
    public void addInheritedRoles(Role parentRole){
        this.inheritedRoles.add(parentRole);
    }
    public Set<Role> getInheritedRoles(){
        return this.inheritedRoles;
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
