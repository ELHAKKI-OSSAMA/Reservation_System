package elhakki.ossama.systeme_de_reservation.Services;

import elhakki.ossama.systeme_de_reservation.Entities.JuryMember;
import elhakki.ossama.systeme_de_reservation.Entities.Reservation;
import elhakki.ossama.systeme_de_reservation.Entities.Session;
import elhakki.ossama.systeme_de_reservation.Entities.User;
import elhakki.ossama.systeme_de_reservation.Repositories.JuryMemberRepositorie;
import elhakki.ossama.systeme_de_reservation.Repositories.ReservationRepositorie;
import elhakki.ossama.systeme_de_reservation.Repositories.SessionRepositorie;
import elhakki.ossama.systeme_de_reservation.Repositories.UserRepositorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class IReservationServicesImpl implements IReservationServices{
    @Autowired
    private JuryMemberRepositorie juryMemberRepositorie;
    @Autowired
    private ReservationRepositorie reservationRepositorie;
    @Autowired
    private SessionRepositorie sessionRepositorie;
    @Autowired
    private UserRepositorie userRepositorie;


    @Override
    public JuryMember saveJuryMember(JuryMember juryMember) {
        return juryMemberRepositorie.save(juryMember);
    }

    @Override
    public Reservation saveReservation(Reservation reservation) {
        return reservationRepositorie.save(reservation);
    }

    @Override
    public Session saveSession(Session session) {
        return sessionRepositorie.save(session);
    }

    @Override
    public User saveUser(User user) {
        return userRepositorie.save(user);
    }

    @Override
    public JuryMember findJuryMemberById(Long id) {
        return juryMemberRepositorie.findById(id).get();
    }

    @Override
    public Reservation findReservationById(Long id) {
        return reservationRepositorie.findById(id).get();
    }

    @Override
    public Session findSessionById(Long id) {
        return sessionRepositorie.findById(id).get();
    }

    @Override
    public User findUserById(Long id) {
        return userRepositorie.findById(id).get();
    }

    @Override
    public List<User> findUserByName(String name) {
        return userRepositorie.findByName(name);
    }

    @Override
    public List<JuryMember> findAllJuryMember() {
        return juryMemberRepositorie.findAll();
    }

    @Override
    public List<Reservation> findAllReservation() {
        return reservationRepositorie.findAll();
    }

    @Override
    public List<Session> findAllSession() {
        return sessionRepositorie.findAll();
    }

    @Override
    public List<User> findAllUser() {
        return userRepositorie.findAll();
    }
}
