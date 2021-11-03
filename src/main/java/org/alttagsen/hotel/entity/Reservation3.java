package org.alttagsen.hotel.entity;


import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class Reservation3 {
    @Id
    private String startResDate;
    private String endResDate;
    private String resUser;
    private String resName;
    private String resBirth;
    private String resPhone;

}
