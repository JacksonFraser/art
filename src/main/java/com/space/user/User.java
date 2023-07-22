package com.space.user;

import com.space.account.Account;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
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
    @OneToOne
    @JoinColumn(name = "account_id", nullable = false)
    private Account account;

    @NotNull
    @Column(name = "name")
    private String name;
}