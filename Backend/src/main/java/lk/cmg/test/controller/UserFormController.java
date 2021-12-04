package lk.cmg.test.controller;

import lk.cmg.test.dto.UserDTO;
import lk.cmg.test.dto.request.AuthRequest;
import lk.cmg.test.service.UserService;
import lk.cmg.test.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
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
    private UserService service;

    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/login")
    public String generateToken(@RequestBody AuthRequest authRequest) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUsername(),
                            authRequest.getPassword())
            );
        } catch (Exception ex) {
            throw new Exception("Invalid username/password");
        }
        return jwtUtil.generateToken(authRequest.getUsername());
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE,
            path ="/register" )
    public void registerUser(@RequestBody UserDTO dto ){
        service.registerUser(dto);
    }
}
