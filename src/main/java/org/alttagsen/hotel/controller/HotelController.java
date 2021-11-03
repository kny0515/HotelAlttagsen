package org.alttagsen.hotel.controller;

import lombok.RequiredArgsConstructor;
import org.alttagsen.hotel.dto.MemberInput;
import org.alttagsen.hotel.dto.Reservation2DTO;
import org.alttagsen.hotel.dto.Reservation3DTO;
import org.alttagsen.hotel.dto.ReservationDTO;
import org.alttagsen.hotel.entity.Reservation2;
import org.alttagsen.hotel.entity.Reservation3;
import org.alttagsen.hotel.service.MemberService;
import org.alttagsen.hotel.service.Reservation2Service;
import org.alttagsen.hotel.service.Reservation3Service;
import org.alttagsen.hotel.service.ReservationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RequiredArgsConstructor
@Controller
public class HotelController {

    private final MemberService memberService;
    private final ReservationService reservationService;
    private final Reservation2Service reservation2Service;
    private final Reservation3Service reservation3Service;

    @GetMapping("/hotel/join")
    public String join(){
        return "/hotel/join";
    }



    @PostMapping("/hotel/join")
    public String joinSubmit(Model model,
                             MemberInput parameter){

        boolean result = memberService.register(parameter);

        model.addAttribute("result", result);

        return "/hotel/join_complete";
    }

    @RequestMapping("/hotel/login")
    public String login(){
        return "/hotel/login";
    }
    @GetMapping("/hotel/introduce")
    public String introduce(){
        return "/hotel/introduce";
    }
    @GetMapping("/hotel/room")
    public String room(){
        return "/hotel/room";
    }
    @GetMapping("/hotel/convenience")
    public String convenience(){
        return "/hotel/convenience";
    }
    @GetMapping("/hotel/event")
    public String event(){
        return "/hotel/event";
    }
    @GetMapping("/hotel/service")
    public String service(){
        return "/hotel/service";
    }
    @GetMapping("/hotel/restaurant")
    public String restaurant(){
        return "/hotel/res";
    }
    @GetMapping("/hotel/reservation")
    public String reservation(Model model){
        return "/hotel/reservation";
    }
    @GetMapping("/hotel/reservation_room")
    public String reservationRoom1(){return "/hotel/reservation_room";}
    @GetMapping("/hotel/reservation_room2")
    public String reservationRoom2(){return "/hotel/reservation_room2";}
    @GetMapping("/hotel/reservation_room3")
    public String reservationRoom3(){return "/hotel/reservation_room3";}
    @GetMapping("/hotel/map")
    public String map(){
        return "/hotel/map";
    }


    @GetMapping("/hotel/reservation_list")
    public String reservation_list(Model model){

        List<ReservationDTO> reservationDTOS = reservationService.getReservationList();

        model.addAttribute("reservationList", reservationDTOS);
        return "/hotel/reservation_list";


    }

    @GetMapping("/hotel/reservation2_list")
    public String reservation2_list(Model model){

        List<Reservation2DTO> reservationDTOS = reservation2Service.getReservationList();

        model.addAttribute("reservationList", reservationDTOS);
        return "/hotel/reservation2_list";


    }

    @GetMapping("/hotel/reservation3_list")
    public String reservation3_list(Model model){

        List<Reservation3DTO> reservationDTOS = reservation3Service.getReservationList();

        model.addAttribute("reservationList", reservationDTOS);
        return "/hotel/reservation3_list";


    }

    @PostMapping("/hotel/reservation_room")
    public String reservation_ok(Model model, HttpServletRequest request,
                                 ReservationDTO reservationDTO){

        boolean result = reservationService.reservationRegister(reservationDTO);

        String name = request.getParameter("resName");
        String birth = request.getParameter("resBirth");
        String phone = request.getParameter("resPhone");
        String id = request.getParameter("resUser");
        String start = request.getParameter("startResDate");
        String end = request.getParameter("endResDate");

        model.addAttribute("result", result);
        model.addAttribute("birth", birth);
        model.addAttribute("phone", phone);
        model.addAttribute("id", id);
        model.addAttribute("name", name);
        model.addAttribute("start", start);
        model.addAttribute("end", end);


        return "/hotel/reservation_ok";
    }
    @PostMapping("/hotel/reservation_room2")
    public String reservation_ok2(Model model, HttpServletRequest request,
                                 Reservation2DTO reservationDTO){

        boolean result = reservation2Service.reservationRegister(reservationDTO);

        String name = request.getParameter("resName");
        String birth = request.getParameter("resBirth");
        String phone = request.getParameter("resPhone");
        String id = request.getParameter("resUser");
        String start = request.getParameter("startResDate");
        String end = request.getParameter("endResDate");

        model.addAttribute("result", result);
        model.addAttribute("birth", birth);
        model.addAttribute("phone", phone);
        model.addAttribute("id", id);
        model.addAttribute("name", name);
        model.addAttribute("start", start);
        model.addAttribute("end", end);


        return "/hotel/reservation_ok2";
    }
    @PostMapping("/hotel/reservation_room3")
    public String reservation_ok3(Model model, HttpServletRequest request,
                                  Reservation3DTO reservationDTO){

        boolean result = reservation3Service.reservationRegister(reservationDTO);

        String name = request.getParameter("resName");
        String birth = request.getParameter("resBirth");
        String phone = request.getParameter("resPhone");
        String id = request.getParameter("resUser");
        String start = request.getParameter("startResDate");
        String end = request.getParameter("endResDate");

        model.addAttribute("result", result);
        model.addAttribute("birth", birth);
        model.addAttribute("phone", phone);
        model.addAttribute("id", id);
        model.addAttribute("name", name);
        model.addAttribute("start", start);
        model.addAttribute("end", end);


        return "/hotel/reservation_ok3";
    }
}
