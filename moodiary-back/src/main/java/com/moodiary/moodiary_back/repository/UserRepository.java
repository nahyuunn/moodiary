package com.moodiary.moodiary_back.repository;

import com.moodiary.moodiary_back.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    boolean existsByUserEmail(String userEmail);
    User findByUserEmail(String userEmail);

}
