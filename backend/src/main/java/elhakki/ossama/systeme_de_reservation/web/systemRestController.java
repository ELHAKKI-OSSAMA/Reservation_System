package elhakki.ossama.systeme_de_reservation.web;

import elhakki.ossama.systeme_de_reservation.Entities.JuryMember;
import elhakki.ossama.systeme_de_reservation.Entities.Reservation;
import elhakki.ossama.systeme_de_reservation.Entities.Session;
import elhakki.ossama.systeme_de_reservation.Entities.User;
import elhakki.ossama.systeme_de_reservation.Repositories.JuryMemberRepositorie;
import elhakki.ossama.systeme_de_reservation.Repositories.ReservationRepositorie;
import elhakki.ossama.systeme_de_reservation.Repositories.SessionRepositorie;
import elhakki.ossama.systeme_de_reservation.Repositories.UserRepositorie;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@AllArgsConstructor
@Slf4j
@CrossOrigin("*")
public class systemRestController {

    private JuryMemberRepositorie juryMemberRepositorie;

    private ReservationRepositorie reservationRepositorie;

    private SessionRepositorie sessionRepositorie;

    private UserRepositorie userRepositorie;
    @GetMapping("/users")
    public List<User> userList(){
        return userRepositorie.findAll();
    }
    @GetMapping("/Reservations")
    public List<Reservation> reservationList(){
        return reservationRepositorie.findAll();
    }
    @GetMapping("/Sessions")
    public List<Session> sessionslist(){
        return sessionRepositorie.findAll();
    }
    @GetMapping("/JuryMembers")
    public List<JuryMember> JuryMemberList(){
        return juryMemberRepositorie.findAll();
    }

}
