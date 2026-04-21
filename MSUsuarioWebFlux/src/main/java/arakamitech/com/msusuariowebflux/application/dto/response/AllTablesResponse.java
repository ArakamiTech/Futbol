package arakamitech.com.msusuariowebflux.application.dto.response;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AllTablesResponse {

	private List<RolResponse> roles;
	private List<UsuarioResponse> users;

}
