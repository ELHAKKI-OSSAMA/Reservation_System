package elhakki.ossama.systeme_de_reservation.Services;

import elhakki.ossama.systeme_de_reservation.Entities.JuryMember;
import elhakki.ossama.systeme_de_reservation.Entities.Reservation;
import elhakki.ossama.systeme_de_reservation.Entities.Session;
import elhakki.ossama.systeme_de_reservation.Entities.User;

import java.util.List;

public interface IReservationServices {

    JuryMember saveJuryMember(JuryMember juryMember);
    Reservation saveReservation(Reservation reservation);
    Session saveSession(Session session);
    User saveUser(User user);

    JuryMember findJuryMemberById(Long id);
    Reservation findReservationById(Long id);
    Session findSessionById(Long id);
    User findUserById(Long id);

    List<User> findUserByName(String name);

    List<JuryMember> findAllJuryMember();
    List<Reservation> findAllReservation();
    List<Session> findAllSession();
    List<User> findAllUser();



}
