package br.com.challenge.texoit.movieaward.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class MaxMovieWinnerAwardDTO {
    String producer;
    Integer interval;
    Integer previousWin;
    Integer followingWin;

}
