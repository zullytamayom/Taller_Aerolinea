package com.APIAirline.api_airline.DTO;

import com.APIAirline.api_airline.model.Booking;
import com.APIAirline.api_airline.model.SeatClass;

import java.time.LocalDateTime;

public class BookingResponseDTO {
    private Long id;
    private LocalDateTime bookingDate;
    private SeatClass seatClass;
    private Long passengerId;
    private String passengerName;
    private Long flightId;
    private String flightOrigin;
    private String flightDestination;

    public BookingResponseDTO() {}

    // Static mapper method
    public static BookingResponseDTO from(Booking booking) {
        BookingResponseDTO dto = new BookingResponseDTO();
        dto.setId(booking.getId());
        dto.setBookingDate(booking.getBookingDate());
        dto.setSeatClass(booking.getSeatClass());

        if (booking.getPassenger() != null) {
            dto.setPassengerId(booking.getPassenger().getIdPassanger());
            dto.setPassengerName(booking.getPassenger().getFirstName() + " " + booking.getPassenger().getLastName());
        }

        if (booking.getFlight() != null) {
            dto.setFlightId(booking.getFlight().getIdFlight());
            dto.setFlightOrigin(booking.getFlight().getFrom());
            dto.setFlightDestination(booking.getFlight().getTo());
        }
        return dto;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public LocalDateTime getBookingDate() { return bookingDate; }
    public void setBookingDate(LocalDateTime bookingDate) { this.bookingDate = bookingDate; }

    public SeatClass getSeatClass() { return seatClass; }
    public void setSeatClass(SeatClass seatClass) { this.seatClass = seatClass; }

    public Long getPassengerId() { return passengerId; }
    public void setPassengerId(Long passengerId) { this.passengerId = passengerId; }

    public String getPassengerName() { return passengerName; }
    public void setPassengerName(String passengerName) { this.passengerName = passengerName; }

    public Long getFlightId() { return flightId; }
    public void setFlightId(Long flightId) { this.flightId = flightId; }

    public String getFlightOrigin() { return flightOrigin; }
    public void setFlightOrigin(String flightOrigin) { this.flightOrigin = flightOrigin; }

    public String getFlightDestination() { return flightDestination; }
    public void setFlightDestination(String flightDestination) { this.flightDestination = flightDestination; }
}
