import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.junit.Test;
import org.testng.Assert;

public class TC002_POST_Request {

    @Test
    public void registrationSuccessful() {

        RestAssured.baseURI = "http://restapi.demoqa.com/customer";

        RequestSpecification httpRequest = RestAssured.given();

        JSONObject requestParams = new JSONObject();
        requestParams.put("FirstName", "Michal1");
        requestParams.put("LastName", "Stelmach2");
        requestParams.put("UserName", "stelmam13");
        requestParams.put("Password", "Michal1233");
        requestParams.put("Email", "stelmam1@mail.pl3");

        httpRequest.header("Content-Type", "application/json");

        httpRequest.body(requestParams.toJSONString());

        Response response = httpRequest.request(Method.POST, "/register");


        String responseBody = response.getBody().asString();
        System.out.println("Response Body is: " + responseBody);

        int statusCode = response.statusCode();
        System.out.println("Status code: " + statusCode);
        Assert.assertEquals(statusCode, 201);

        String successCode = response.jsonPath().get("SuccessCode").toString();
        System.out.println("Success code: " + successCode);
        Assert.assertEquals(successCode, "OPERATION_SUCCESS");

        String message = response.jsonPath().get("Message").toString();
        System.out.println("Message: " + message);
        Assert.assertEquals(message, "Operation completed successfully");

    }
}
