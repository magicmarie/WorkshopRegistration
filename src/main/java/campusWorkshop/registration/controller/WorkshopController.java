package campusWorkshop.registration.controller;

import campusWorkshop.registration.dto.RegistrationRequest;
import campusWorkshop.registration.dto.RegistrationResponse;
import campusWorkshop.registration.dto.WorkshopResponse;
import campusWorkshop.registration.service.RegistrationService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("api/workshops")
public class WorkshopController {
    private final RegistrationService registrationService;

    public WorkshopController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @GetMapping
    public List<WorkshopResponse> getWorkshops(){
        return registrationService.getAllWorkshops();
    }

    @GetMapping("/{workshopId}")
    public WorkshopResponse getWorkshopById(@PathVariable Long workshopId){
        return WorkshopResponse.fromEntity(registrationService.getWorkshopById(workshopId));
    }

    @PostMapping("/{workshopId}/registrations")
    public ResponseEntity<String> createRegistration(@PathVariable Long workshopId, @Valid @RequestBody RegistrationRequest request){
        registrationService.registerStudentToWorkshop(workshopId, request.studentId(), request.studentName(), request.studentEmail(), LocalDateTime.parse(request.registrationDate()));
        return ResponseEntity.status(HttpStatus.CREATED).body("Registration created successfully");
    }

    @GetMapping("/{workshopId}/registrations")
    public List<RegistrationResponse> getAllRegistrations(@PathVariable Long workshopId) {
        return registrationService.getAllRegistrations(workshopId);
    }


}
