package campusWorkshop.registration.dto;

import campusWorkshop.registration.entity.Workshop;

public record WorkshopResponse(
        Long workshopId,
        String title,
        String description,
        String date,
        String time,
        String venue,
        int capacity,
        String registrationDeadline
) {
    public static WorkshopResponse fromEntity(Workshop workshop) {
        return new WorkshopResponse(
                workshop.getWorkshopId(),
                workshop.getTitle(),
                workshop.getDescription(),
                workshop.getDate().toString(),
                workshop.getTime().toString(),
                workshop.getVenue(),
                workshop.getCapacity(),
                workshop.getRegistrationDeadline().toString()
        );
    }
}
