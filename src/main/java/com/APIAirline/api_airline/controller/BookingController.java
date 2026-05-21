package com.APIAirline.api_airline.controller;

import com.APIAirline.api_airline.DTO.BookingRequestDTO;
import com.APIAirline.api_airline.DTO.BookingResponseDTO;
import com.APIAirline.api_airline.service.BookingService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Bookings", description = "Management of passenger seat bookings on flights")
@RestController
@RequestMapping("/bookings")
public class BookingController {

    @Autowired
    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @Operation(summary = "List all registered flight bookings")
    @GetMapping
    public ResponseEntity<List<BookingResponseDTO>> getAll() {
        return ResponseEntity.ok(bookingService.findAll());
    }

    @Operation(summary = "Find a booking by its unique ID")
    @GetMapping("/{id}")
    public ResponseEntity<BookingResponseDTO> getById(@PathVariable Long id) {
        BookingResponseDTO result = bookingService.findById(id);
        return result == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(result);
    }

    @Operation(summary = "Create a new flight booking")
    @PostMapping
    public ResponseEntity<BookingResponseDTO> create(@Valid @RequestBody BookingRequestDTO dto) {
        BookingResponseDTO result = bookingService.save(dto);
        if (result == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @Operation(summary = "Update an existing booking by its ID")
    @PutMapping("/{id}")
    public ResponseEntity<BookingResponseDTO> update(@PathVariable Long id, @Valid @RequestBody BookingRequestDTO dto) {
        BookingResponseDTO result = bookingService.update(id, dto);
        return result == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(result);
    }

    @Operation(summary = "Remove a flight booking record by its ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (bookingService.findById(id) == null) {
            return ResponseEntity.notFound().build();
        }
        bookingService.delete(id);
        return ResponseEntity.noContent().build();
    }
}