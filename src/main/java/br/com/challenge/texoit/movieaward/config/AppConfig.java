package br.com.challenge.texoit.movieaward.config;

import br.com.challenge.texoit.movieaward.helper.MessageHelper;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.format.Formatter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Locale;

import static java.time.format.DateTimeFormatter.ISO_DATE;
import static java.time.format.DateTimeFormatter.ISO_DATE_TIME;

@Configuration
public class AppConfig {

    @Bean
    MessageSource messageSource() {
        ReloadableResourceBundleMessageSource source = new ReloadableResourceBundleMessageSource();
        source.setBasenames("classpath:i18n/messages");
        source.setCacheSeconds(3600);
        source.setDefaultEncoding("UTF-8");
        return source;
    }

    @Bean
    public MessageHelper messageHelper(MessageSource messageSource) {
        return new MessageHelper(messageSource);
    }

    @Bean
    Formatter<LocalDate> localDateFormatter() {
        return new Formatter<>() {
            @Override
            public LocalDate parse(String text, Locale locale) {
                return LocalDate.parse(text, ISO_DATE);
            }

            @Override
            public String print(LocalDate object, Locale locale) {
                return ISO_DATE.format(object);
            }
        };
    }

    @Bean
    Formatter<LocalDateTime> localDateTimeFormatter() {
        return new Formatter<>() {
            @Override
            public LocalDateTime parse(String text, Locale locale) {
                return LocalDateTime.parse(text, ISO_DATE_TIME);
            }

            @Override
            public String print(LocalDateTime object, Locale locale) {
                return ISO_DATE_TIME.format(object);
            }
        };
    }
}
