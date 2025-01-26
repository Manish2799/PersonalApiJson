package Model;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PersonalInfo {

	@JsonProperty("firstName")
	private String firstName;

	@JsonProperty("lastName")
	private String lastName;

	@JsonProperty("topics")
	private ArrayList<String> topics;

	@JsonProperty("fees")
	private ArrayList<Integer> fees;

	@JsonProperty("address")
	private Address address;
}
