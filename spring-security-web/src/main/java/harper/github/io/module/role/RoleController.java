package harper.github.io.module.role;

import harper.github.io.R;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("role")
@RestController
public class RoleController {

    @GetMapping("current_role")
    public R<String> findCurrentUser() {
        return R.ok("leader");
    }
}
