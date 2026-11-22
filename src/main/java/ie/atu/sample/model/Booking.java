package ie.atu.sample.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
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

    @NotBlank
    @Size(min = 2, max = 60)
    private String organiserName; // ( Organizer name) Validation - NotBlank, 2-60 characters

    @Positive
    private int attendeeCount; // Validation - Positive whole number

    @Size(min = 1, max = 10) // Adding range to the ID validation
    private Long roomId; // (room ID) Validation - Initially Active - *Requests must include this*

    private Long id; //Booking ID

    private String status; // (room status) Validation - Initially Active

}
