package com.sg.dvdlibrary.dao;

import com.sg.dvdlibrary.dto.Dvd;

import java.io.*;
import java.util.*;


public class DvdLibraryDaoFileImpl implements DvdLibraryDao{

    private final Map<String, Dvd> dvds = new HashMap<>();


    public String libraryFile = "fullDVDLibrary.txt";
    public static final String DELIMITER = "::";
    @Override
    public Dvd addDvd(String title, Dvd dvd)
            throws DvdLibraryDaoException {
        loadRoster();
        Dvd newDvd = dvds.put(title, dvd);
        writeRoster();
        return newDvd;
    }

    @Override
    public List<Dvd> getAllDvds()
            throws DvdLibraryDaoException {
        loadRoster();
        return new ArrayList<>(dvds.values());
    }

    @Override
    public void loadLibrary() throws DvdLibraryDaoException{
        loadRoster();
    }

    @Override
    public Dvd getDvd(String title)
            throws DvdLibraryDaoException {
        loadRoster();
        return dvds.get(title);
    }

    @Override
    public Dvd removeDvd(String title)
            throws DvdLibraryDaoException {
        loadRoster();
        Dvd removedDvd = dvds.remove(title);
        writeRoster();
        return removedDvd;
    }

    @Override
    public List<Dvd> searchDvds(String searchTerm, List<Dvd> dvdList) {
        List<Dvd> foundDvdList = new ArrayList<>();
        for(Dvd dvd : dvdList){
            if(dvd.getTitle().contains(searchTerm)){
                foundDvdList.add(dvd);
            }
        }
        return foundDvdList;
    }


    private Dvd unmarshallDvd(String dvdAsText){

        String[] dvdTokens = dvdAsText.split(DELIMITER);

        String title = dvdTokens[0];

        Dvd dvdFromFile = new Dvd(title);

        dvdFromFile.setReleaseDate(dvdTokens[1]);

        dvdFromFile.setMPAARating(dvdTokens[2]);

        dvdFromFile.setDirectorName(dvdTokens[3]);

        dvdFromFile.setStudioName(dvdTokens[4]);

        dvdFromFile.setNote(dvdTokens[5]);


        return dvdFromFile;
    }

    private void loadRoster() throws DvdLibraryDaoException {
        Scanner scanner;

        try {

            scanner = new Scanner(
                    new BufferedReader(
                            new FileReader(libraryFile)));
        } catch (FileNotFoundException e) {
            throw new DvdLibraryDaoException(
                    "-_- Could not load library data into memory.", e);
        }

        String currentLine;

        Dvd currentDvd;

        while (scanner.hasNextLine()) {

            currentLine = scanner.nextLine();

            currentDvd = unmarshallDvd(currentLine);


            dvds.put(currentDvd.getTitle(), currentDvd);
        }

        scanner.close();
    }
    private String marshallDvd(Dvd aDvd){

        String dvdAsText = aDvd.getTitle() + DELIMITER;

        dvdAsText += aDvd.getReleaseDate() + DELIMITER;

        dvdAsText += aDvd.getMPAARating() + DELIMITER;

        dvdAsText += aDvd.getDirectorName() + DELIMITER;

        dvdAsText += aDvd.getStudioName() + DELIMITER;

        dvdAsText += aDvd.getNote();

        return dvdAsText;
    }


    private void writeRoster() throws DvdLibraryDaoException {

        PrintWriter out;

        try {
            out = new PrintWriter(new FileWriter(libraryFile));
        } catch (IOException e) {
            throw new DvdLibraryDaoException(
                    "Could not save dvd data.", e);
        }


        String dvdAsText;
        List<Dvd> dvdList = this.getAllDvds();
        for (Dvd currentDvd : dvdList) {

            dvdAsText = marshallDvd(currentDvd);

            out.println(dvdAsText);

            out.flush();
        }

        out.close();
    }

    public String getLibraryFile() {
        return libraryFile;
    }

    public void setLibraryFile(String libraryFile) {
        this.libraryFile = libraryFile;
    }
    
}
