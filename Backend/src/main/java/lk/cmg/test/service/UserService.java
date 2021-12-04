package lk.cmg.test.service;

import lk.cmg.test.dto.UserDTO;
import lk.cmg.test.entity.User;

/**
 * @author Pramuda Liyanage <pramudatharika@gmail.com>
 * @since 12/4/21
 **/

public interface UserService {
    void registerUser(UserDTO dto);
}
