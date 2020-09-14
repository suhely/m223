package ch.zli.m223.punchclock.controller;

/**
 *
 * The User controller handles the sign up
 */

import ch.zli.m223.punchclock.domain.ApplicationUser;
import ch.zli.m223.punchclock.repository.ApplicationUserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private ApplicationUserRepository applicationUserRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    /**
     * The Constructor uses the following parameters:
     * @param applicationUserRepository
     * @param bCryptPasswordEncoder
     */
    public UserController(ApplicationUserRepository applicationUserRepository,
                          BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.applicationUserRepository = applicationUserRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    /**
     * The method "postSignUp" encodes the password the user has set.
     * It also saves it through the application user repository.
     * It uses the following parameter:
     * @param user
     */
    @PostMapping("/sign-up")
    public void postSignUp(@RequestBody ApplicationUser user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        applicationUserRepository.save(user);
    }

}
