package harper.github.io.module.user;

import harper.github.io.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public class UserContext {

    public static User getUser() {
        Optional<Object> principal = Optional.ofNullable(SecurityContextHolder.getContext())
                .map(SecurityContext::getAuthentication).map(Authentication::getPrincipal);
        if (principal.isPresent()) {
            UserDetails userDetails = (UserDetails) principal.get();
            User user = new User()
                    .setUserName(userDetails.getUsername())
                    .setPassword(userDetails.getPassword());

            return user;
        }
        return null;
    }

}
