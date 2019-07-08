package com.people.Bean;

public class PlaceBean
{
    public String placeId,placeName,placeLocation,placeShortdesc,placeLongdesc;
    public int pImg1,pIMg2,pImg3,pImg4,pImg5,pImg6;

    public PlaceBean(String placeId,String placeName,String placeLocation,String placeShortdesc,String placeLongdesc,
                     int pImg1,int pIMg2,int pImg3,int pImg4,int pImg5,int pImg6)
    {
        this.placeId=placeId;
        this.placeName=placeName;
        this.placeLocation=placeLocation;
        this.placeShortdesc=placeShortdesc;
        this.placeLongdesc=placeLongdesc;
        this.pImg1=pImg1;
        this.pIMg2=pIMg2;
        this.pImg3=pImg3;
        this.pImg4=pImg4;
        this.pImg5=pImg5;
        this.pImg6=pImg6;

    }

    public String getPlaceId() {
        return placeId;
    }

    public void setPlaceId(String placeId) {
        this.placeId = placeId;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public String getPlaceLocation() {
        return placeLocation;
    }

    public void setPlaceLocation(String placeLocation) {
        this.placeLocation = placeLocation;
    }

    public String getPlaceShortdesc() {
        return placeShortdesc;
    }

    public void setPlaceShortdesc(String placeShortdesc) {
        this.placeShortdesc = placeShortdesc;
    }

    public String getPlaceLongdesc() {
        return placeLongdesc;
    }

    public void setPlaceLongdesc(String placeLongdesc) {
        this.placeLongdesc = placeLongdesc;
    }

    public int getpImg1() {
        return pImg1;
    }

    public void setpImg1(int pImg1) {
        this.pImg1 = pImg1;
    }

    public int getpIMg2() {
        return pIMg2;
    }

    public void setpIMg2(int pIMg2) {
        this.pIMg2 = pIMg2;
    }

    public int getpImg3() {
        return pImg3;
    }

    public void setpImg3(int pImg3) {
        this.pImg3 = pImg3;
    }

    public int getpImg4() {
        return pImg4;
    }

    public void setpImg4(int pImg4) {
        this.pImg4 = pImg4;
    }

    public int getpImg5() {
        return pImg5;
    }

    public void setpImg5(int pImg5) {
        this.pImg5 = pImg5;
    }

    public int getpImg6() {
        return pImg6;
    }

    public void setpImg6(int pImg6) {
        this.pImg6 = pImg6;
    }
}
