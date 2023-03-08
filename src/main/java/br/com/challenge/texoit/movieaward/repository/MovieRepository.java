package br.com.challenge.texoit.movieaward.repository;

import br.com.challenge.texoit.movieaward.entity.MovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MovieRepository extends JpaRepository<MovieEntity, Long> {

    List<MovieEntity> findAll();
    @Query(value = "SELECT m FROM MovieEntity m WHERE m.winner = 'yes' ORDER BY m.producers, m.year")
    List<MovieEntity> findByWinnerOrderByProducersYear();

}
