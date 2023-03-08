package br.com.challenge.texoit.movieaward.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class MovieWinnersDTO {
    List<MaxMovieWinnerAwardDTO> max;
    List<MinMovieWinnerAwardDTO> min;
}
