package com.geekster.BloggingPlatformAPI.Model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class AuthenticationToken {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long authenticationId;

    private String tokenValue;

    private LocalDateTime tokenCreationDateTime;

    @OneToOne
    @JoinColumn(name = "fk_user_id")
    User user;

    public AuthenticationToken(User existingUser) {
        this.user = existingUser;
        this.tokenValue = UUID.randomUUID().toString();
        this.tokenCreationDateTime = LocalDateTime.now();
    }
}
