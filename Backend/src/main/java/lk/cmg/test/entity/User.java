package lk.cmg.test.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import java.util.HashSet;
import java.util.Set;

/**
 * @author Pramuda Liyanage <pramudatharika@gmail.com>
 * @since 12/2/21
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection="User")
public class User {
    @Id
    private String id;
    private String name;
    private String username;
    private String mobile_number;
    private String dob;
    private String gender;
    private String language;
    private String password;

}
