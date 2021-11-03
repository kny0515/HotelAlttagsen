package org.alttagsen.hotel.service;

import org.alttagsen.hotel.dto.Reservation3DTO;

import java.util.List;


public interface Reservation3Service {

    boolean reservationRegister(Reservation3DTO reservationDTO);

    List<Reservation3DTO> getReservationList();
}
