package arakamitech.com.msusuariowebflux.infrastructure.adapters.out.persistence.entity;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table("USUARIO")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UsuarioEntity {

    @Id
    private Long id;

    @Column("NUMERO_IDENTIFICACION")
    private String numeroIdentificacion;

    @Column("NOMBRE")
    private String nombre;

    @Column("FECHA_NACIMIENTO")
    private LocalDate fechaNacimiento;

    @Column("TIPO_IDENTIFICACION_ID")
    private Long tipoIdentificacionId;

    @Column("PAIS_ID")
    private Long paisId;
}