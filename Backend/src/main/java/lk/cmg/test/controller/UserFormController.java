package lk.cmg.test.controller;

<<<<<<< HEAD
import lk.cmg.test.entity.request.AuthRequest;
import lk.cmg.test.util.JwtUtil;
=======
import lk.cmg.test.entity.request.LoginRequest;
import lk.cmg.test.entity.response.JwtResponse;
import lk.cmg.test.repo.RoleRepository;
import lk.cmg.test.repo.UserRepo;
import lk.cmg.test.security.jwt.JwtUtils;
import lk.cmg.test.security.services.UserDetailsImpl;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
>>>>>>> 3d58af680dd27915282d0c1e572e0136c3da9286
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
<<<<<<< HEAD
=======
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
>>>>>>> 3d58af680dd27915282d0c1e572e0136c3da9286
import org.springframework.web.bind.annotation.*;

/**
 * @author Pramuda Liyanage <pramudatharika@gmail.com>
 * @since 12/2/21
 **/

@RestController
@RequestMapping("/api/v1/service")
@CrossOrigin
public class UserFormController {
    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
<<<<<<< HEAD
    private AuthenticationManager authenticationManager;

    @PostMapping("/authenticate")
    public String generateToken(@RequestBody AuthRequest authRequest) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUser_name(),
                            authRequest.getPassword())
            );
        } catch (Exception ex) {
            throw new Exception("Invalid username/password");
=======
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtUtils jwtUtils;

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUser_name(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());

        return ResponseEntity.ok(new JwtResponse(jwt,
                userDetails.getUsername(),
                userDetails.getPassword(),
                roles));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
        if (userRepository.existsByUsername(signUpRequest.getUsername())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Username is already taken!"));
        }

        if (userRepository.existsByEmail(signUpRequest.getEmail())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Email is already in use!"));
>>>>>>> 3d58af680dd27915282d0c1e572e0136c3da9286
        }
        return jwtUtil.generateToken(authRequest.getUser_name());
    }
}
