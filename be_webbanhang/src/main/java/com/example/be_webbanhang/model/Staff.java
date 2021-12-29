package com.example.be_webbanhang.model;

import lombok.*;

import javax.persistence.*;


@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "staff")
public class Staff {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idStaff;
    private String fullname;
    private String username;
    private String password;
    private String sodt;
    private String email;

    @ManyToOne
    @JoinColumn(name = "idRole")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Role role;
}
