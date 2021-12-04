package lk.cmg.test.repo;

import lk.cmg.test.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * @author Pramuda Liyanage <pramudatharika@gmail.com>
 * @since 12/2/21
 **/

@EnableMongoRepositories
public interface UserRepo extends MongoRepository<User,String> {
    User findByUsername(String username);
}

