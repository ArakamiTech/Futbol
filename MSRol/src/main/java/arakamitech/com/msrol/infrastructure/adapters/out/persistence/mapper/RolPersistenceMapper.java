package arakamitech.com.msrol.infrastructure.adapters.out.persistence.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import arakamitech.com.msrol.domain.model.Rol;
import arakamitech.com.msrol.infrastructure.adapters.out.persistence.entity.RolEntity;

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

    default RolEntity toEntity(Rol rol) {
        return new RolEntity(rol.getId(), rol.getNombre());
    }
}
