package com.taj.lookify.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;


@Entity
@Table(name = "songs")
public class Song {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank(message = "Please provide the title of the song")
  private String title;

  @NotBlank(message = "Please provide the song's artist")
  private String artist;

  @NotNull(message = "Please provide a rating for the song (1-10)")
  @Min(value = 1, message = "Please provide a rating for the song (1-10)")
  @Max(value = 10, message = "Please provide a rating for the song (1-10)")
  private Integer rating;

  @Column(updatable = false)
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date createdAt;

  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date updatedAt;

  public Song() {
  }

  public Song(String title, String artist, @NotNull Integer rating) {
    this.title = title;
    this.artist = artist;
    this.rating = rating;
  }

  @PrePersist
  protected void onCreate() {
    this.createdAt = new Date();
  }

  @PreUpdate
  protected void onUpdate() {
    this.updatedAt = new Date();
  }

  // *** GETTERS AND SETTERS ***

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getArtist() {
    return artist;
  }

  public void setArtist(String artist) {
    this.artist = artist;
  }

  public @NotNull Integer getRating() {
    return rating;
  }

  public void setRating(@NotNull Integer rating) {
    this.rating = rating;
  }

  public Date getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(Date createdAt) {
    this.createdAt = createdAt;
  }

  public Date getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(Date updatedAt) {
    this.updatedAt = updatedAt;
  }
}