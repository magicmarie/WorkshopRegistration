package campusWorkshop.registration.dto;

import campusWorkshop.registration.entity.Registration;

import java.util.List;

public record RegistrationResponse(
        Long registrationId,
        Long studentId,
        Long workshopId,
        String studentName,
        String studentEmail,
        String registrationDate
) {
    public static RegistrationResponse fromEntity(Registration registration) {
        return new RegistrationResponse(
                registration.getRegistrationId(),
                registration.getWorkshop().getWorkshopId(),
                registration.getStudentId(),
                registration.getStudentName(),
                registration.getStudentEmail(),
                registration.getRegistrationDate().toString()
        );
    }
}
