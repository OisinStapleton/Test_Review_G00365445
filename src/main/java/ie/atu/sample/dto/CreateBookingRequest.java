package ie.atu.sample.dto;

public record CreateBookingRequest(
        String name,
        Long attendees,
        Long id
) {}
