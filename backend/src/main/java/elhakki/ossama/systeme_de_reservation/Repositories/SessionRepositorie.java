package elhakki.ossama.systeme_de_reservation.Repositories;


import elhakki.ossama.systeme_de_reservation.Entities.Session;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionRepositorie extends JpaRepository<Session,Long> {
}
