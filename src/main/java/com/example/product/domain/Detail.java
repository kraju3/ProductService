package com.example.product.domain;


import javax.persistence.Embeddable;

@Embeddable
public class Detail {

    public String description;

    public int smallCount, largeCount, mediumCount, doubleXLCount;


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getSmallCount() {
        return smallCount;
    }

    public void setSmallCount(int smallCount) {
        this.smallCount = smallCount;
    }

    public int getLargeCount() {
        return largeCount;
    }

    public void setLargeCount(int largeCount) {
        this.largeCount = largeCount;
    }

    public int getMediumCount() {
        return mediumCount;
    }

    public void setMediumCount(int mediumCount) {
        this.mediumCount = mediumCount;
    }

    public int getDoubleXLCount() {
        return doubleXLCount;
    }

    public void setDoubleXLCount(int doubleXLCount) {
        this.doubleXLCount = doubleXLCount;
    }

    public Detail(String description, int smallCount, int largeCount, int mediumCount, int doubleXLCount) {
        this.description = description;
        this.smallCount = smallCount;
        this.largeCount = largeCount;
        this.mediumCount = mediumCount;
        this.doubleXLCount = doubleXLCount;
    }

    public Detail() {

    }

    @Override
    public String toString() {
        return "Detail{" +
                "description='" + description + '\'' +
                ", smallCount=" + smallCount +
                ", largeCount=" + largeCount +
                ", mediumCount=" + mediumCount +
                ", doubleXLCount=" + doubleXLCount +
                '}';
    }
}
