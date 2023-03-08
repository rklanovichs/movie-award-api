package br.com.challenge.texoit.movieaward.service;

import br.com.challenge.texoit.movieaward.entity.MovieEntity;
import br.com.challenge.texoit.movieaward.enumeration.WinnerEnum;
import br.com.challenge.texoit.movieaward.exception.BusinessException;
import br.com.challenge.texoit.movieaward.helper.MessageHelper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.event.ApplicationContextEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import static br.com.challenge.texoit.movieaward.enumeration.ErrorCodeEnum.ERROR_MOVIE_READ_FILE;
import static br.com.challenge.texoit.movieaward.enumeration.WinnerEnum.NO;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.util.ObjectUtils.isEmpty;

@Slf4j
@Service
@RequiredArgsConstructor
public class FileService {

    @Value("${api.movielist.filePath}")
    private String filePath;
    private static final int HEADER_LENGTH = 5;
    private final MessageHelper messageHelper;
    private final MovieAwardService movieAwardService;

    @EventListener(ApplicationContextEvent.class)
    public void fileReaderAndImport() {
        try (Stream<String> movieStream = Files.lines(Paths.get(this.filePath))) {
            movieStream
                .sequential()
                .skip(1)
                .map(line -> line.split(";"))
                .map(col-> new MovieEntity(getYear(col[0]), col[1], col[2], col[3], getWinner(col)))
                .forEach(this.movieAwardService::save);
        } catch (Exception e) {
            log.error(messageHelper.get(ERROR_MOVIE_READ_FILE, this.filePath, e));
            throw new BusinessException(INTERNAL_SERVER_ERROR, messageHelper.get(ERROR_MOVIE_READ_FILE, this.filePath, e));
        }
        this.movieAwardService.findAll().forEach(movieEntity -> log.info(movieEntity.toString()));
    }

    private Integer getYear(final String value) {
        return !isEmpty(value) ? Integer.parseInt(value) : 0;
    }

    private String getWinner(final String[] value) {
        if (value.length < HEADER_LENGTH) {
            return NO.getValue();
        }
        return WinnerEnum.valueOf(value[4].toUpperCase()).getValue();
    }

}
