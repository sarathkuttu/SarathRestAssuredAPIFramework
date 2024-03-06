package com.APITesting.payloads.Pojos.response;


import com.APITesting.payloads.Pojos.request.Booking;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class BookingResponse {

    @SerializedName("bookingid")
    @Expose
    private Integer bookingid;
    @SerializedName("booking")
    @Expose
    private Booking booking;

    public Integer getBookingid() {
        return bookingid;
    }

    public void setBookingid(Integer bookingid) {
        this.bookingid = bookingid;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

}