package com.sg.dvdlibrary.dao;

import com.sg.dvdlibrary.dto.Dvd;

import java.util.ArrayList;
import java.util.List;

public interface DvdLibraryDao {


    Dvd addDvd(String title, Dvd dvd)
            throws DvdLibraryDaoException;


    List<Dvd> getAllDvds()
            throws DvdLibraryDaoException;


    Dvd getDvd(String title)
            throws DvdLibraryDaoException;


    Dvd removeDvd(String title)
            throws DvdLibraryDaoException;

    List searchDvds(String searchTerm, List<Dvd> dvdList) throws DvdLibraryDaoException;

    void setLibraryFile(String libraryFile);

    void loadLibrary() throws DvdLibraryDaoException;
}
