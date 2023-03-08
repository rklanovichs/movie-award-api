package br.com.challenge.texoit.movieaward.service;

import br.com.challenge.texoit.movieaward.dto.MaxMovieWinnerAwardDTO;
import br.com.challenge.texoit.movieaward.dto.MinMovieWinnerAwardDTO;
import br.com.challenge.texoit.movieaward.dto.MovieWinnersDTO;
import br.com.challenge.texoit.movieaward.entity.MovieEntity;
import br.com.challenge.texoit.movieaward.exception.BusinessException;
import br.com.challenge.texoit.movieaward.helper.MessageHelper;
import br.com.challenge.texoit.movieaward.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static br.com.challenge.texoit.movieaward.enumeration.ErrorCodeEnum.ERROR_MOVIE_FIND;
import static br.com.challenge.texoit.movieaward.enumeration.ErrorCodeEnum.ERROR_MOVIE_SAVE;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@Slf4j
@Service
@RequiredArgsConstructor
public class MovieAwardService {

    private static final int MINIMAL_INTERVAL = 1;
    private final MessageHelper messageHelper;
    private final MovieRepository movieRepository;

    public MovieWinnersDTO findByWinnerAward() {
        try {
            List<MovieEntity> movieEntityList = movieRepository.findByWinnerOrderByProducersYear();
            return this.findMinMaxIntervalWinner(movieEntityList);
        } catch (Exception e) {
            log.error(messageHelper.get(ERROR_MOVIE_FIND, e));
            throw new BusinessException(INTERNAL_SERVER_ERROR, messageHelper.get(ERROR_MOVIE_FIND, e));
        }
    }

    private MovieWinnersDTO findMinMaxIntervalWinner(final List<MovieEntity> movieList) {
        List<MinMovieWinnerAwardDTO> min = new ArrayList<>();
        List<MaxMovieWinnerAwardDTO> max = new ArrayList<>();
        List<MovieEntity> filterMovieList = this.filterWinnerMovieList(movieList);
        Integer yearMax;
        Integer yearMin;
        for (int i = 0; i < filterMovieList.size(); i++) {
            for (MovieEntity movieEntity : filterMovieList) {
                if (movieEntity.getProducers().contains(filterMovieList.get(i).getProducers())
                        && !Objects.equals(movieEntity.getId(), filterMovieList.get(i).getId())) {
                    yearMin = this.getYearMin(filterMovieList.get(i).getYear(), movieEntity.getYear());
                    yearMax = this.getYearMax(filterMovieList.get(i).getYear(), movieEntity.getYear());
                    if (yearMax - yearMin == MINIMAL_INTERVAL) {
                        min.add(MinMovieWinnerAwardDTO.builder()
                            .interval(MINIMAL_INTERVAL)
                            .previousWin(yearMin)
                            .followingWin(yearMax)
                            .producer(filterMovieList.get(i).getProducers())
                            .build());
                    }
                    else {
                        max.add(MaxMovieWinnerAwardDTO.builder()
                            .interval(yearMax - yearMin)
                            .previousWin(yearMin)
                            .followingWin(yearMax)
                            .producer(filterMovieList.get(i).getProducers())
                            .build());
                    }
                }
            }
        }
        return MovieWinnersDTO.builder()
                .min(min)
                .max(max)
                .build();
    }

    private Integer getYearMin(final Integer yearMin, final Integer yearMax) {
        return yearMin.compareTo(yearMax) < 0 ? yearMin : yearMax;
    }

    private Integer getYearMax(final Integer yearMin, final Integer yearMax) {
        return yearMin.compareTo(yearMax) > 0 ? yearMin : yearMax;
    }

    private List<MovieEntity> filterWinnerMovieList(final List<MovieEntity> movieList) {
        List<MovieEntity> filterList = new ArrayList<>();
        for (int i = 0; i < movieList.size(); i++) {
            for (MovieEntity movieEntity : movieList) {
                if (movieEntity.getProducers().contains(movieList.get(i).getProducers())
                        && !Objects.equals(movieEntity.getId(), movieList.get(i).getId())) {
                    if (!filterList.contains(movieList.get(i))) {
                        filterList.add(movieList.get(i));
                    }
                    if (!filterList.contains(movieEntity)) {
                        filterList.add(movieEntity);
                    }
                }
            }
        }
        return filterList;
    }

    public List<MovieEntity> findAll() {
        try {
            return movieRepository.findAll();
        } catch (Exception e) {
            log.error(messageHelper.get(ERROR_MOVIE_FIND, e));
            throw new BusinessException(INTERNAL_SERVER_ERROR, messageHelper.get(ERROR_MOVIE_FIND, e));
        }
    }

    public MovieEntity save (final MovieEntity movieEntity) {
        try {
            return movieRepository.save(movieEntity);
        } catch (Exception e) {
            log.error(messageHelper.get(ERROR_MOVIE_SAVE, movieEntity.getTitle(), e));
            throw new BusinessException(INTERNAL_SERVER_ERROR, messageHelper.get(ERROR_MOVIE_SAVE, movieEntity.getTitle(), e));
        }
    }

}
