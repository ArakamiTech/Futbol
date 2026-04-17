package arakamitech.com.msusuario.infrastructure.adapters.out.persistence.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import arakamitech.com.msusuario.domain.model.Usuario;
import arakamitech.com.msusuario.infrastructure.adapters.out.persistence.entity.UsuarioEntity;

@Mapper(componentModel = "spring")
public interface UsuarioPersistenceMapper {

    default List<Usuario> toDomainList(List<UsuarioEntity> entities) {
        return entities.stream()
                .map(this::toDomain)
                .toList();
    }

    default Usuario toDomain(UsuarioEntity entity) {
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

    default UsuarioEntity toEntity(Usuario usuario) {
        return new UsuarioEntity(usuario.getId(), usuario.getNumeroIdentificacion(), usuario.getNombre(), usuario.getFechaNacimiento(), usuario.getTipoIdentificacionId(), usuario.getPaisId());
    }
}
