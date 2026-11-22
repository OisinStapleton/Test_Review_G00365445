package ie.atu.sample.service;

import ie.atu.sample.client.RoomClient;
import ie.atu.sample.dto.CreateBookingRequest;
import ie.atu.sample.dto.RoomDTO;
import ie.atu.sample.model.Booking;
import ie.atu.sample.repository.BookingRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class BookingService {

    private final BookingRepository bookingRepository;
    private final RoomClient roomClient;

    public BookingService(BookingRepository bookingRepository, RoomClient roomClient) {
        this.bookingRepository = bookingRepository;
        this.roomClient = roomClient;
    }
    public Booking createBooking(CreateBookingRequest request) {

        RoomDTO room = roomClient.getRoom(request.roomId());

        if (request.attendeeCount() > room.getCapacity()) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "Room Capacity Exceeded");
        }
        Booking booking = new Booking();
        booking.setOrganiserName(request.organiserName());
        booking.setRoomId(request.roomId());
        booking.setAttendeeCount(request.attendeeCount());
        booking.setStatus("ACTIVE");
        return bookingRepository.save(booking);
    }

    public Booking getById(Long id) {

        return bookingRepository.findById(id).orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "Booking Not Found"));
    }
}
