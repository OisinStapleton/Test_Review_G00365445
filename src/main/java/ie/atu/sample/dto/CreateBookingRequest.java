package ie.atu.sample.dto;

public record CreateBookingRequest(
        String organiserName,
        Long attendeeCount,
        Long roomId
) {}
