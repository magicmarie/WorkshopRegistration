package campusWorkshop.registration.dto;

import jakarta.validation.constraints.NotBlank;

public record RegistrationRequest(
        @NotBlank(message = "Student ID is required") Long studentId,
        @NotBlank(message = "Workshop ID is required") Long workshopId,
        @NotBlank(message = "Student Name is required") String studentName,
        @NotBlank(message = "Student Email is required") String studentEmail,
        @NotBlank(message = "Registration Date is required") String registrationDate
) {
}
