package harper.github.io;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class User {

    private Long id;

    private String userName;

    private String phone;

    private String email;

    private String password;

}
