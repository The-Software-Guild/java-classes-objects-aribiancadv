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
        String title = getDvdTitleChoice();
        String releaseDate = getDvdReleaseDateChoice();
        String MPAARating = getMPAAChoice();
        String directorName = getDirectorChoice();
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
        io.print("=== Display All DVDs ===");
    }

    public void displayDisplayDvdBanner() {
        io.print("=== Display DVD ===");
    }

    public void displayEditDvdBanner() { io.print("=== Search for DVD ==="); }

    public String getDvdTitleChoice() {
        return io.readString("Please enter the DVD Title.");
    }
    public String getDvdReleaseDateChoice() { return io.readString("Please enter the DVD Release Date."); }
    public String getMPAAChoice() { return io.readString("Please enter the MPAA Rating."); }
    public String getDirectorChoice() { return io.readString("Please enter the director's name."); }

    public String getStudioChoice() { return io.readString("Please enter the studio's name."); }
    public String getNoteChoice() { return io.readString("Please enter a note."); }

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

    public int printEditMenuAndGetSelection() {
        io.print("Which information would you like to edit for this DVD?");
        io.print("1. Title");
        io.print("2. Release Date");
        io.print("3. MPAA Rating");
        io.print("4. Director's Name");
        io.print("5. Studio");
        io.print("6. Note");
        io.print("7. Go Back");

        return io.readInt("Please select from the above choices.", 1, 7);
    }



    public void displayEditTitleResult(Dvd editedDvd) {

        io.print("The new title is: " + editedDvd.getTitle());
        io.readString("Please hit enter to continue.");
    }



    public void displayEditDateResult(Dvd editedDvd) {

        io.print("The new Release Date is: " + editedDvd.getReleaseDate());
        io.readString("Please hit enter to continue.");
    }


    public void displayEditMPAAResult(Dvd editedDvd) {
        io.print("The new MPAA Rating is: " + editedDvd.getMPAARating());
        io.readString("Please hit enter to continue.");

    }


    public void displayEditDirectorResult(Dvd editedDvd) {
        io.print("The new director's name is: " + editedDvd.getDirectorName());
        io.readString("Please hit enter to continue.");

    }

    public void displayEditStudioResult(Dvd editedDvd) {
        io.print("The new studio name is: " + editedDvd.getStudioName());
        io.readString("Please hit enter to continue.");

    }


    public void displayEditNoteResult(Dvd editedDvd) {
        io.print("The new note reads: " + editedDvd.getNote());
        io.readString("Please hit enter to continue.");
    }




}
