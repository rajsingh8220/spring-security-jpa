package io.singh.springsecurityjpa;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import io.singh.springsecurityjpa.models.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	
	Optional<User> findByEmail(String email);

}
