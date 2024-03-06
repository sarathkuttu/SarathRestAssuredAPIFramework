package com.APITesting.modules;

import com.APITesting.payloads.Pojos.request.Auth;
import com.APITesting.payloads.Pojos.request.Booking;
import com.APITesting.payloads.Pojos.request.Bookingdates;
import com.github.javafaker.Faker;
import com.google.gson.Gson;

public class PayloadManager {

    // JAVA -> JSON

    public String createPayloadGSON() {
        Faker faker = new Faker();

        Booking booking = new Booking();
        String expectFirstName = faker.name().firstName();
        String expectLasttName = faker.name().lastName();

        booking.setFirstname(expectFirstName);
        booking.setLastname(expectLasttName);
        booking.setTotalprice(112);
        booking.setDepositpaid(true);

        Bookingdates bookingdates = new Bookingdates();
        bookingdates.setCheckin("2024-02-01");
        bookingdates.setCheckout("2024-02-01");
        booking.setBookingdates(bookingdates);
        booking.setAdditionalneeds("Breakfast");

        System.out.println(booking);
        // Object -> JSON String (GSON)
        Gson gson = new Gson();
        String jsonStringBooking = gson.toJson(booking);
        System.out.println(jsonStringBooking);
        return jsonStringBooking;
    }

    public void createPayloadJackSon() {


    }

    public void UpdatePayload() {


    }

    public String SetToken() {

        Auth auth = new Auth();

        auth.setUsername("admin");
        auth.setPassword("password123");

        // Object -> JSON String (GSON)
        Gson gson = new Gson();
        String jsonStringAuth = gson.toJson(auth);
        System.out.println(jsonStringAuth);
        return jsonStringAuth;
    }

}
