package br.com.challenge.texoit.movieaward.dto;

import br.com.challenge.texoit.movieaward.enumeration.WinnerEnum;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/*public record MovieDTO (Long id, String producers, String studios, String title, Winner winner, Integer year) {
}*/

@Getter
@Setter
@Builder
public class MovieDTO {
    Long id;
    String producers;
    String studios;
    String title;
    WinnerEnum winnerEnum;
    Integer year;
}
