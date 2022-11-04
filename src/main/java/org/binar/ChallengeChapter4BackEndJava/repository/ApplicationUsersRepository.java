package org.binar.ChallengeChapter4BackEndJava.repository;

import org.binar.ChallengeChapter4BackEndJava.model.ApplicationUsers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicationUsersRepository extends JpaRepository<ApplicationUsers, Long> {
}
