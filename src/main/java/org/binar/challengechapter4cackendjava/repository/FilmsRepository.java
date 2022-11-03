package org.binar.challengechapter4cackendjava.repository;

import org.binar.challengechapter4cackendjava.model.Films;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FilmsRepository extends JpaRepository<Films, Long> {
    @Query(value = "select * from films where is_playing = true", nativeQuery = true)
    List<Films> repoGetFilmIsPlaying();
}
