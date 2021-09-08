import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;

public class GivenIMakeASinglePostcodeCall extends Stage<GivenIMakeASinglePostcodeCall> {
	private RequestSpecification requestSpecification;

	public GivenIMakeASinglePostcodeCall( ) {
		RestAssured.baseURI = "https://api.postcodes.io";
		RestAssured.basePath = "/postcodes/";

		requestSpecification = RestAssured.given();
	}

	@ProvidedScenarioState
	Response singlePostcodeResponseBody;

	@ProvidedScenarioState
	String postcodeToBeTested;

	public GivenIMakeASinglePostcodeCall ICallTheSinglePostcodeServiceWithAValidPostcode(String postcode){
		postcodeToBeTested = postcode;
		singlePostcodeResponseBody = requestSpecification.get(postcode);
		return this;
	}
}
