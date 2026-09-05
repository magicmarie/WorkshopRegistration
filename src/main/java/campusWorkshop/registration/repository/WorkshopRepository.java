package campusWorkshop.registration.repository;

import campusWorkshop.registration.dto.RegistrationResponse;
import campusWorkshop.registration.entity.Registration;
import campusWorkshop.registration.entity.Workshop;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface WorkshopRepository extends JpaRepository<Workshop, Long> {
    List<RegistrationResponse> getAllRegistrationsByWorkshopId(Long workshopId);

    int countRegistrationsByWorkshopId(Long workshopId);
}
