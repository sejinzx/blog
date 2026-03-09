package com.sejin.blog.repository;

import com.sejin.blog.domain.UserDomain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserDomain, Long> {
    Optional<UserDomain> findByUserId(String userId);
}
