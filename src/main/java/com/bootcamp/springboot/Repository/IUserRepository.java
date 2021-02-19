package com.bootcamp.springboot.Repository;

import com.bootcamp.springboot.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);

    @Modifying(flushAutomatically = true)
    @Query("update User u set u.firstName = :firstName, u.lastName = :lastName, u.isActive = :isActive where u.id = :id")
    void updateUser(@Param(value = "id") long id, @Param(value = "firstName") String firstName, @Param(value = "lastName") String lastName, @Param(value = "isActive") boolean isActive);
}
