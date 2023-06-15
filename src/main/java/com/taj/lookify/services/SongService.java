package com.taj.lookify.services;

import com.taj.lookify.repositories.SongRepository;
import org.springframework.stereotype.Service;

@Service
public class SongService {
  private final SongRepository songRepository;

  public SongService(SongRepository songRepository) {
    this.songRepository = songRepository;
  }
}