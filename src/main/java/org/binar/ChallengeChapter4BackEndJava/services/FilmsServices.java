package org.binar.ChallengeChapter4BackEndJava.services;

import org.binar.ChallengeChapter4BackEndJava.model.Films;
import org.binar.ChallengeChapter4BackEndJava.model.Schedules;
import org.binar.ChallengeChapter4BackEndJava.model.Seats;

import java.util.List;


public interface FilmsServices {
    Films addFilms(Films films);
    List<Films> getFilmIsPlaying();
    List<Schedules> schedulesOfFilmsByName(String filmName);

    Seats addSeats(Seats seats);
    void updateSeats(String newStatus, String nomorBarisKursi, String nomorKolomKursi);
    List<Seats> getAllSeatsAvailable();
}
