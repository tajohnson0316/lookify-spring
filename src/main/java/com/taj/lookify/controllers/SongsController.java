package com.taj.lookify.controllers;

import com.taj.lookify.models.Song;
import com.taj.lookify.services.SongService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

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

  @GetMapping("/dashboard")
  public String dashboard(Model model) {
    model.addAttribute("listingTitle", "All Songs");
    model.addAttribute("allSongs", songService.allSongs());
    return "dashboard.jsp";
  }

  @RequestMapping("/dashboard/search")
  public String searchDashboard(
    @RequestParam(value = "q") String searchQuery,
    Model model
  ) {
    if (searchQuery.equals("")) {
      return "redirect:/dashboard";
    }
    model.addAttribute("listingTitle", "Search Results");
    model.addAttribute("q", searchQuery);
    model.addAttribute("allSongs", songService.searchSongs(searchQuery));
    return "dashboard.jsp";
  }

  @GetMapping("dashboard/top10")
  public String dashboardTop10(Model model) {
    model.addAttribute("listingTitle", "Top 10");
    model.addAttribute("allSongs", songService.getTop10());
    return "dashboard.jsp";
  }

  @GetMapping("/songs/new")
  public String displayNewSongForm(@ModelAttribute("song") Song song) {
    return "newSongForm.jsp";
  }

  @PostMapping("/songs/new/create")
  public String createNewSong(
    @Valid @ModelAttribute("song") Song song,
    BindingResult result,
    Model model
  ) {
    if (result.hasErrors()) {
      model.addAttribute("song", song);
      return "newSongForm.jsp";
    }

    Song newSong = songService.createSong(song);
    return "redirect:/dashboard";
  }

  @GetMapping("/songs/{id}")
  public String displaySongById(@PathVariable("id") Long id, HttpSession session) {
    session.setAttribute("song", songService.getSongById(id));

    return "displaySong.jsp";
  }

  @GetMapping("/songs/edit/{id}")
  public String displayEditSongForm(@PathVariable("id") Long id, Model model) {
    model.addAttribute("song", songService.getSongById(id));
    return "editSongForm.jsp";
  }

  @PutMapping("/songs/update/{id}")
  public String updateSong(
    @Valid @ModelAttribute("song") Song song,
    BindingResult result,
    Model model
  ) {
    if (result.hasErrors()) {
      model.addAttribute("song", song);
      return "editSongForm.jsp";
    }

    songService.updateSong(song);
    return String.format("redirect:/songs/%d", song.getId());
  }

  @DeleteMapping("/songs/delete/{id}")
  public String deleteSong(@PathVariable("id") Long id) {
    songService.deleteSong(id);
    return "redirect:/dashboard";
  }
}