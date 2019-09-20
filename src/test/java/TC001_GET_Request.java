import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Test;
import org.testng.Assert;

public class TC001_GET_Request {

    @Test
    public void getWeatherDetails() {

        RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";

        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.request(Method.GET, "/Hyderabad");

        String responseBody = response.getBody().asString();
        System.out.println("Response Body is: " + responseBody);

        int statusCode = response.getStatusCode();
        System.out.println("Status code: " + statusCode);
        Assert.assertEquals(statusCode, 200);

        String statusLine = response.getStatusLine();
        System.out.println("Status line: " + statusLine);
        Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");

    }
}
