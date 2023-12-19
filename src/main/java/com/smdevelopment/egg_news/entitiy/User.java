package com.smdevelopment.egg_news.entitiy;

import java.time.LocalDate;

import com.smdevelopment.egg_news.enums.Role;
import com.smdevelopment.egg_news.validation.ValidRole;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter 
@Setter
@Entity
@Table(name = "users")
@Inheritance(strategy = InheritanceType.JOINED)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotBlank(message = "Username cannot be blank.")
    @Column(name = "username", nullable = false)
    private String username;
    
    @NotBlank(message = "Password cannot be blank.")
    @Column(name = "password", nullable = false)
    private String password;

    // @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    @Column(name = "registration_date")
    @Temporal(TemporalType.DATE)
    private LocalDate registrationDate;

    @ValidRole(anyOf = {Role.JOURNALIST, Role.USER})
    @Column(name = "role", nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role;

    @Column(name = "is_active", nullable = false)
    private boolean isActive; 
    

    public User(String username, String password, Role role) {
        this.username = username;
        this.password = password;
        this.registrationDate = LocalDate.now();
        this.role = role;
        this.isActive = true;
    }
    
}
