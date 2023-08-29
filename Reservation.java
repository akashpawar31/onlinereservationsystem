package OnlineReservationSystem;

import java.util.Date;

public class Reservation {
    private String guestName;
    private int roomNumber;
    private Date checkInDate;
    private Date checkOutDate;
	public String getGuestName() {
		return guestName;
	}
	public void setGuestName(String guestName) {
		this.guestName = guestName;
	}
	public int getRoomNumber() {
		return roomNumber;
	}
	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}
	public Date getCheckInDate() {
		return checkInDate;
	}
	public void setCheckInDate(Date checkInDate) {
		this.checkInDate = checkInDate;
	}
	public Date getCheckOutDate() {
		return checkOutDate;
	}
	public void setCheckOutDate(Date checkOutDate) {
		this.checkOutDate = checkOutDate;
	}
	public Reservation(String guestName, int roomNumber, Date checkInDate, Date checkOutDate) {
		super();
		this.guestName = guestName;
		this.roomNumber = roomNumber;
		this.checkInDate = checkInDate;
		this.checkOutDate = checkOutDate;
	}

   
}
