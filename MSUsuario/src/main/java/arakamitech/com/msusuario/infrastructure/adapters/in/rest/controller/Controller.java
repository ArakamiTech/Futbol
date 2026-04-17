package arakamitech.com.msusuario.infrastructure.adapters.in.rest.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import arakamitech.com.msusuario.application.dto.request.UsuarioRequest;
import arakamitech.com.msusuario.application.dto.response.AllTablesResponse;
import arakamitech.com.msusuario.application.dto.response.Response;
import arakamitech.com.msusuario.application.dto.response.UsuarioResponse;
import arakamitech.com.msusuario.application.mapper.AllTablesMapper;
import arakamitech.com.msusuario.application.mapper.UsuarioMapper;
import arakamitech.com.msusuario.domain.port.in.UsuarioUseCase;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("${request.mapping.controller.usuariocontroller}")
public class Controller {

	private final UsuarioUseCase usuarioUseCase;
	private final UsuarioMapper usuarioMapper;
	private final AllTablesMapper allTableMapper;

	@GetMapping
	public ResponseEntity<Response<List<UsuarioResponse>>> findAll() {
		return ResponseEntity.ok(
				Response.ok(
						usuarioMapper.toResponseList(
								usuarioUseCase.findAll())));
	}
	
	@GetMapping("/{id}")
    public ResponseEntity<Response<UsuarioResponse>> findById(@PathVariable Long id) {
        return ResponseEntity.ok(
                Response.ok(usuarioMapper.toResponse(usuarioUseCase.findById(id)))
        );
    }

    @PostMapping
    public ResponseEntity<Response<UsuarioResponse>> create(@RequestBody UsuarioRequest request) {
        return ResponseEntity.ok(
                Response.ok(
                        usuarioMapper.toResponse(
                                usuarioUseCase.create(usuarioMapper.toUsuario(request))
                        )
                )
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<Response<UsuarioResponse>> update(@PathVariable Long id, @RequestBody UsuarioRequest request) {
        return ResponseEntity.ok(
                Response.ok(
                        usuarioMapper.toResponse(
                                usuarioUseCase.update(id, usuarioMapper.toUsuario(request))
                        )
                )
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Response<Void>> delete(@PathVariable Long id) {
        usuarioUseCase.delete(id);
        return ResponseEntity.ok(Response.ok(null));
    }
    
    @GetMapping("/allTables")
	public ResponseEntity<Response<AllTablesResponse>> findAllTables() {
		return ResponseEntity.ok(
				Response.ok(
						allTableMapper.toResponse(
								usuarioUseCase.findAllTables())
						)
				);
	}

}
