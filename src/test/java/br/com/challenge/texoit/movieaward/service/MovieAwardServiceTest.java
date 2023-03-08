package br.com.challenge.texoit.movieaward.service;

import br.com.challenge.texoit.movieaward.dto.MovieDTO;
import br.com.challenge.texoit.movieaward.dto.MovieWinnersDTO;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureTestDatabase
class MovieAwardServiceTest {

    private static final int ZERO = 0;
    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    void shouldListMaxMinIntervalMovieAward() {
        MovieWinnersDTO movieWinnersDTO = testRestTemplate.exchange("/v1/movies", HttpMethod.GET, null,
                new ParameterizedTypeReference<MovieWinnersDTO>() {
                }).getBody();

        Assertions.assertThat(movieWinnersDTO).isNotNull();

        assertEquals("Joel Silver", movieWinnersDTO.getMin().get(ZERO).getProducer());
        assertEquals(1, movieWinnersDTO.getMin().get(ZERO).getInterval());
        assertEquals(1990, movieWinnersDTO.getMin().get(ZERO).getPreviousWin());
        assertEquals(1991, movieWinnersDTO.getMin().get(ZERO).getFollowingWin());
        assertEquals(1, movieWinnersDTO.getMin().size());

        assertEquals(13, movieWinnersDTO.getMax().get(ZERO).getInterval());
        assertEquals("Matthew Vaughn", movieWinnersDTO.getMax().get(ZERO).getProducer());
        assertEquals(2002, movieWinnersDTO.getMax().get(ZERO).getPreviousWin());
        assertEquals(2015, movieWinnersDTO.getMax().get(ZERO).getFollowingWin());
        assertEquals(1, movieWinnersDTO.getMax().size());

    }

    @Test
    void shouldListAllMoviesSaved() {
        List<MovieDTO> moviesList = testRestTemplate.exchange("/v1/movies/all", HttpMethod.GET, null,
                new ParameterizedTypeReference<List<MovieDTO>>() {
                }).getBody();

        Assertions.assertThat(moviesList).isNotNull();

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
}
