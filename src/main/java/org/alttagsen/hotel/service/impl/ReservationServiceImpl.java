package org.alttagsen.hotel.service.impl;

import lombok.RequiredArgsConstructor;
import org.alttagsen.hotel.dto.ReservationDTO;
import org.alttagsen.hotel.entity.Reservation;
import org.alttagsen.hotel.repository.ReservationRepository;
import org.alttagsen.hotel.service.ReservationService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ReservationServiceImpl implements ReservationService {

    private final ReservationRepository reservationRepository;

    @Override
    public boolean reservationRegister(ReservationDTO reservationDTO) {

       Optional<Reservation> optionalReservation = reservationRepository.findById(reservationDTO.getStartResDate());

       if (optionalReservation.isPresent()){
           return false;
       }

             Reservation reservation = Reservation.builder()
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
    public List<ReservationDTO> getReservationList() {
        List<Reservation> reservations = reservationRepository.findAll();
        List<ReservationDTO> reservationDTOList = new ArrayList<>();

        for (Reservation reservation : reservations){
            ReservationDTO reservationDTO = ReservationDTO.builder()
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
