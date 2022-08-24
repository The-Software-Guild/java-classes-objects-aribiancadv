package com.sg.dvdlibrary.dto;

public class Dvd {

    private String title;
    private String releaseDate;
    private String MPAARating;

    private String directorName;
    private String studioName;
    private String note;

    public void setMPAARating(String MPAARating) {
        this.MPAARating = MPAARating;
    }

    public void setStudioName(String studioName) {
        this.studioName = studioName;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getStudioName() {
        return studioName;
    }

    public String getNote() {
        return note;
    }

    public Dvd(String MPAARating) {
        this.MPAARating = MPAARating;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getMPAARating() {
        return MPAARating;
    }

    public String getDirectorName() {
        return directorName;
    }

    public void setDirectorName(String directorName) {
        this.directorName = directorName;
    }
    
}
