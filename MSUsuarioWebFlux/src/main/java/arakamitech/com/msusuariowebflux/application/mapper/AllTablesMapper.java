package arakamitech.com.msusuariowebflux.application.mapper;

import org.mapstruct.Mapper;

import arakamitech.com.msusuariowebflux.application.dto.response.AllTablesResponse;
import arakamitech.com.msusuariowebflux.domain.model.AllTables;

@Mapper(componentModel = "spring")
public interface AllTablesMapper {

	AllTablesResponse toResponse(AllTables allTables);
	
}
