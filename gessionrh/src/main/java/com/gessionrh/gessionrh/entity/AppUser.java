package com.gessionrh.gessionrh.entity;

//package com.example.bestteamproject.entity;

import java.time.LocalDateTime;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.LastModifiedDate;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(nullable = false, unique = true)
    private String username;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false, updatable = true)
    private String password;
    @Column(unique = true)
    private String nni;
    @Column(unique = true)
    private String phoneNumber;
    private String address;


    @ManyToOne(optional = true)
    private Role role;

    @CreationTimestamp
    private LocalDateTime createdAt;
    @LastModifiedDate
    private LocalDateTime updatedAt;
}
// import java.util.HashSet;
// import java.util.Set;

// import jakarta.persistence.CascadeType;
// import jakarta.persistence.Column;
// import jakarta.persistence.Entity;
// import jakarta.persistence.FetchType;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;
// import jakarta.persistence.JoinColumn;
// import jakarta.persistence.JoinTable;
// import jakarta.persistence.ManyToMany;
// import lombok.AllArgsConstructor;
// import lombok.Data;
// import lombok.NoArgsConstructor;


// @AllArgsConstructor
// @NoArgsConstructor
// @Entity  
// @Data
// public class Users {
//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     Integer id;
//     @Column(unique = true ,nullable = false)
//     private String nomUser;
//     @Column(unique = true ,nullable = false)
//     private String email;
//     @Column(unique = true ,nullable = false)
//     private String password;

//     @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//     @JoinTable(
//             name = "users_roles",
//             joinColumns = @JoinColumn(
//                     name = "user_id",
//                     referencedColumnName = "id"
//             ),
//             inverseJoinColumns = @JoinColumn(
//                     name = "role_id",
//                     referencedColumnName = "id"
//             )
//     )
//     private Set<Role> roles = new HashSet<>();
// }
