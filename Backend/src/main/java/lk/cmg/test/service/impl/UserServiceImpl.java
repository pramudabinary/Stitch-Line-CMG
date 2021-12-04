package lk.cmg.test.service.impl;

import lk.cmg.test.entity.User;
import lk.cmg.test.repo.UserRepo;
import lk.cmg.test.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Pramuda Liyanage <pramudatharika@gmail.com>
 * @since 12/4/21
 **/

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo repo;

    @Autowired
    private ModelMapper mapper;

    @Override
    public void registerUser(User user) {
        repo.save(user);
    }
}
