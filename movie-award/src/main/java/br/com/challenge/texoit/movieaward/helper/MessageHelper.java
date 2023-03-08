package br.com.challenge.texoit.movieaward.helper;

import br.com.challenge.texoit.movieaward.enumeration.ErrorCodeEnum;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.support.MessageSourceAccessor;

import java.util.Locale;

@RequiredArgsConstructor
public class MessageHelper {

    private final MessageSource messageSource;

    private MessageSourceAccessor accessor;

    @PostConstruct
    public void init() {
        accessor = new MessageSourceAccessor( messageSource, Locale.getDefault() );
    }

    public String get(ErrorCodeEnum code, Object ... args) {
        return accessor.getMessage(code.getMessageKey(), args);
    }
}
