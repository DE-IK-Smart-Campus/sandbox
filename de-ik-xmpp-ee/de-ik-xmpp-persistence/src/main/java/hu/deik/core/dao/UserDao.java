package hu.deik.core.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import hu.deik.core.entity.User;

@Component
public interface UserDao extends JpaRepository<User, Long> {

}
