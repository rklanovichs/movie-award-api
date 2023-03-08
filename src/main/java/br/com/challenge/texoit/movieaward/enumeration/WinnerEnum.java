package br.com.challenge.texoit.movieaward.enumeration;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum WinnerEnum {
    YES ("yes"),
    NO ("no");

    private final String value;
}
