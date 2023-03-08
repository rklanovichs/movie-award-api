package br.com.challenge.texoit.movieaward.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "movie")
public class MovieEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "producers")
    private String producers;

    @Column(name = "studios")
    private String studios;

    @Column(name = "title")
    private String title;

    @Column(name = "winner")
    private String winner;

    @Column(name = "`year`")
    private Integer year;

    public MovieEntity (Integer year, String title, String studios, String producers, String winner) {
        this.year = year;
        this.title = title;
        this.studios = studios;
        this.producers = producers;
        this.winner = winner;
    }

    @Override
    public String toString() {
        return "MovieEntity{" +
                "id=" + id +
                ", producers='" + producers + '\'' +
                ", studios='" + studios + '\'' +
                ", title='" + title + '\'' +
                ", winner=" + winner +
                ", year=" + year +
                '}';
    }
}
