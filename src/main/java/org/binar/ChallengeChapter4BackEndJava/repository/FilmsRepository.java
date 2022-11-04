package org.binar.ChallengeChapter4BackEndJava.repository;

import org.binar.ChallengeChapter4BackEndJava.model.Films;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FilmsRepository extends JpaRepository<Films, Long> {
    @Query(value = "select * from GET_ALL_FILMS_IS_PLAYING()", nativeQuery = true)
    List<Films> repoGetFilmIsPlaying();
}
