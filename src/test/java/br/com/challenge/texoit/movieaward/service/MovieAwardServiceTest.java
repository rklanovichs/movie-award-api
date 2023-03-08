package br.com.challenge.texoit.movieaward.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class MovieAwardServiceTest {

    @Autowired
    private MovieAwardService movieAwardService;

    @Test
    void shouldFindAllMovies() {
        final var moviesList = this.movieAwardService.findAll();

        assertEquals("Allan Carr", moviesList.get(0).getProducers());
        assertEquals("Jerry Weintraub", moviesList.get(1).getProducers());
        assertEquals("Steve Shagan", moviesList.get(2).getProducers());
        assertEquals("Sean S. Cunningham", moviesList.get(3).getProducers());
        assertEquals("Jennings Lang", moviesList.get(4).getProducers());
        assertEquals("Jerry Leider", moviesList.get(5).getProducers());
        assertEquals("William Frye", moviesList.get(6).getProducers());
        assertEquals("Stanley Donen", moviesList.get(7).getProducers());
        assertEquals("Mike Lobell", moviesList.get(8).getProducers());
        assertEquals("Lawrence Gordon", moviesList.get(9).getProducers());
        assertEquals("Frank Yablans", moviesList.get(10).getProducers());
        assertEquals("Dyson Lovell", moviesList.get(11).getProducers());
        assertEquals("Joann Carelli", moviesList.get(12).getProducers());
        assertEquals("Walter Coblenz", moviesList.get(13).getProducers());
        assertEquals("John Derek", moviesList.get(14).getProducers());
        assertEquals("Mitsuharu Ishii", moviesList.get(15).getProducers());
        assertEquals("Ray Stark", moviesList.get(16).getProducers());
        assertEquals("Matt Cimber", moviesList.get(17).getProducers());
        assertEquals("Albert S. Ruddy", moviesList.get(18).getProducers());
        assertEquals("David Joseph", moviesList.get(19).getProducers());
        assertEquals("Robert R. Weston", moviesList.get(20).getProducers());
        assertEquals(206, moviesList.size());
    }

    @Test
    void shouldFindMaxMinIntervalMovieAward() {
        final var minMaxWinnerAward = this.movieAwardService.findByWinnerAward();

        assertEquals("Joel Silver", minMaxWinnerAward.getMin().get(0).getProducer());
        assertEquals(1, minMaxWinnerAward.getMin().get(0).getInterval());
        assertEquals(1990, minMaxWinnerAward.getMin().get(0).getPreviousWin());
        assertEquals(1991, minMaxWinnerAward.getMin().get(0).getFollowingWin());
        assertEquals(1, minMaxWinnerAward.getMin().size());

        assertEquals(6, minMaxWinnerAward.getMax().get(0).getInterval());
        assertEquals("Bo Derek", minMaxWinnerAward.getMax().get(0).getProducer());
        assertEquals(1984, minMaxWinnerAward.getMax().get(0).getPreviousWin());
        assertEquals(1990, minMaxWinnerAward.getMax().get(0).getFollowingWin());
        assertEquals(3, minMaxWinnerAward.getMax().size());

        assertEquals(9, minMaxWinnerAward.getMax().get(1).getInterval());
        assertEquals("Buzz Feitshans", minMaxWinnerAward.getMax().get(1).getProducer());
        assertEquals(1985, minMaxWinnerAward.getMax().get(1).getPreviousWin());
        assertEquals(1994, minMaxWinnerAward.getMax().get(1).getFollowingWin());
        assertEquals(3, minMaxWinnerAward.getMax().size());

        assertEquals(13, minMaxWinnerAward.getMax().get(2).getInterval());
        assertEquals("Matthew Vaughn", minMaxWinnerAward.getMax().get(2).getProducer());
        assertEquals(2002, minMaxWinnerAward.getMax().get(2).getPreviousWin());
        assertEquals(2015, minMaxWinnerAward.getMax().get(2).getFollowingWin());
        assertEquals(3, minMaxWinnerAward.getMax().size());
    }
}
