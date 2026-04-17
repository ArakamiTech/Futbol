package arakamitech.com.msusuario.application.dto.request;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioRequest {

    private Long id;
    private String numeroIdentificacion;
    private String nombre;
    private LocalDate fechaNacimiento;
    private Long tipoIdentificacionId;
    private Long paisId;
}
