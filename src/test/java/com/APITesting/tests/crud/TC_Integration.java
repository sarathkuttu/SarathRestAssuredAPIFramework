package com.APITesting.tests.crud;

import com.APITesting.Base.BaseTest;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.*;

public class TC_Integration extends BaseTest {
    String token;

    //Create Booking
    @Test(groups = "P0")
    public void CreateBooking() {
        assertThat("SARATH").isEqualTo("SARATH");
         token = getToken();
        System.out.println(token);
    }

    //Update the Booking with Token and Booking ID
    @Test(groups = "P0", dependsOnMethods = {"CreateBooking"})
    public void UpdateBooking() {
        assertThat("SARATH").isEqualTo("SARATH");

    }

    //DeleteBooking
    @Test(groups = "P0", dependsOnMethods = {"UpdateBooking"})
    public void DeleteBooking() {
        assertThat("SARATH").isEqualTo("SARATH");

    }
}
