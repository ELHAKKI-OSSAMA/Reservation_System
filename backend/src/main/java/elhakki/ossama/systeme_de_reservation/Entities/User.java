package elhakki.ossama.systeme_de_reservation.Entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import elhakki.ossama.systeme_de_reservation.Enums.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity @Builder
@Table(name = "users") // "user" est un mot reserve sur plusieurs SGBD (H2, PostgreSQL...)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private Role role;

    @OneToMany(mappedBy = "user")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Reservation> reservations;

}
