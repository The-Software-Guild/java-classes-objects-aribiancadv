package com.sg.dvdlibrary.ui;

import com.sg.dvdlibrary.dto.Dvd;

import java.util.List;

public class DvdLibraryView {

    private UserIO io;

    public DvdLibraryView(UserIO io) {
        this.io = io;
    }

    public int printMenuAndGetSelection() {
        io.print("Main Menu");
        io.print("1. List  all DVDs");
        io.print("2. Create New DVD");
        io.print("3. View a DVD's information");
        io.print("4. Remove a DVD");
        io.print("5. Edit a DVD's information");
        io.print("6. Search DVD by title");
        io.print("7. Load DVD Library from file");
        io.print("8. Exit");

        return io.readInt("Please select from the above choices.", 1, 8);
    }

    public Dvd getNewDvdInfo() {
        String title = io.readString("Please enter DVD Title");
        String releaseDate = io.readString("Please enter Release Date");
        String MPAARating = io.readString("Please enter MPAA Rating");
        String directorName = io.readString("Please enter the director's name.");
        String studioName = io.readString("Please enter the name of the studio.");
        String note = io.readString("Please add a rating or note.");
        Dvd currentDvd = new Dvd(title);
        currentDvd.setTitle(releaseDate);
        currentDvd.setReleaseDate(MPAARating);
        currentDvd.setDirectorName(directorName);
        currentDvd.setStudioName(studioName);
        currentDvd.setNote(note);
        return currentDvd;
    }

    public void displayCreateDvdBanner() {
        io.print("=== Create Dvd ===");
    }

    public void displayCreateSuccessBanner() {
        io.readString(
                "Dvd successfully created.  Please hit enter to continue");
    }

    public void displayDvdList(List<Dvd> dvdList) {
        for (Dvd currentDvd : dvdList) {
            String dvdInfo = String.format("#%s : %s %s",
                    currentDvd.getMPAARating(),
                    currentDvd.getTitle(),
                    currentDvd.getReleaseDate());
            io.print(dvdInfo);
        }
        io.readString("Please hit enter to continue.");
    }

    public void displayDisplayAllBanner() {
        io.print("=== Display All Dvds ===");
    }

    public void displayDisplayDvdBanner () {
        io.print("=== Display Dvd ===");
    }

    public String getDvdIdChoice() {
        return io.readString("Please enter the Dvd ID.");
    }

    public void displayDvd(Dvd dvd) {
        if (dvd != null) {
            io.print(dvd.getMPAARating());
            io.print(dvd.getTitle() + " " + dvd.getReleaseDate());
            io.print(dvd.getDirectorName());
            io.print("");
        } else {
            io.print("No such dvd.");
        }
        io.readString("Please hit enter to continue.");
    }

    public void displayRemoveDvdBanner () {
        io.print("=== Remove Dvd ===");
    }

    public void displayRemoveResult(Dvd dvdRecord) {
        if(dvdRecord != null){
            io.print("Dvd successfully removed.");
        }else{
            io.print("No such dvd.");
        }
        io.readString("Please hit enter to continue.");
    }

    public void displayExitBanner() {
        io.print("Good Bye!!!");
    }

    public void displayUnknownCommandBanner() {
        io.print("Unknown Command!!!");
    }

    public void displayErrorMessage(String errorMsg) {
        io.print("=== ERROR ===");
        io.print(errorMsg);
    }
    
}
