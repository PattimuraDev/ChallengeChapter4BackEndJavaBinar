package org.binar.challengechapter4cackendjava.repository;

import org.binar.challengechapter4cackendjava.model.SeatNumberCompositeKey;
import org.binar.challengechapter4cackendjava.model.Seats;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeatsRepository extends JpaRepository<Seats, SeatNumberCompositeKey> {
    @Query(value = "select * from seats where status = 'available'", nativeQuery = true)
    List<Seats> repoGetAllSeatsAvailable();

    @Query(value = "update seats set status = :status where nomor_baris_kursi = :nomor_baris_kursi and nomor_kolom_kursi = :nomor_kolom_kursi", nativeQuery = true)
    @Modifying
    void repoUpdateSeats(
            @Param("status") String newStatus,
            @Param("nomor_baris_kursi") String nomorBarisKursi,
            @Param("nomor_kolom_kursi") String NomorKolomKursi
    );
}
