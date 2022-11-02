package org.binar.challengechapter4cackendjava.repository;

import org.binar.challengechapter4cackendjava.model.Schedules;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SchedulesRepository extends JpaRepository<Schedules, Long> {
}
