package com.art.user;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Column(name = "user_type")
    private UserType userType;

    @NotNull
    @Column(name = "name")
    private String name;
}