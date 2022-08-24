package com.sg.dvdlibrary.controller;

import com.sg.dvdlibrary.dao.DvdLibraryDao;
import com.sg.dvdlibrary.dao.DvdLibraryDaoException;
import com.sg.dvdlibrary.dto.Dvd;
import com.sg.dvdlibrary.ui.DvdLibraryView;

import java.util.List;


public class DvdLibraryController {
    private DvdLibraryView view;
    private DvdLibraryDao dao;


    public DvdLibraryController(DvdLibraryDao dao, DvdLibraryView view) {
        this.dao = dao;
        this.view = view;
    }

    public void run() {
        boolean keepGoing = true;
        int menuSelection = 0;
        try {
            while (keepGoing) {

                menuSelection = getMenuSelection();

                switch (menuSelection) {
                    case 1:
                        listDvds();
                        break;
                    case 2:
                        createDvd();
                        break;
                    case 3:
                        viewDvd();
                        break;
                    case 4:
                        removeDvd();
                        break;
                    case 5:
                        editDvd();
                        break;
                    case 6:
                        searchDvd();
                        break;
                    case 7:   
                        loadLibraryFromFile();
                        break;
                    case 8:
                        keepGoing = false;
                        break;
                    
                        
                    default:
                        unknownCommand();
                }

            }
            exitMessage();
        } catch (DvdLibraryDaoException e) {
            view.displayErrorMessage(e.getMessage());
        }
    }

    private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }

    private void createDvd() throws DvdLibraryDaoException {
        view.displayCreateDvdBanner();
        Dvd newDvd = view.getNewDvdInfo();
        dao.addDvd(newDvd.getTitle(), newDvd);
        view.displayCreateSuccessBanner();
    }

    private void listDvds() throws DvdLibraryDaoException {
        view.displayDisplayAllBanner();
        List<Dvd> dvdList = dao.getAllDvds();
        view.displayDvdList(dvdList);
    }

    private void viewDvd() throws DvdLibraryDaoException {
        view.displayDisplayDvdBanner();
        String title = view.getDvdTitleChoice();
        Dvd dvd = dao.getDvd(title);
        view.displayDvd(dvd);
    }

    private void removeDvd() throws DvdLibraryDaoException {
        view.displayRemoveDvdBanner();
        String title = view.getDvdTitleChoice();
        Dvd removedDvd = dao.removeDvd(title);
        view.displayRemoveResult(removedDvd);
    }

    private void editDvd() throws DvdLibraryDaoException {
        view.displayEditDvdBanner();
        String title = view.getDvdTitleChoice();
        Dvd editedDvd = dao.getDvd(title);
        view.printEditMenuAndGetSelection();
        try {
            boolean keepGoing = true;
            int menuSelection = 0;
            while (keepGoing) {

                menuSelection = getMenuSelection();

                switch (menuSelection) {
                    case 1:
                        editTitle(editedDvd);
                        break;
                    case 2:
                        editReleaseDate(editedDvd);
                        break;
                    case 3:
                        editMPAARating();
                        break;
                    case 4:
                        editDirectorsName();
                        break;
                    case 5:
                        editStudio();
                        break;
                    case 6:
                        editNote();
                        break;
                    case 8:
                        run();
                        break;
                    default:
                        unknownCommand();
                }

            }

        } catch (DvdLibraryDaoException e) {
            view.displayErrorMessage(e.getMessage());
        }

    }

    private void editMPAARating(Dvd editedDvd) {
        editedDvd.setMPAARating(view.getMPAAChoice());
        view.displayEditMPAAResult(editedDvd);
    }

    private void editTitle(Dvd editedDvd) {

        editedDvd.setTitle(view.getDvdTitleChoice());
        view.displayEditTitleResult(editedDvd);

    }

    private void editReleaseDate(Dvd editedDvd) {

        editedDvd.setReleaseDate(view.getDvdReleaseDateChoice());
        view.displayEditDateResult(editedDvd);

    }


    private void unknownCommand() {
        view.displayUnknownCommandBanner();
    }

    private void exitMessage() {
        view.displayExitBanner();
    }
    
}
