package org.alttagsen.hotel.controller;

import lombok.RequiredArgsConstructor;
import org.alttagsen.hotel.dto.MemberInput;
import org.alttagsen.hotel.dto.Reservation2DTO;
import org.alttagsen.hotel.dto.Reservation3DTO;
import org.alttagsen.hotel.dto.ReservationDTO;
import org.alttagsen.hotel.entity.Member;
import org.alttagsen.hotel.entity.Reservation3;
import org.alttagsen.hotel.service.MemberService;
import org.alttagsen.hotel.service.Reservation2Service;
import org.alttagsen.hotel.service.Reservation3Service;
import org.alttagsen.hotel.service.ReservationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Controller
public class AdminMemberController {

    private final MemberService memberService;
    private final ReservationService reservationService;
    private final Reservation2Service reservation2Service;
    private final Reservation3Service reservation3Service;

    @GetMapping("/admin/member/list")
    public String list(Model model){

        List<MemberInput> memberInputs = memberService.getMemberList();

        model.addAttribute("member", memberInputs);

        return "/admin/member/list";
    }
    @PostMapping("/admin/member/list")
    public String listSearch(Model model, HttpServletRequest request){

        String id = request.getParameter("userid");

        MemberInput result = memberService.getMember(id);

        model.addAttribute("member", result);

        return "/admin/member/listSearch";
    }

    @GetMapping("/admin/member/reservation")
    public String reservation(){

        return "/admin/member/reservation";
    }
    @GetMapping("/admin/member/room1")
    public String reservationRoom(Model model){

        List<ReservationDTO> reservationDTOList = reservationService.getReservationList();

        model.addAttribute("reservationList", reservationDTOList);

        return "/admin/member/room1";
    }

    @GetMapping("/admin/member/room2")
    public String reservationRoom2(Model model){

        List<Reservation2DTO> reservationDTOList = reservation2Service.getReservationList();

        model.addAttribute("reservationList", reservationDTOList);

        return "/admin/member/room2";
    }

    @GetMapping("/admin/member/room3")
    public String reservationRoom3(Model model){

        List<Reservation3DTO> reservationDTOList = reservation3Service.getReservationList();

        model.addAttribute("reservationList", reservationDTOList);

        return "/admin/member/room3";
    }
}
