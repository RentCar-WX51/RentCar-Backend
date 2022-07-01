package rentcar.rentcarbackend.security.domain.service.communication;

import rentcar.rentcarbackend.security.resource.AuthenticateResource;
import rentcar.rentcarbackend.shared.domain.service.communication.BaseResponse;

public class AuthenticateResponse extends BaseResponse<AuthenticateResource> {
    public AuthenticateResponse(String message) {
        super(message);
    }

    public AuthenticateResponse(AuthenticateResource resource) {
        super(resource);
    }
}