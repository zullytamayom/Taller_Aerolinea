package com.APIAirline.api_airline.DTO;
import com.APIAirline.api_airline.model.SeatClass;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class BookingRequestDTO {
    @NotNull(message = "Booking date is required")
    private LocalDateTime bookingDate;

    @NotNull(message = "Seat class is required")
    private SeatClass seatClass;

    @NotNull(message = "Passenger ID is required")
    private Long passengerId;

    @NotNull(message = "Flight ID is required")
    private Long flightId;

    public BookingRequestDTO() {}

    public LocalDateTime getBookingDate() { return bookingDate; }
    public void setBookingDate(LocalDateTime bookingDate) { this.bookingDate = bookingDate; }

    public SeatClass getSeatClass() { return seatClass; }
    public void setSeatClass(SeatClass seatClass) { this.seatClass = seatClass; }

    public Long getPassengerId() { return passengerId; }
    public void setPassengerId(Long passengerId) { this.passengerId = passengerId; }

    public Long getFlightId() { return flightId; }
    public void setFlightId(Long flightId) { this.flightId = flightId; }
}
