package arakamitech.com.msusuariowebflux.infrastructure.adapters.out.rol.external.adapter.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Response<T> {
    private String message;
    private T data;
}
