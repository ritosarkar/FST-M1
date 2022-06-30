package activities;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import static org.hamcrest.CoreMatchers.equalTo;
import static io.restassured.RestAssured.given;

public class Activity_1 {
    //set base URL

    final static String ROOT_URL="https://petstore.swagger.io/v2/pet";

    @Test(priority = 1)
    public void addNewPet()
    {
        String reqBody="{"
                +"\"id\":77232,"
                +"\"name\":\"Riley\","
                +"\"status\":\"alive\""
                +"}";
        Response response = given().contentType(ContentType.JSON)//Set headers
                .body(reqBody)//Add request body
                .when().post(ROOT_URL);//send POST the request

        System.out.println("<-----addNewPet starts------>");
        System.out.println(response.body().prettyPrint());//print response
        System.out.println("<-----addNewPet ends------>");

        //Assertions
        response.then().body("id",equalTo(77232));
        response.then().body("name",equalTo("Riley"));
        response.then().body("status",equalTo("alive"));
    }

    @Test(priority = 2)
    public void getPetInfo()
    {
        Response response=given().contentType(ContentType.JSON)//Set header
                .when().pathParam("petId","77232")//set path params
                .get(ROOT_URL+"/{petId}"); //Send GET request

        System.out.println("<-----getPetInfo starts------>");
        System.out.println(response.body().prettyPrint());//print response
        System.out.println("<-----getPetInfo ends------>");
        //Assertions
        response.then().body("id",equalTo(77232));
        response.then().body("name",equalTo("Riley"));
        response.then().body("status",equalTo("alive"));
    }

    @Test(priority = 3)
    public void deletePet(){
        Response response= given().contentType(ContentType.JSON)//Set header
                .when().pathParam("petId","77232")//set path params
                .delete(ROOT_URL+"/{petId}");//send DELETE request

        System.out.println("<-----deletePet starts------>");
        System.out.println(response.body().prettyPrint());//print response
        System.out.println("<-----deletePet ends------>");

        //Assertions
        response.then().body("code",equalTo(200));
        response.then().body("message",equalTo("77232"));
    }
}
