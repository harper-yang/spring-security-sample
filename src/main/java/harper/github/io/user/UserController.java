package harper.github.io.user;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RequestMapping("/user")
@RestController
public class UserController {


    @Resource
    private ObjectMapper objectMapper;

    @GetMapping
    public String getCurrentUser() throws JsonProcessingException {

        SecurityContext context = SecurityContextHolder.getContext();

        Object principal = context.getAuthentication().getPrincipal();
        String username;
        if (principal instanceof UserDetails) {
            username = ((UserDetails)principal).getUsername();
        } else {
            username = principal.toString();
        }

        return objectMapper.writeValueAsString(username);
    }

}
