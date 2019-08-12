package bb.he.example.h2noob.repository;

import bb.he.example.h2noob.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;
import java.util.Optional;

/**
 * Author: Issam BOUTAIB
 * On: 11.08.2019
 */
public interface UserRepository extends PagingAndSortingRepository<User, Long> {
    //Example of some Dericed queries
    Optional<User> findByEmail(String email);
    Optional<User> findFirst5ByLastname(String lastname);
    Optional<User> findTop2ByFirstname(String firstname);
    List<User> findTop10ByFirstname(String firstname);
    List<User> findTop10ByFirstnameAndLastname(String firstname, String lastname);
    Optional<User>  findByUsernameOrEmail(String username, String Email);
    List<User> findByRoleUserRole(String userRole);
    Page<User> findAll(Pageable pageable);
}
