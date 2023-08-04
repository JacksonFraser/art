package com.space.account;

import com.space.user.User;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Entity
@Table(name = "account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotNull
    @Column(name = "accountName")
    private String accountName;

    @NotNull
    @Column(name = "accountType")
    private String accountType;

    @NotNull
    @OneToOne(mappedBy = "account")
    private User user;
}
