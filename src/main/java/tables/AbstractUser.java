package tables;

import io.requery.Column;
import io.requery.Entity;
import io.requery.Generated;
import io.requery.Table;

import javax.persistence.Id;

@Entity
@Table(name = "registerdUsers")
public class AbstractUser {

    @Id
    @Generated
    int id;

    @Column(nullable = false, unique = true)
    String username;

    @Column(nullable = false, unique = true)
    String email;
}
