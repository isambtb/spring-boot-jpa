package bb.he.example.h2noob.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Author: Issam BOUTAIB
 * On: 11.08.2019
 */

@Entity
@Table(name = "USER")
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Exclude
    private Long id;

    @Column(name = "LAST_NAME")
    private String lastname;

    @Column(name = "FIRST_NAME")
    private String firstname;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "USERNAME")
    private String username;

}
