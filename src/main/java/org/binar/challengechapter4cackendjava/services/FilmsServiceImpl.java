package org.binar.challengechapter4cackendjava.services;

import org.binar.challengechapter4cackendjava.model.Films;
import org.binar.challengechapter4cackendjava.model.Schedules;
import org.binar.challengechapter4cackendjava.model.Seats;
import org.binar.challengechapter4cackendjava.repository.FilmsRepository;
import org.binar.challengechapter4cackendjava.repository.SchedulesRepository;
import org.binar.challengechapter4cackendjava.repository.SeatsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@Transactional
public class FilmsServiceImpl implements FilmsServices{
    @Autowired
    FilmsRepository filmsRepository;

    @Autowired
    SeatsRepository seatsRepository;

    @Autowired
    SchedulesRepository schedulesRepository;

    @Override
    public Films addFilms(Films films) {
        return filmsRepository.save(films);
    }

    @Override
    public List<Films> getFilmIsPlaying() {
        return filmsRepository.repoGetFilmIsPlaying();
    }

    @Override
    public List<Schedules> schedulesOfFilmsByName(String filmName) {
        List<Films> listOfAllFilms = filmsRepository.findAll();
        Long filmCode = 0L;
        for(Films films : listOfAllFilms){
            if(Objects.equals(films.getFilmName(), filmName)){
                filmCode = films.getFilmCode();
            }
        }
        List<Schedules> listOfAllSchedules = schedulesRepository.findAll();
        List<Schedules> result = new ArrayList<>();
        for(Schedules schedules : listOfAllSchedules){
            if(Objects.equals(schedules.getFilmsCode(), filmCode)){
                result.add(schedules);
            }
        }

        return result;
    }

    @Override
    public Seats addSeats(Seats seats) {
        return seatsRepository.save(seats);
    }

    @Override
    public void updateSeats(String newStatus, String nomorBarisKursi, String nomorKolomKursi) {
        seatsRepository.repoUpdateSeats(newStatus, nomorBarisKursi, nomorKolomKursi);
    }
    @Override
    public List<Seats> getAllSeatsAvailable() {
        return seatsRepository.repoGetAllSeatsAvailable();
    }
}
