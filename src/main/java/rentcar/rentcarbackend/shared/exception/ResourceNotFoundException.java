package rentcar.rentcarbackend.shared.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

<<<<<<< HEAD
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException() { super(); }
    public ResourceNotFoundException(String message) { super(message); }

    public ResourceNotFoundException(String message, Throwable cause) { super(message, cause); }
    public ResourceNotFoundException(String resourceName, Integer resourceId)
    { super(String.format("%s with id %d not found.", resourceName, resourceId)); }
}
=======
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException() {
        super();
    }

    public ResourceNotFoundException(String message) {
        super(message);
    }


    public ResourceNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public ResourceNotFoundException(String resourceName, Long resourceId) {
        super(String.format("%s with id %d not found.", resourceName, resourceId));
    }

}
>>>>>>> feat/jwt-base
