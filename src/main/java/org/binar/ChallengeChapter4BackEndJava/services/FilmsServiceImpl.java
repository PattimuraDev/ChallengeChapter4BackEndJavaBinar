package org.binar.ChallengeChapter4BackEndJava.services;

import org.binar.ChallengeChapter4BackEndJava.model.Films;
import org.binar.ChallengeChapter4BackEndJava.model.Schedules;
import org.binar.ChallengeChapter4BackEndJava.model.Seats;
import org.binar.ChallengeChapter4BackEndJava.repository.FilmsRepository;
import org.binar.ChallengeChapter4BackEndJava.repository.SchedulesRepository;
import org.binar.ChallengeChapter4BackEndJava.repository.SeatsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@Transactional
public class FilmsServiceImpl implements FilmsServices {
    @Autowired
    FilmsRepository filmsRepository;

    @Autowired
    SeatsRepository seatsRepository;

    @Autowired
    SchedulesRepository schedulesRepository;

    /**
     * Fungsi yang digunakan untuk add film
     *
     * @param films paramater objeck film
     * @return film hasil save
     */
    @Override
    public Films addFilms(Films films) {
        return filmsRepository.save(films);
    }

    /**
     * Fungsi untuk get semua film dengan status tayang saat ini
     *
     * @return semua film yang sedang tayang (list)
     */
    @Override
    public List<Films> getFilmIsPlaying() {
        return filmsRepository.repoGetFilmIsPlaying();
    }

    /**
     * Get semua jadwal tersedia untuk film dengan judul tertentu
     *
     * @param filmName parameter nama film
     * @return list schedule film terkait
     */
    @Override
    public List<Schedules> schedulesOfFilmsByName(String filmName) {
        List<Films> listOfAllFilms = filmsRepository.findAll();
        Long filmCode = 0L;
        for (Films films : listOfAllFilms) {
            if (Objects.equals(films.getFilmName(), filmName)) {
                filmCode = films.getFilmCode();
            }
        }
        List<Schedules> listOfAllSchedules = schedulesRepository.findAll();
        List<Schedules> result = new ArrayList<>();
        for (Schedules schedules : listOfAllSchedules) {
            if (Objects.equals(schedules.getFilmsCode(), filmCode)) {
                result.add(schedules);
            }
        }

        return result;
    }

    /**
     * Fungsi menambah seats
     *
     * @param seats object seats yang ingin ditambahkan
     * @return seats hasil penambahan
     */
    @Override
    public Seats addSeats(Seats seats) {
        return seatsRepository.save(seats);
    }

    /**
     * Fungsi untuk mengupdate status kursi, apakah sudah dipesan atau belum
     *
     * @param newStatus       parameter untuk mengubah status seats
     * @param nomorBarisKursi parameter nomor baris dari kursi/seats
     * @param nomorKolomKursi parameter nomor kolom dari kursi/seats
     */
    @Override
    public void updateSeats(String newStatus, String nomorBarisKursi, String nomorKolomKursi) {
        seatsRepository.repoUpdateSeats(newStatus, nomorBarisKursi, nomorKolomKursi);
    }

    /**
     * Fungsi untuk mengambil semua seats dengan status tersedia/belum dipesan
     *
     * @return list seats dengan status tersedia
     */
    @Override
    public List<Seats> getAllSeatsAvailable() {
        return seatsRepository.repoGetAllSeatsAvailable();
    }
}
