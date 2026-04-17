package arakamitech.com.msusuario.infrastructure.adapters.out.rol.persistence.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import arakamitech.com.msusuario.domain.model.Rol;
import arakamitech.com.msusuario.infrastructure.adapters.out.rol.persistence.entity.RolEntity;

@Mapper(componentModel = "spring")
public interface RolPersistenceMapper {

    default List<Rol> toDomainList(List<RolEntity> entities) {
        return entities.stream()
                .map(this::toDomain)
                .toList();
    }

    default Rol toDomain(RolEntity entity) {
        return new Rol(entity.getId(), entity.getNombre());
    }

}
