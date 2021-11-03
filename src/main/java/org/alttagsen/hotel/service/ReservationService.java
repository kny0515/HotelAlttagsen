package org.alttagsen.hotel.service;

import org.alttagsen.hotel.dto.ReservationDTO;

import java.util.List;

public interface ReservationService {

    boolean reservationRegister(ReservationDTO reservationDTO);

    List<ReservationDTO> getReservationList();
}
