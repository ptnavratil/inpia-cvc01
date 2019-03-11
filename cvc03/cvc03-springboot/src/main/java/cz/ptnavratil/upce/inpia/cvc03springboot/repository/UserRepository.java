package cz.ptnavratil.upce.inpia.cvc03springboot.repository;

import cz.ptnavratil.upce.inpia.cvc03springboot.dao.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

}
