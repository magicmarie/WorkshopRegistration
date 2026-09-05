package campusWorkshop.registration.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Entity
public class Workshop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long workshopId;

    private String title;

    private String description;

    @Column(nullable = false)
    private LocalDateTime date;

    @Column(nullable = false)
    private LocalTime time;

    @Column(nullable = false)
    private String venue;

    @Column(nullable = false)
    private int capacity;

    @Column(nullable = false)
    private LocalDateTime registrationDeadline;

    public Long getWorkshopId() {
        return workshopId;
    }

    public void setWorkshopId(Long workshopId) {
        this.workshopId = workshopId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public LocalDateTime getRegistrationDeadline() {
        return registrationDeadline;
    }

    public void setRegistrationDeadline(LocalDateTime registrationDeadline) {
        this.registrationDeadline = registrationDeadline;
    }

    public Workshop() {}

    public Workshop(String title, String description, LocalDateTime date, LocalTime time, String venue, int capacity, LocalDateTime registrationDeadline) {
        this.title = title;
        this.description = description;
        this.date = date;
        this.time = time;
        this.venue = venue;
        this.capacity = capacity;
        this.registrationDeadline = registrationDeadline;
    }
}
