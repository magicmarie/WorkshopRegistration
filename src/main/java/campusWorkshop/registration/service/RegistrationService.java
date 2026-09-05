package campusWorkshop.registration.service;

import campusWorkshop.registration.dto.RegistrationResponse;
import campusWorkshop.registration.dto.WorkshopResponse;
import campusWorkshop.registration.entity.Registration;
import campusWorkshop.registration.entity.Workshop;
import campusWorkshop.registration.repository.RegistrationRepository;
import campusWorkshop.registration.repository.WorkshopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class RegistrationService {
    private final RegistrationRepository registrationRepository;
    private final WorkshopRepository workshopRepository;

    @Autowired
    public RegistrationService(RegistrationRepository registrationRepository, WorkshopRepository workshopRepository) {
        this.registrationRepository = registrationRepository;
        this.workshopRepository = workshopRepository;
    }

    public List<WorkshopResponse> getAllWorkshops() {
        return workshopRepository.findAll().stream().map(WorkshopResponse::fromEntity).toList();
    }

    public Workshop getWorkshopById(Long workshopId) {
        return workshopRepository.findById(workshopId).orElse(null);
    }

    public List<RegistrationResponse> getAllRegistrations(Long workshopId) {
        return workshopRepository.getAllRegistrationsByWorkshopId(workshopId);
    }

    public RegistrationResponse registerStudentToWorkshop(Long workshopId, Long studentId, String studentName, String studentEmail, LocalDateTime registrationDate) {
        Workshop workshop = getWorkshopById(workshopId);
        LocalDateTime registrationDeadline = workshop.getRegistrationDeadline();
        if(workshop != null){
            if (registrationRepository.existsByStudentIdAndWorkshop_workshopId(studentId, workshopId)) {
                throw new IllegalArgumentException("Student is already registered for this workshop.");
            }
//            if() {
//                throw new IllegalArgumentException("Registration deadline has passed");
//            }
//            if() {
//                throw new IllegalArgumentException("Workshop capacity has been reached");
//            }
            Registration reg = new Registration(studentId, workshop, studentName, studentEmail, registrationDate);
            return RegistrationResponse.fromEntity(registrationRepository.save(reg));

        }
        return null;
    }

}
