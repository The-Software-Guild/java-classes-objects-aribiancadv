package com.sg.dvdlibrary.dao;

import com.sg.dvdlibrary.dto.Dvd;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public interface DvdLibraryDao {


    Dvd addDvd(String title, Dvd dvd)
            throws DvdLibraryDaoException, IOException;


    List<Dvd> getAllDvds()
            throws DvdLibraryDaoException, IOException;


    Dvd getDvd(String title)
            throws DvdLibraryDaoException, IOException;


    Dvd removeDvd(String title)
            throws DvdLibraryDaoException, IOException;

    List searchDvds(String searchTerm, List<Dvd> dvdList) throws DvdLibraryDaoException;

    void setLibraryFile(String libraryFile);

    void loadLibrary() throws DvdLibraryDaoException, IOException;
}
