package lk.cmg.test.entity.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Pramuda Liyanage <pramudatharika@gmail.com>
 * @since 12/4/21
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthRequest {
    private String user_name;
    private String password;
}
