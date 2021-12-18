package com.example.hotelbk;

public class UploadRoomBooking {
    String myRoom, myAdult, myKids, myName, myNumber, myEmail, myArrival, myDeparture;

    public UploadRoomBooking() {
    }

    public UploadRoomBooking(String myRoom, String myAdult, String myKids, String myName,
                             String myNumber, String myEmail, String myArrival, String myDeparture) {
        this.myRoom = myRoom;
        this.myAdult = myAdult;
        this.myKids = myKids;
        this.myName = myName;
        this.myNumber = myNumber;
        this.myEmail = myEmail;
        this.myArrival = myArrival;
        this.myDeparture = myDeparture;
    }

    public String getMyRoom() {
        return myRoom;
    }

    public void setMyRoom(String myRoom) {
        this.myRoom = myRoom;
    }

    public String getMyAdult() {
        return myAdult;
    }

    public void setMyAdult(String myAdult) {
        this.myAdult = myAdult;
    }

    public String getMyKids() {
        return myKids;
    }

    public void setMyKids(String myKids) {
        this.myKids = myKids;
    }

    public String getMyName() {
        return myName;
    }

    public void setMyName(String myName) {
        this.myName = myName;
    }

    public String getMyNumber() {
        return myNumber;
    }

    public void setMyNumber(String myNumber) {
        this.myNumber = myNumber;
    }

    public String getMyEmail() {
        return myEmail;
    }

    public void setMyEmail(String myEmail) {
        this.myEmail = myEmail;
    }

    public String getMyArrival() {
        return myArrival;
    }

    public void setMyArrival(String myArrival) {
        this.myArrival = myArrival;
    }

    public String getMyDeparture() {
        return myDeparture;
    }

    public void setMyDeparture(String myDeparture) {
        this.myDeparture = myDeparture;
    }
}
