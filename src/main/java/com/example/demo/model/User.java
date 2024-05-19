package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.Id;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@EqualsAndHashCode
@Table(name = "users")
public class User {

    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    @Id
    private Long id;

    @Column(name = "fullName", nullable = false, length = 80)
    private String fullName;

    @Column(name = "password", nullable = false, length = 80)
    private String password;
    @Column(name = "email", nullable = false, length = 40, unique = true)
    private String email;
    @Column(name = "phone", nullable = false, length = 12, unique = true)
    private String phone;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
