package com.sg.dvdlibrary.dao;

import com.sg.dvdlibrary.dto.Dvd;

import java.io.*;
import java.util.*;


public class DvdLibraryDaoFileImpl implements DvdLibraryDao{

    private Map<String, Dvd> dvds = new HashMap<>();
    public static final String LIBRARY_FILE = "fullDVDLibrary.txt";
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
        return new ArrayList(dvds.values());
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

    private Dvd unmarshallDvd(String dvdAsText){
        // dvdAsText is expecting a line read in from our file.
        // For example, it might look like this:
        // 1234::Ada::Lovelace::Java-September1842
        //
        // We then split that line on our DELIMITER - which we are using as ::
        // Leaving us with an array of Strings, stored in dvdTokens.
        // Which should look like this:
        // ______________________________________
        // |    |   |        |                  |
        // |1234|Ada|Lovelace|Java-September1842|
        // |    |   |        |                  |
        // --------------------------------------
        //  [0]  [1]    [2]         [3]
        String[] dvdTokens = dvdAsText.split(DELIMITER);

        // Given the pattern above, the dvd Id is in index 0 of the array.
        String title = dvdTokens[0];

        // Which we can then use to create a new Dvd object to satisfy
        // the requirements of the Dvd constructor.
        Dvd dvdFromFile = new Dvd(title);

        // However, there are 3 remaining tokens that need to be set into the
        // new dvd object. Do this manually by using the appropriate setters.

        // Index 1 - FirstName
        dvdFromFile.setTitle(dvdTokens[1]);

        // Index 2 - LastName
        dvdFromFile.setReleaseDate(dvdTokens[2]);

        // Index 3 - Cohort
        dvdFromFile.setDirectorName(dvdTokens[3]);

        // We have now created a dvd! Return it!
        return dvdFromFile;
    }

    private void loadRoster() throws DvdLibraryDaoException {
        Scanner scanner;

        try {
            // Create Scanner for reading the file
            scanner = new Scanner(
                    new BufferedReader(
                            new FileReader(LIBRARY_FILE)));
        } catch (FileNotFoundException e) {
            throw new DvdLibraryDaoException(
                    "-_- Could not load roster data into memory.", e);
        }
        // currentLine holds the most recent line read from the file
        String currentLine;
        // currentDvd holds the most recent dvd unmarshalled
        Dvd currentDvd;
        // Go through LIBRARY_FILE line by line, decoding each line into a
        // Dvd object by calling the unmarshallDvd method.
        // Process while we have more lines in the file
        while (scanner.hasNextLine()) {
            // get the next line in the file
            currentLine = scanner.nextLine();
            // unmarshall the line into a Dvd
            currentDvd = unmarshallDvd(currentLine);

            // We are going to use the dvd id as the map key for our dvd object.
            // Put currentDvd into the map using dvd id as the key
            dvds.put(currentDvd.getMPAARating(), currentDvd);
        }
        // close scanner
        scanner.close();
    }
    private String marshallDvd(Dvd aDvd){
        // We need to turn a Dvd object into a line of text for our file.
        // For example, we need an in memory object to end up like this:
        // 4321::Charles::Babbage::Java-September1842

        // It's not a complicated process. Just get out each property,
        // and concatenate with our DELIMITER as a kind of spacer.

        // Start with the dvd id, since that's supposed to be first.
        String dvdAsText = aDvd.getMPAARating() + DELIMITER;

        // add the rest of the properties in the correct order:

        // FirstName
        dvdAsText += aDvd.getTitle() + DELIMITER;

        // LastName
        dvdAsText += aDvd.getReleaseDate() + DELIMITER;

        // Cohort - don't forget to skip the DELIMITER here.
        dvdAsText += aDvd.getDirectorName();

        // We have now turned a dvd to text! Return it!
        return dvdAsText;
    }

    /**
     * Writes all dvds in the roster out to a LIBRARY_FILE.  See loadRoster
     * for file format.
     *
     * @throws DvdLibraryDaoException if an error occurs writing to the file
     */
    private void writeRoster() throws DvdLibraryDaoException {
        // NOTE FOR APPRENTICES: We are not handling the IOException - but
        // we are translating it to an application specific exception and
        // then simple throwing it (i.e. 'reporting' it) to the code that
        // called us.  It is the responsibility of the calling code to
        // handle any errors that occur.
        PrintWriter out;

        try {
            out = new PrintWriter(new FileWriter(LIBRARY_FILE));
        } catch (IOException e) {
            throw new DvdLibraryDaoException(
                    "Could not save dvd data.", e);
        }

        // Write out the Dvd objects to the roster file.
        // NOTE TO THE APPRENTICES: We could just grab the dvd map,
        // get the Collection of Dvds and iterate over them but we've
        // already created a method that gets a List of Dvds so
        // we'll reuse it.
        String dvdAsText;
        List<Dvd> dvdList = this.getAllDvds();
        for (Dvd currentDvd : dvdList) {
            // turn a Dvd into a String
            dvdAsText = marshallDvd(currentDvd);
            // write the Dvd object to the file
            out.println(dvdAsText);
            // force PrintWriter to write line to the file
            out.flush();
        }
        // Clean up
        out.close();
    }
    
}
