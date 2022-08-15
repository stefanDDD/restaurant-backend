package com.ibm.restaurant.reservation;

import com.ibm.restaurant.application.reservation.ReservationService;
import com.ibm.restaurant.domain.reservations.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/reservations")
public class ReservationController {

    @Autowired
    private ReservationMapperService reservationMapperService;
    @Autowired
    private ReservationService  service;

    @PostMapping
    public ResponseEntity<Void> createReservation(@RequestBody ReservationDTO reservationDTO) {
        Long tableId = reservationDTO.tableId;
        Reservation reservation = reservationMapperService.mapToDomain(reservationDTO);
        service.createReservation(reservation, tableId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/{clientName}")
    public ResponseEntity<List<ReservationDTO>> findAllByClientName(@PathVariable String clientName) {
        List<ReservationDTO> reservations = service.findAllByClientName(clientName).stream().map(reservationMapperService::mapFromDomain).collect(Collectors.toList());
        return ResponseEntity.ok(reservations);
    }

    @PutMapping("/{reservationId}")
    public ResponseEntity<ReservationDTO> updateReservation(@PathVariable("reservationId") Long reservationId, @RequestBody ReservationDTO reservationDTO){
        return Optional.ofNullable(reservationMapperService.mapToDomain(reservationDTO)).map(reservationObj ->{
            Reservation updReservation = service.updateReservation(reservationObj);
            ReservationDTO reservation1 = reservationMapperService.mapFromDomain(updReservation);
            return  ResponseEntity.status(HttpStatus.OK).body(reservation1);
        }).orElse(null);
    }

    @GetMapping("/getById/{reservationId}")
    public ResponseEntity<ReservationDTO> getReservationById(@PathVariable final Long reservationId){
        Reservation reservation = service.getReservationById(reservationId);
        ReservationDTO reservationDTO = reservationMapperService.mapFromDomain(reservation);
        return ResponseEntity.status(HttpStatus.OK).body(reservationDTO);
    }


}
