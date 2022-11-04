package org.binar.ChallengeChapter4BackEndJava.repository;

import org.binar.ChallengeChapter4BackEndJava.model.Films;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

@ActiveProfiles("test")
@SpringBootTest
public class FilmsRepositoryTest {
    @Autowired
    FilmsRepository filmsRepository;

    /**
     * Fungsi pengecekan apakah fungsi repoGetFilmIsPlaying yang telah dibuat di
     * film repository menghasilkan return berupa list film yang sedang
     * tayang saat ini
     */
    @Test
    void getFilmsIsPlaying() {
        List<Films> result = filmsRepository.repoGetFilmIsPlaying();
        Assertions.assertNotNull(result);
    }
}
