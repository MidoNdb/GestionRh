// package com.gessionrh.gessionrh.auth;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.autoconfigure.pulsar.PulsarProperties.Authentication;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
// import org.springframework.security.authentication.AuthenticationManager;
// import org.springframework.web.bind.annotation.RequestBody;

// import com.gessionrh.gessionrh.dao.UserRepository;
// import com.gessionrh.gessionrh.dto.AuthRequest;
// import com.gessionrh.gessionrh.dto.AuthResponse;
// import com.gessionrh.gessionrh.dto.RegisterModel;
// import com.gessionrh.gessionrh.entity.AppUser;
// import com.gessionrh.gessionrh.security.JwtService;


// public class Login {
//     @Autowired
//     private JwtService jwtService;

//     private UserRepository appUserRepository;
    
//     //@Override
//     public ResponseEntity<?> login(@RequestBody AuthRequest authRequest) {
//         //AuthenticationManager authenticationManager;
//         Authentication authentication = authenticationManager.authenticate(
//                 new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
//         if (authentication.isAuthenticated()) {
//             String jwt = jwtService.generateToken(authRequest.getUsername());
//             AppUser userInfo = appUserRepository.findByUsername(authRequest.getUsername()).get();
//             try{
//             if (userInfo.getEnabled( ))
//                 return ResponseEntity.status(HttpStatus.OK).body(new AuthResponse(jwt,
//                         AppUser.builder().username(userInfo.getUsername()).address(userInfo.getAddress())
//                                 .createdAt(userInfo.getCreatedAt()).updatedAt(userInfo.getUpdatedAt())
//                                 .email(userInfo.getEmail())
//                                 .enabled(userInfo.getEnabled()).firstName(userInfo.getFirstName())
//                                 .gender(userInfo.getGender()).lastName(userInfo.getLastName()).nni(userInfo.getNni())
//                                 .phoneNumber(userInfo.getPhoneNumber()).build()));
//             }catch(Exception e){
//                 return ResponseEntity.status(HttpStatus.LOCKED).body(Messages.VERIFICATION_MAIL_REQUIRED);
//             }
//             return ResponseEntity.status(HttpStatus.LOCKED).body(Messages.VERIFICATION_MAIL_REQUIRED);
//         }
//         return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
//     }

// }
