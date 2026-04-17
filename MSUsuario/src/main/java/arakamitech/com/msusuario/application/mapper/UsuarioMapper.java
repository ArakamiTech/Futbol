package arakamitech.com.msusuario.application.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import arakamitech.com.msusuario.application.dto.request.UsuarioRequest;
import arakamitech.com.msusuario.application.dto.response.UsuarioResponse;
import arakamitech.com.msusuario.domain.model.Usuario;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {
	
	List<UsuarioResponse>  toResponseList(List<Usuario> all);

	UsuarioResponse toResponse(Usuario usuario);
	
	default Usuario toUsuario(UsuarioRequest entity) {
	    if (entity == null) {
	        return null;
	    }

	    return new Usuario(
	            entity.getId(),
	            entity.getNumeroIdentificacion(),
	            entity.getNombre(),
	            entity.getFechaNacimiento(),
	            entity.getTipoIdentificacionId(),
	            entity.getPaisId()
	    );
	}

}
