package campusWorkshop.registration.repository;

import campusWorkshop.registration.entity.Registration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegistrationRepository extends JpaRepository<Registration, Long> {
    boolean existsByStudentIdAndWorkshop_workshopId(Long studentId, Long workshopId);
}
