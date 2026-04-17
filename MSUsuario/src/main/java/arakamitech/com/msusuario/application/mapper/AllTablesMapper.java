package arakamitech.com.msusuario.application.mapper;

import org.mapstruct.Mapper;

import arakamitech.com.msusuario.application.dto.response.AllTablesResponse;
import arakamitech.com.msusuario.domain.model.AllTables;

@Mapper(componentModel = "spring")
public interface AllTablesMapper {

	AllTablesResponse toResponse(AllTables allTables);
	
}
