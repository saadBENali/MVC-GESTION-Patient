package ma.emsi.jpaap.sec.repositories;

import ma.emsi.jpaap.sec.entities.AppRole;
import ma.emsi.jpaap.sec.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppRoleRepository extends JpaRepository<AppRole,Long> {
    AppRole findByRoleName(String roleName);
}
