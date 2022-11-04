package org.binar.ChallengeChapter4BackEndJava.repository;

import org.binar.ChallengeChapter4BackEndJava.model.Schedules;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SchedulesRepository extends JpaRepository<Schedules, Long> {
}
