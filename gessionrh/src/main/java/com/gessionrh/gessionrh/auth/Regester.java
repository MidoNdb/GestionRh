// package com.gessionrh.gessionrh.auth;

// import java.util.Optional;

// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.RequestBody;

// import com.gessionrh.gessionrh.dao.UserRepository;
// import com.gessionrh.gessionrh.dto.RegisterModel;
// import com.gessionrh.gessionrh.entity.AppUser;

// public class Regester {
//     UserRepository appUserRepository;
//        // @Override
//     public ResponseEntity<?> register(@RequestBody RegisterModel registerModel) {
//         // Check if email, username, and password are not null or empty
//         if (registerModel.getEmail() == null || registerModel.getEmail().isEmpty() ||
//                 registerModel.getUsername() == null || registerModel.getUsername().isEmpty() ||
//                 registerModel.getPassword() == null || registerModel.getPassword().isEmpty()) {
//             return ResponseEntity.badRequest()
//                     .body("Messages.REGISTER_REQUIREMENTS");
//         }
//         // Check if password is greater than 4 characters
//         if (registerModel.getPassword().length() < 4) {
//             return ResponseEntity.badRequest()
//                     .body("Messages.SHORT_PASSWORD");
//         }
//         // Check if email is in valid syntax
//         if (!isValidMail(registerModel.getEmail())) {
//             return ResponseEntity.badRequest().body("Messages.EMAIL_SYNTAX_ERR");
//         }
//         // Check if username or email already exists
//         Optional<AppUser> existingUser = appUserRepository.findByUsername(registerModel.getUsername());
//         if (existingUser.isPresent() || appUserRepository.findByEmail(registerModel.getEmail()).isPresent()) {
//             return ResponseEntity.status(HttpStatus.CONFLICT).body("Messages.CONFLICT");
//         }
//         AppUser userInfo = AppUser.builder().username(registerModel.getUsername()).email(registerModel.getEmail())
//                 .phoneNumber(registerModel.getPhoneNumber()).nni(registerModel.getNni())
//                 .password(registerModel.getPassword()).build();
//         // If all checks pass, add the new user
//         return ResponseEntity.status(HttpStatus.CREATED).body(adminServices.addUser(userInfo));
//     }
// }
