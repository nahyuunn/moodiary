package com.moodiary.moodiary_back.entity;

import com.moodiary.moodiary_back.dto.request.SignUpRequestDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;
    private String userEmail;
    private String nickname;
    private String password;

    public User(SignUpRequestDto dto) {
        this.userEmail = dto.getUserEmail();
        this.nickname = dto.getNickname();
        this.password = dto.getPassword();
    }
}
