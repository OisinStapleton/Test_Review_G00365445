package ie.atu.sample.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public record CreateBookingRequest(
        @NotBlank
        @Size(min = 2, max = 60)
        String organiserName,

        @Positive
        int attendeeCount,

        @NotNull
        @Positive
        Long roomId
) {}
