package arakamitech.com.msrol.infrastructure.adapters.in.rest.controller;

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

import arakamitech.com.msrol.application.dto.request.RolRequest;
import arakamitech.com.msrol.application.dto.response.Response;
import arakamitech.com.msrol.application.dto.response.RolResponse;
import arakamitech.com.msrol.application.mapper.RolMapper;
import arakamitech.com.msrol.domain.port.in.RolUseCase;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("${request.mapping.controller.rolcontroller}")
public class RolController {

	private final RolUseCase rolUseCase;
	private final RolMapper rolMapper;

	@GetMapping
	public ResponseEntity<Response<List<RolResponse>>> findAll() {
		return ResponseEntity.ok(
				Response.ok(
						rolMapper.toResponseList(
								rolUseCase.findAll())));
	}
	
	@GetMapping("/{id}")
    public ResponseEntity<Response<RolResponse>> findById(@PathVariable Long id) {
        return ResponseEntity.ok(
                Response.ok(rolMapper.toResponse(rolUseCase.findById(id)))
        );
    }

    @PostMapping
    public ResponseEntity<Response<RolResponse>> create(@RequestBody RolRequest request) {
        return ResponseEntity.ok(
                Response.ok(
                        rolMapper.toResponse(
                                rolUseCase.create(request.getNombre())
                        )
                )
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<Response<RolResponse>> update(@PathVariable Long id, @RequestBody RolRequest request) {
        return ResponseEntity.ok(
                Response.ok(
                        rolMapper.toResponse(
                                rolUseCase.update(id, request.getNombre())
                        )
                )
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Response<Void>> delete(@PathVariable Long id) {
        rolUseCase.delete(id);
        return ResponseEntity.ok(Response.ok(null));
    }

}
