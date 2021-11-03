package org.alttagsen.hotel.service;

import org.alttagsen.hotel.dto.Reservation2DTO;

import java.util.List;


public interface Reservation2Service {

    boolean reservationRegister(Reservation2DTO reservationDTO);

    List<Reservation2DTO> getReservationList();
}
