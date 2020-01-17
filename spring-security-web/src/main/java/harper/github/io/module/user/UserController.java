package harper.github.io.module.user;

import harper.github.io.R;
import harper.github.io.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {

    @GetMapping("current_user")
    public R<User> findCurrentUser() {
        User user = UserContext.getUser();
        return R.ok(user);
    }
}
