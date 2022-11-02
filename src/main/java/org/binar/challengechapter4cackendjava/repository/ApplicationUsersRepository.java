package org.binar.challengechapter4cackendjava.repository;

import org.binar.challengechapter4cackendjava.model.ApplicationUsers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicationUsersRepository extends JpaRepository<ApplicationUsers, Long> {
}
