package com.APIAirline.api_airline.service;

import com.APIAirline.api_airline.DTO.BookingRequestDTO;
import com.APIAirline.api_airline.DTO.BookingResponseDTO;
import com.APIAirline.api_airline.model.Booking;
import com.APIAirline.api_airline.model.Flight;
import com.APIAirline.api_airline.model.Passenger;
import com.APIAirline.api_airline.repository.BookingRepository;
import com.APIAirline.api_airline.repository.FlightRepository;
import com.APIAirline.api_airline.repository.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookingService {
    @Autowired
    private final BookingRepository bookingRepository;

    @Autowired
    private final PassengerRepository passengerRepository;

    @Autowired
    private final FlightRepository flightRepository;

    public BookingService(BookingRepository bookingRepository, PassengerRepository passengerRepository, FlightRepository flightRepository) {
        this.bookingRepository = bookingRepository;
        this.passengerRepository = passengerRepository;
        this.flightRepository = flightRepository;
    }

    public List<BookingResponseDTO> findAll() {
        return bookingRepository.findAll().stream()
                .map(BookingResponseDTO::from)
                .collect(Collectors.toList());
    }

    public BookingResponseDTO findById(Long id) {
        return bookingRepository.findById(id)
                .map(BookingResponseDTO::from)
                .orElse(null);
    }

    public BookingResponseDTO save(BookingRequestDTO dto) {
        Passenger passenger = passengerRepository.findById(dto.getPassengerId()).orElse(null);
        Flight flight = flightRepository.findById(dto.getFlightId()).orElse(null);

        if (passenger == null || flight == null) {
            return null;
        }

        Booking booking = new Booking(dto.getBookingDate(), dto.getSeatClass(), passenger, flight);
        Booking savedBooking = bookingRepository.save(booking);
        return BookingResponseDTO.from(savedBooking);
    }

    public BookingResponseDTO update(Long id, BookingRequestDTO dto) {
        Booking existingBooking = bookingRepository.findById(id).orElse(null);
        if (existingBooking == null) return null;

        Passenger passenger = passengerRepository.findById(dto.getPassengerId()).orElse(null);
        Flight flight = flightRepository.findById(dto.getFlightId()).orElse(null);

        if (passenger == null || flight == null) return null;

        existingBooking.setBookingDate(dto.getBookingDate());
        existingBooking.setSeatClass(dto.getSeatClass());
        existingBooking.setPassenger(passenger);
        existingBooking.setFlight(flight);

        Booking updatedBooking = bookingRepository.save(existingBooking);
        return BookingResponseDTO.from(updatedBooking);
    }

    public void delete(Long id) {
        bookingRepository.deleteById(id);
    }


}
