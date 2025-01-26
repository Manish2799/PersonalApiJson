package Model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Address {

	@JsonProperty("street")
	private String street;
	
	@JsonProperty("area")
	private String area;

	@JsonProperty("city")
	private String city;

	@JsonProperty("state")
	private String state;

	@JsonProperty("country")
	private String country;

	@JsonProperty("pincode")
	private int pincode;
}
