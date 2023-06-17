package com.taj.lookify.repositories;

import com.taj.lookify.models.Song;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SongRepository extends CrudRepository<Song, Long> {
  @NotNull
  List<Song> findAll();

  List<Song> findAllByTitleContainingIgnoreCase(String searchQuery);

  List<Song> findAllByArtistContainingIgnoreCase(String searchQuery);

  List<Song> findAllByRating(Integer searchQuery);

  List<Song> findAllByOrderByRatingDesc();
}