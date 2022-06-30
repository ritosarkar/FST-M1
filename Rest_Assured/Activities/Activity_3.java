package activities;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.eventFrom;

public class Activity_3 {
    final String BASE_URL="https://petstore.swagger.io/v2/pet";
    RequestSpecification requestSpecification;
    ResponseSpecification responseSpecification,responseSpec;


    @Test(priority = 0)
    public void setUp(){
        requestSpecification=new RequestSpecBuilder()
                .setContentType(ContentType.JSON) //Set the header
                .setBaseUri(BASE_URL) //set the URL
                .build();

        responseSpecification = new ResponseSpecBuilder()
                .expectStatusCode(200) //Set the status code
                .expectContentType("application/json") //set the content type for validation
                .expectBody("status",equalTo("alive")) //add assertion for status field
                .build();

    }
    @DataProvider
    public Object[][] dataSet(){
        Object[][] testData={
                {1211, "OmRiley", "alive"},
                {1212, "DiHansel", "alive"}
        };
        return testData;
    }
    @Test(dataProvider = "dataSet",priority = 1)
    public void createPet(int id, String name, String status){
        Response response1,response2;
        String reqBody = "{\"id\": 1211, \"name\": \"OmRiley\", \"status\": \"alive\"}";
        response1= given().spec(requestSpecification)
                .body(reqBody)
                .when().post();

        reqBody = "{\"id\": 1212, \"name\": \"DiHansel\", \"status\": \"alive\"}";
        response2 = given().spec(requestSpecification)
                .body(reqBody)
                .when().post();

        response1.then().spec(responseSpecification);
        response2.then().spec(responseSpecification);


    }

    @Test(dataProvider = "dataSet",priority = 2)
    public void getPet(int id, String name, String status)
    {
        String Name , Status;
        Response response=given().spec(requestSpecification)
                .pathParams("petId",id)
                .when().get("/{petId}");
        Name= JsonPath.from(response.asString()).get("name");
        Status=JsonPath.from(response.asString()).get("status");
        String responseBody=response.getBody().asPrettyString();
        System.out.println(responseBody);
        response.then().spec(responseSpecification).body("name",equalTo(name));
        response.then().spec(responseSpecification).body("status",equalTo(status));
        System.out.println("Pet "+Name+" is "+Status);


    }

    @Test(dataProvider = "dataSet",priority = 3)
    public void deletePet(int id, String name, String status)
    {
        Response response=given().spec(requestSpecification)
                .pathParam("petId",id)
                .when().delete("/{petId}");

        response.then().body("code",equalTo(200));
    }
}
