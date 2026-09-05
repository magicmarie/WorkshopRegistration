package campusWorkshop.registration.dto;

import jakarta.validation.constraints.NotBlank;

public record WorkshopRequest(
        @NotBlank(message = "Workshop title is required") String title,
        @NotBlank(message = "Workshop description is required") String description,
        @NotBlank(message = "Workshop date is required") String date,
        @NotBlank(message = "Workshop time is required") String time,
        @NotBlank(message = "Workshop venue is required") String venue,
        @NotBlank(message = "Workshop capacity is required") String capacity,
        @NotBlank(message = "Workshop registration deadline is required") String registrationDeadline
) {
}
