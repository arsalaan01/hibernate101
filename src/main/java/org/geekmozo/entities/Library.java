package org.geekmozo.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class Library {
    @Column(name = "LIBRARY_NAME")
    String libraryName;
    @Column(name = "LIBRARY_INCHARGE")
    String incharge;
    @Column(name = "LIBRARY_POSITION")
    String place;

    public Library() {
    }

    public Library(String libraryName, String incharge, String place) {
        this.libraryName = libraryName;
        this.incharge = incharge;
        this.place = place;
    }

    public String getLibraryName() {
        return libraryName;
    }

    public void setLibraryName(String libraryName) {
        this.libraryName = libraryName;
    }

    public String getIncharge() {
        return incharge;
    }

    public void setIncharge(String incharge) {
        this.incharge = incharge;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }
}
