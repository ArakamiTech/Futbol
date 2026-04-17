package arakamitech.com.msusuario.domain.model;

import java.io.Serializable;
import java.util.List;

public class AllTables implements Serializable {

	private List<Rol>  roles;
    private List<Usuario> users;
	
    public AllTables(List<Rol> roles, List<Usuario> users) {
		super();
		this.roles = roles;
		this.users = users;
	}

	public AllTables() {
		super();
	}

	public List<Rol> getRoles() {
		return roles;
	}

	public void setRoles(List<Rol> roles) {
		this.roles = roles;
	}

	public List<Usuario> getUsers() {
		return users;
	}

	public void setUsers(List<Usuario> users) {
		this.users = users;
	}
    
}