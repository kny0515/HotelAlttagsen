package org.alttagsen.hotel.service.impl;

import lombok.RequiredArgsConstructor;
import org.alttagsen.hotel.dto.Reservation3DTO;
import org.alttagsen.hotel.dto.ReservationDTO;

import org.alttagsen.hotel.entity.Reservation;
import org.alttagsen.hotel.entity.Reservation3;
import org.alttagsen.hotel.repository.Reservation3Repository;
import org.alttagsen.hotel.repository.ReservationRepository;

import org.alttagsen.hotel.service.Reservation3Service;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class Reservation3ServiceImpl implements Reservation3Service {

    private final Reservation3Repository reservationRepository;

    @Override
    public boolean reservationRegister(Reservation3DTO reservationDTO) {

        Optional<Reservation3> optionalReservation = reservationRepository.findById(reservationDTO.getStartResDate());

        if (optionalReservation.isPresent()) {
            return false;
        }
        Reservation3 reservation = Reservation3.builder()
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
    public List<Reservation3DTO> getReservationList() {
        List<Reservation3> reservations = reservationRepository.findAll();
        List<Reservation3DTO> reservationDTOList = new ArrayList<>();

        for (Reservation3 reservation : reservations){
            Reservation3DTO reservationDTO = Reservation3DTO.builder()
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
