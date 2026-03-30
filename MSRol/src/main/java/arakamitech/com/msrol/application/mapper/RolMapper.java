package arakamitech.com.msrol.application.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import arakamitech.com.msrol.application.dto.response.RolResponse;
import arakamitech.com.msrol.domain.model.Rol;

@Mapper(componentModel = "spring")
public interface RolMapper {
	
	List<RolResponse>  toResponseList(List<Rol> all);

	RolResponse toResponse(Rol rol);

}
