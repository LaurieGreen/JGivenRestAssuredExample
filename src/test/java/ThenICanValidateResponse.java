import io.restassured.response.Response;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Locale;

public class ThenICanValidateResponse extends Stage<ThenICanValidateResponse> {

	@ExpectedScenarioState
	Response singlePostcodeResponseBody;

	@ExpectedScenarioState
	String postcodeToBeTested;


	public ThenICanValidateResponse theJsonStatusCodeis200(){
		singlePostcodeResponseBody.then().body( "status", equalTo( 200 ) );
		return this;
	}

	public ThenICanValidateResponse thePostcodeIsInTheResponseBody(){
		String responsePostcode = singlePostcodeResponseBody.jsonPath().getString( "result.postcode" ).toString().toLowerCase( ).replaceAll( "\\s", "" );
		assertEquals(responsePostcode, postcodeToBeTested);
		return this;
	}


}
