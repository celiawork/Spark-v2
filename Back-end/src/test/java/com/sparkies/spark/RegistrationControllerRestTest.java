package com.sparkies.spark;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

@SpringBootTest
public class RegistrationControllerRestTest {

	/**
	 * Test registration of user in the database and the mail sending of
	 * confirmation
	 */
	@Test
	public void testAPIregister() {

		RestAssured.baseURI = "http://localhost:8090";
		Response response = given().contentType("application/json").body(
				"{\"firstname\":\"Marcel\",\"lastname\":\"Dupont\",\"email\":\"marcel@mail.fr\",\"password\":\"1234567\"}")
				.post("api/registration");

		int statusCode = response.getStatusCode();
		assertEquals(200, statusCode);
	}
}







