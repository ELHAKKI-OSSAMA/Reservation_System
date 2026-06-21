package elhakki.ossama.systeme_de_reservation.Repositories;

import elhakki.ossama.systeme_de_reservation.Entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepositorie extends JpaRepository<Reservation,Long> {
}
