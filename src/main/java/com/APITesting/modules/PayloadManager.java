package com.APITesting.modules;

import com.APITesting.payloads.Pojos.request.Auth;
import com.APITesting.payloads.Pojos.request.Booking;
import com.APITesting.payloads.Pojos.request.Bookingdates;
import com.APITesting.payloads.Pojos.response.BookingResponse;
import com.github.javafaker.Faker;
import com.google.gson.Gson;
import io.qameta.allure.internal.shadowed.jackson.core.JsonProcessingException;
import io.qameta.allure.internal.shadowed.jackson.databind.ObjectMapper;


public class PayloadManager {
    ObjectMapper objectMapper;
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

    public String UpdatePayload() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        Booking booking = new Booking();
        booking.setFirstname("SARATH");
        booking.setLastname("T V");
        booking.setTotalprice(199);
        booking.setDepositpaid(true);
        booking.setAdditionalneeds("Breakfast, lunch");
        Bookingdates bookingdates = new Bookingdates();
        bookingdates.setCheckin("2024-04-01");
        bookingdates.setCheckout("2024-04-10");
        booking.setBookingdates(bookingdates);
        String payload = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(booking);
        return payload;

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

    public BookingResponse JsonToObject(String jsonString) throws JsonProcessingException {
        objectMapper = new ObjectMapper();
        BookingResponse bookingRespons = objectMapper.readValue(jsonString, BookingResponse.class);
        return bookingRespons;
    }
    public Booking JsonToObjectPUT(String jsonString) throws JsonProcessingException {
        objectMapper = new ObjectMapper();
        Booking bookingRespons = objectMapper.readValue(jsonString, Booking.class);
        return bookingRespons;
    }


}

    



