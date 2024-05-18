package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import lombok.*;
import org.springframework.data.annotation.Id;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@EqualsAndHashCode
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "fullName", nullable = false, length = 80)
    private String fullName;
    @Column(name = "password", nullable = false, length = 80)
    private String password;
    @Column(name = "email", nullable = false, length = 40, unique = true)
    private String email;
    @Column(name = "phone", nullable = false, length = 12, unique = true)
    private String phone;
}
