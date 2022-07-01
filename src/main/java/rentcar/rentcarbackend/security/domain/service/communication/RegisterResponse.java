package rentcar.rentcarbackend.security.domain.service.communication;

import rentcar.rentcarbackend.security.resource.UserResource;
import rentcar.rentcarbackend.shared.domain.service.communication.BaseResponse;

public class RegisterResponse extends BaseResponse<UserResource> {
    public RegisterResponse(String message) {
        super(message);
    }

    public RegisterResponse(UserResource resource) {
        super(resource);
    }
}