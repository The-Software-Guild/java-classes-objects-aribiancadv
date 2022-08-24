package com.sg.dvdlibrary.dao;

import com.sg.dvdlibrary.dto.Dvd;

import java.util.List;

public interface DvdLibraryDao {

    /**
     * Adds the given Dvd to the roster and associates it with the given
     * dvd id. If there is already a dvd associated with the given
     * dvd id it will return that dvd object, otherwise it will
     * return null.
     *
     * @param title id with which dvd is to be associated
     * @param dvd dvd to be added to the roster
     * @return the Dvd object previously associated with the given
     * dvd id if it exists, null otherwise
     * @throws DvdLibraryDaoException
     */
    Dvd addDvd(String title, Dvd dvd)
            throws DvdLibraryDaoException;

    /**
     * Returns a List of all Dvds on the roster.
     *
     * @return Dvd List containing all dvds on the roster.
     * @throws DvdLibraryDaoException
     */
    List<Dvd> getAllDvds()
            throws DvdLibraryDaoException;

    /**
     * Returns the dvd object associated with the given dvd id.
     * Returns null if no such dvd exists
     *
     * @param title ID of the dvd to retrieve
     * @return the Dvd object associated with the given dvd id,
     * null if no such dvd exists
     * @throws DvdLibraryDaoException
     */
    Dvd getDvd(String title)
            throws DvdLibraryDaoException;

    /**
     * Removes from the roster the dvd associated with the given id.
     * Returns the dvd object that is being removed or null if
     * there is no dvd associated with the given id
     *
     * @param title id of dvd to be removed
     * @return Dvd object that was removed or null if no dvd
     * was associated with the given dvd id
     * @throws DvdLibraryDaoException
     */
    Dvd removeDvd(String title)
            throws DvdLibraryDaoException;
    
}
