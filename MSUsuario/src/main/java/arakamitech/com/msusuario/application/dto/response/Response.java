package arakamitech.com.msusuario.application.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Response<T> {
	
	String message;
	T data;

	public static <T> Response<T> ok(T data) {
        return new Response<>("Operación exitosa", data);
    }
	
	public static <T> Response<T> error(String message) {
        return new Response<>(message, null);
    }
}
