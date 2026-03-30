package arakamitech.com.msrol.application.usecase;

import java.util.List;

import org.springframework.stereotype.Service;

import arakamitech.com.msrol.domain.model.Rol;
import arakamitech.com.msrol.domain.port.in.RolUseCase;
import arakamitech.com.msrol.domain.port.out.RolRepositoryPort;
import arakamitech.com.msrol.shared.exception.DomainError;
import arakamitech.com.msrol.shared.exception.DomainException;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class RolUseCaseImpl implements RolUseCase {

	private final RolRepositoryPort rolRepositoryPort;
	
	@Override
	public List<Rol> findAll() {
		return rolRepositoryPort.findAll();
	}
	
	@Override
    public Rol findById(Long id) {
        return rolRepositoryPort.findById(id)
                .orElseThrow(() -> new DomainException(DomainError.ROL_NO_ENCONTRADO));
    }

    @Override
    public Rol create(String nombre) {

        if (rolRepositoryPort.existsByNombre(nombre)) {
            throw new DomainException(DomainError.ROL_DUPLICADO);
        }

        return rolRepositoryPort.save(new Rol(nombre));
    }

    @Override
    public Rol update(Long id, String nombre) {

        Rol rol = rolRepositoryPort.findById(id)
                .orElseThrow(() -> new DomainException(DomainError.ROL_NO_ENCONTRADO));

        rol.actualizarNombre(nombre);

        return rolRepositoryPort.save(rol);
    }

    @Override
    public void delete(Long id) {
    	rolRepositoryPort.deleteById(id);
    }

}
