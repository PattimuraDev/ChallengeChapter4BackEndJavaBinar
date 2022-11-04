package org.binar.ChallengeChapter4BackEndJava.repository;

import org.binar.ChallengeChapter4BackEndJava.model.Seats;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

@ActiveProfiles("test")
@SpringBootTest
public class SeatsRepositoryTest {
    @Autowired
    SeatsRepository seatsRepository;

    /**
     * Fungsi pengecekan apakah fungsi repoGetAllSeatsAvailable yang telah
     * dibuat di seats repository menghasilkan return berupa list seats yang
     * masih tersedia (belum dipesan/available)
     */
    @Test
    void repoGetAllSeatsAvailable() {
        List<Seats> result = seatsRepository.repoGetAllSeatsAvailable();
        Assertions.assertNotNull(result);
    }
}
