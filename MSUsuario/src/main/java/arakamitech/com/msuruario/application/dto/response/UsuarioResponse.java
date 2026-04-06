package arakamitech.com.msuruario.application.dto.response;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioResponse {
	
	private Long id;
    private String numeroIdentificacion;
    private String nombre;
    private LocalDate fechaNacimiento;
    private Long tipoIdentificacionId;
    private Long paisId;

}
