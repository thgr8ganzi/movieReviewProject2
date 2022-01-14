package com.example.bimmovie.repository;

import com.example.bimmovie.entity.Movie;
import com.example.bimmovie.entity.Poster;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.IntStream;

@SpringBootTest
@Log4j2
public class MovieRepositoryTest {

    @Autowired
    private MovieRepository movieRepository;

    @Test
    public void testInsert(){
        log.info("testInsert...............");

        Movie movie = Movie.builder().title("극한직업").build();

        movie.addPoster(Poster.builder().fname("극한직업포스터1.jpg").build());
        movie.addPoster(Poster.builder().fname("극한직업포스터2.jpg").build());

        movieRepository.save(movie);

        log.info(movie.getMno());
    }

    @Test
    @Transactional
    @Commit
    public void testAddPoster(){

        Movie movie = movieRepository.getOne(1L);
        movie.addPoster(Poster.builder().fname("극한직업포스터3.jpg").build());

        movieRepository.save(movie);
    }

    @Test
    @Transactional
    @Commit
    public void testRemovePoster(){
        Movie movie = movieRepository.getOne(1L);

        movie.removePoster(2L);

        movieRepository.save(movie);
    }

    @Test
    public void inserMovies(){

        IntStream.rangeClosed(10,100).forEach(i ->{
            Movie movie = Movie.builder().title("세계명작" + i).build();

            movie.addPoster(Poster.builder().fname("세계명작"+i+"포스터1.jpg").build());
            movie.addPoster(Poster.builder().fname("세계명작"+i+"포스터2.jpg").build());

            movieRepository.save(movie);
        });
    }


}













