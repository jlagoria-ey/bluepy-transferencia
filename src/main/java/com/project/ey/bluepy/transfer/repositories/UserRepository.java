package com.project.ey.bluepy.transfer.repositories;

import com.project.ey.bluepy.transfer.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
    Optional<User> findUserByPersonaNumber(Long id_persona);
}
