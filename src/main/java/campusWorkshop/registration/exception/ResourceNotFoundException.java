package campusWorkshop.registration.exception;

import jakarta.annotation.Resource;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(Resource resource, Long id) {
        super(resource + " with ID " + id + " not found");
    }
}
