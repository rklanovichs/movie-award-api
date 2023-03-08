package br.com.challenge.texoit.movieaward.resource.v1;

import br.com.challenge.texoit.movieaward.dto.MovieWinnersDTO;
import br.com.challenge.texoit.movieaward.entity.MovieEntity;
import br.com.challenge.texoit.movieaward.service.MovieAwardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@Slf4j
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/movies")
public class MoviesAwardResource {
    private final MovieAwardService movieAwardService;

    @GetMapping()
    @ResponseStatus(OK)
    public MovieWinnersDTO findByWinnerAward() {
        return movieAwardService.findByWinnerAward();
    }

    @GetMapping("/all")
    @ResponseStatus(OK)
    public List<MovieEntity> findAll() {
        return movieAwardService.findAll();
    }
}
