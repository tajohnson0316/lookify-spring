package com.taj.lookify.services;

import com.taj.lookify.models.Song;
import com.taj.lookify.repositories.SongRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SongService {
  private final SongRepository songRepository;

  public SongService(SongRepository songRepository) {
    this.songRepository = songRepository;
  }

  public List<Song> allSongs() {
    return this.songRepository.findAll();
  }

  public Song getSongById(Long id) {
    Optional<Song> newSong = this.songRepository.findById(id);

    return newSong.orElse(null);
  }

  public Song createSong(Song song) {
    return this.songRepository.save(song);
  }

  public Song updateSong(Song song) {
    Song updatedSong = getSongById(song.getId());

    updatedSong.setTitle(song.getTitle());
    updatedSong.setArtist(song.getArtist());
    updatedSong.setRating(song.getRating());

    return songRepository.save(updatedSong);
  }

  public void deleteSong(Long id) {
    songRepository.delete(getSongById(id));
  }

  public List<Song> searchSongs(String searchQuery) {
    List<Song> byTitles = this.songRepository.findAllByTitleContainingIgnoreCase(searchQuery);
    List<Song> byArtist = this.songRepository.findAllByArtistContainingIgnoreCase(searchQuery);

    List<Song> allSongs = new ArrayList<>(byTitles);
    for (Song song : byArtist) {
      if (!allSongs.contains(song)) {
        allSongs.add(song);
      }
    }

    try {
      List<Song> byRating = this.songRepository.findAllByRating(Integer.parseInt(searchQuery));
      for (Song song : byRating) {
        if (!allSongs.contains(song)) {
          allSongs.add(song);
        }
      }
    } catch (NumberFormatException ignored) {
    }

    return allSongs;
  }

  public List<Song> getTop10() {
    List<Song> allSongsByRating = this.songRepository.findAllByOrderByRatingDesc();
    List<Song> top10 = new ArrayList<>();

    int i = 0;
    while (i < 10 && i < allSongsByRating.size()) {
      top10.add(allSongsByRating.get(i));
      i++;
    }

    return top10;
  }
}