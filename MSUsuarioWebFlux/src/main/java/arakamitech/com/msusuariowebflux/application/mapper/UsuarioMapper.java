package arakamitech.com.msusuariowebflux.application.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import arakamitech.com.msusuariowebflux.application.dto.response.UsuarioResponse;
import arakamitech.com.msusuariowebflux.domain.model.Usuario;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {
	
	List<UsuarioResponse>  toResponseList(List<Usuario> all);

	UsuarioResponse toResponse(Usuario usuario);
	
}
