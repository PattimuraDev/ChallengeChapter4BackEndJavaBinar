package org.binar.challengechapter4cackendjava.services;

import org.binar.challengechapter4cackendjava.model.Films;
import org.binar.challengechapter4cackendjava.model.Schedules;
import org.binar.challengechapter4cackendjava.model.Seats;

import java.util.List;


public interface FilmsServices {
    Films addFilms(Films films);
    List<Films> getFilmIsPlaying();
    List<Schedules> schedulesOfFilmsByName(String filmName);

    Seats addSeats(Seats seats);
    void updateSeats(String newStatus, String nomorBarisKursi, String nomorKolomKursi);
    List<Seats> getAllSeatsAvailable();
}
