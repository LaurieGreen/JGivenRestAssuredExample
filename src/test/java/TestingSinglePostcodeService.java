import org.junit.jupiter.api.Test;

import com.tngtech.jgiven.junit5.DualScenarioTest;

public class TestingSinglePostcodeService extends DualScenarioTest<GivenIMakeASinglePostcodeCall, ThenICanValidateResponse>{

	@Test
	public void testSinglePostcodeServiceResponse(){
		given().ICallTheSinglePostcodeServiceWithAValidPostcode( "g50hb" );
		then().theJsonStatusCodeis200().and().thePostcodeIsInTheResponseBody();
	}
}
