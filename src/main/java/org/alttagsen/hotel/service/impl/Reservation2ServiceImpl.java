package org.alttagsen.hotel.service.impl;

import lombok.RequiredArgsConstructor;
import org.alttagsen.hotel.dto.Reservation2DTO;
import org.alttagsen.hotel.dto.ReservationDTO;
import org.alttagsen.hotel.entity.Reservation;
import org.alttagsen.hotel.entity.Reservation2;
import org.alttagsen.hotel.repository.Reservation2Repository;
import org.alttagsen.hotel.repository.ReservationRepository;
import org.alttagsen.hotel.service.Reservation2Service;
import org.alttagsen.hotel.service.ReservationService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class Reservation2ServiceImpl implements Reservation2Service {

    private final Reservation2Repository reservationRepository;

    @Override
    public boolean reservationRegister(Reservation2DTO reservationDTO) {

        Optional<Reservation2> optionalReservation = reservationRepository.findById(reservationDTO.getStartResDate());

        if (optionalReservation.isPresent()) {
            return false;
        }
        Reservation2 reservation = Reservation2.builder()
                .startResDate(reservationDTO.getStartResDate())
                .endResDate(reservationDTO.getEndResDate())
                .resUser(reservationDTO.getResUser())
                .resName(reservationDTO.getResName())
                .resBirth(reservationDTO.getResBirth())
                .resPhone(reservationDTO.getResPhone())
                .build();

        reservationRepository.save(reservation);

        return true;
    }

    @Override
    public List<Reservation2DTO> getReservationList() {
        List<Reservation2> reservations = reservationRepository.findAll();
        List<Reservation2DTO> reservationDTOList = new ArrayList<>();

        for (Reservation2 reservation : reservations){
            Reservation2DTO reservationDTO = Reservation2DTO.builder()
                    .startResDate(reservation.getStartResDate())
                    .endResDate(reservation.getEndResDate())
                    .resUser(reservation.getResUser())
                    .resName(reservation.getResName())
                    .resBirth(reservation.getResBirth())
                    .resPhone(reservation.getResPhone())
                    .build();

            reservationDTOList.add(reservationDTO);
        }

        return reservationDTOList;
    }

}
