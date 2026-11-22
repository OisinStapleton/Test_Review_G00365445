package ie.atu.sample.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Booking {

    @Id
    @GeneratedValue
    private String name; // ( Organizer name) Validation - NotBlank, 2-60 characters
    private Long attendees; // (attendee count) Validation - Positive whole number
    private Long id; // (room ID) Validation - Initially Active - *Requests must include this*
    private Long status; // (room status) Validation - Initially Active


}
