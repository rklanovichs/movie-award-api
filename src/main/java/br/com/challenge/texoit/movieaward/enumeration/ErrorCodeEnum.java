package br.com.challenge.texoit.movieaward.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCodeEnum {

    ERROR_MOVIE_SAVE("error.movie.save"),
    ERROR_MOVIE_NOT_FOUND("error.movie.not.found"),
    ERROR_MOVIE_FIND("error.movie.find"),
    ERROR_MOVIE_DELETE("error.movie.delete"),
    ERROR_MOVIE_READ_FILE("error.movie.read.file"),
    INFO_MOVIE_IMPORTING_FILE("info.movie.importing.file"),
    INFO_MOVIE_IMPORTING_FILE_SUCCESS("info.movie.importing.file.success"),
    INFO_SHOWING_SAVED_DATA("info.showing.saved.data");

    private final String messageKey;
}
