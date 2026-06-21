package elhakki.ossama.systeme_de_reservation;

import elhakki.ossama.systeme_de_reservation.Entities.*;
import elhakki.ossama.systeme_de_reservation.Enums.ReservationStatus;
import elhakki.ossama.systeme_de_reservation.Enums.Role;
import elhakki.ossama.systeme_de_reservation.Services.IReservationServices;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.stream.Stream;

@SpringBootApplication
public class SystemeDeReservationApplication {

    public static void main(String[] args) {
        SpringApplication.run(SystemeDeReservationApplication.class, args);
    }

    @Bean
    CommandLineRunner start(IReservationServices reservationServices) {
        return args -> {
            // Create Users
            Stream.of("User1", "User2", "User3").forEach(name -> {
                User user = User.builder()
                        .name(name)
                        .email(name.toLowerCase() + "@example.com")
                        .role(Role.USER)
                        .build();
                reservationServices.saveUser(user);
            });

            // Retrieve Users and set their roles as JURY
            User user1 = reservationServices.findUserByName("User1").get(0);
            User user2 = reservationServices.findUserByName("User2").get(0);
            user1.setRole(Role.JURY);
            user2.setRole(Role.JURY);
            reservationServices.saveUser(user1);
            reservationServices.saveUser(user2);

            // Create Session
            Session session = Session.builder()
                    .date(LocalDate.now())
                    .startTime(LocalTime.of(9, 0))
                    .endTime(LocalTime.of(11, 0))
                    .maxReservations(5)
                    .build();
            reservationServices.saveSession(session);

            // Create Jury Members
            JuryMember juryMember1 = JuryMember.builder()
                    .user(user1)
                    .session(session)
                    .build();
            JuryMember juryMember2 = JuryMember.builder()
                    .user(user2)
                    .session(session)
                    .build();
            reservationServices.saveJuryMember(juryMember1);
            reservationServices.saveJuryMember(juryMember2);

            // Create Reservations
            User user3 = reservationServices.findUserByName("User3").get(0);
            Reservation reservation = Reservation.builder()
                    .user(user3)
                    .session(session)
                    .status(ReservationStatus.Confirmed)
                    .build();
            reservationServices.saveReservation(reservation);
        };
    }
}
