package com.taj.lookify.controllers;

import com.taj.lookify.services.SongService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SongsController {
  private final SongService songService;

  public SongsController(SongService songService) {
    this.songService = songService;
  }

  @GetMapping("/")
  public String index() {
    return "index.jsp";
  }
}