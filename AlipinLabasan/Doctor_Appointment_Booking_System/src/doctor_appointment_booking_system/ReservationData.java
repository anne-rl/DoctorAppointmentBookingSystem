/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doctor_appointment_booking_system;
/**
 *
 * @author Labasan
 */
public class ReservationData {
    private int roomNo; 
    private int accountID, reservationID;
    private String date;      
    private String time;
    
    public ReservationData(int reserveID, String date, int roomNo, String time) {
        this.reservationID = reserveID;
        this.date = date;
        this.roomNo = roomNo;
        this.time = time;
    }
    
    public ReservationData(int accountID, int reserveID, String date, int roomNo, String time) {
        this.accountID = accountID;
        this.reservationID = reserveID;
        this.date = date;
        this.roomNo = roomNo;
        this.time = time;
    }

    public int getRoomNo() {
        return roomNo;
    }
    public int getAccountID() {
        return accountID;
    }
    public int getReservationID(){
        return reservationID;
    }
    public void setRoomNo(int roomNo) {
        this.roomNo = roomNo;
    }
    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }
    public String getDate() {
        return date;
    }
    public String getTime() {
        return time;
    }
    public void setTime(String time) {
        this.time = time;
    }
}
