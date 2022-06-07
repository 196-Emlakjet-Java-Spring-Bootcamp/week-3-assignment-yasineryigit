package com.ossovita.rabbitmqapp.core.dataAccess;

import com.ossovita.rabbitmqapp.core.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
