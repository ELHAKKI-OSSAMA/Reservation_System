package elhakki.ossama.systeme_de_reservation.Entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity @Builder
@Table(name = "sessions") // "session" est un mot reserve sur plusieurs SGBD
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Session {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate date;
    private LocalTime startTime;
    private LocalTime endTime;
    private int maxReservations;

    @OneToMany(mappedBy = "session")
    private List<Reservation> reservations;

    @OneToMany(mappedBy = "session")
    private List<JuryMember> juryMembers;


}
