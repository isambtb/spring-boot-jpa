package bb.he.example.h2noob.repository;

import bb.he.example.h2noob.domain.PossibleRoles;
import bb.he.example.h2noob.domain.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface  RoleRepository extends CrudRepository<Role, Long> {
    boolean existsByUserRole(PossibleRoles possibleRole);
    Role findByUserRole(PossibleRoles possibleRole);
}
