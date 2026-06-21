package elhakki.ossama.systeme_de_reservation.Repositories;


import elhakki.ossama.systeme_de_reservation.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepositorie extends JpaRepository<User,Long> {
    List<User> findByName (String name);
}
