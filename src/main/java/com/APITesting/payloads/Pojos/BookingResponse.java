package com.APITesting.payloads.Pojos;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class BookingResponse {

    @SerializedName("bookingid")
    @Expose
    private Integer bookingid;
    @SerializedName("booking")
    @Expose
    private CreateBookingSimple booking;

    public Integer getBookingid() {
        return bookingid;
    }

    public void setBookingid(Integer bookingid) {
        this.bookingid = bookingid;
    }

    public CreateBookingSimple getBooking() {
        return booking;
    }

    public void setBooking(CreateBookingSimple booking) {
        this.booking = booking;
    }

}