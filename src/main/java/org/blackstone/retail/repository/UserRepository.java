package org.blackstone.retail.repository;

import org.blackstone.retail.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
