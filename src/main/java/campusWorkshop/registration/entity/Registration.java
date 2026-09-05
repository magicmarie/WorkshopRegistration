package campusWorkshop.registration.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
public class Registration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long registrationId;

    @Column(nullable = false)
    private Long studentId;

    @Column(nullable = false)
    private String studentName;

    @Column(nullable = false)
    private String studentEmail;

    public Workshop getWorkshop() {
        return workshop;
    }

    public void setWorkshop(Workshop workshop) {
        this.workshop = workshop;
    }

    @Column(nullable = false)
    private LocalDateTime registrationDate;

    @ManyToOne
    @JoinColumn(name = "workshop_id", nullable = false)
    Workshop workshop;

    public Long getRegistrationId() {
        return registrationId;
    }

    public void setRegistrationId(Long registrationId) {
        this.registrationId = registrationId;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        studentName = studentName;
    }

    public String getStudentEmail() {
        return studentEmail;
    }

    public void setStudentEmail(String studentEmail) {
        studentEmail = studentEmail;
    }

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDateTime registrationDate) {
        this.registrationDate = registrationDate;
    }

    public Registration() {}

    public Registration(Long studentId, Workshop workshop, String studentName, String studentEmail, LocalDateTime registrationDate) {
        this.studentId = studentId;
        this.workshop = workshop;
        this.studentName = studentName;
        this.studentEmail = studentEmail;
        this.registrationDate = registrationDate;
    }
}
