package org.alttagsen.hotel.dto;

import lombok.*;

@Data
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Reservation3DTO {

    private String startResDate;
    private String endResDate;
    private String resUser;
    private String resName;
    private String resBirth;
    private String resPhone;
}
