package com.spring.hexagonal.hexagonal.infraestructure;

import com.spring.hexagonal.hexagonal.domain.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByNumberDocument(Integer numberDocument);
    boolean existsByNumberDocument(Integer numberDocument);

}
