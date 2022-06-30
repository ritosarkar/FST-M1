package activities;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.*;
import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.authentication;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.testng.AssertJUnit.assertEquals;

public class Activity_2 {
    final static String ROOT_URL="https://petstore.swagger.io/v2/user";

    @Test(priority = 1)
    public void createNewUser() throws IOException {
        //get input file stream
        FileInputStream inputJson = new FileInputStream("src/test/java/activities/userinfo.json");
        //read the input stream as string
        String reqBody = new String(inputJson.readAllBytes());
        //Send the request from the json
        Response response= given().contentType(ContentType.JSON)//Set header
                .body(reqBody) //Pass the body parameter
                .when().post(ROOT_URL);//Send the POST request
        //close the json
        inputJson.close();

        System.out.println("<-----createNewUser response starts------>");
        System.out.println(response.body().prettyPrint());//print response
        System.out.println("<-----createNewUser response ends------>");

        //assertion
        response.then().body("code",equalTo(200));
        response.then().body("message",equalTo("113274"));

    }

    @Test(priority = 2)
    public void getUser(){

        File outputJson = new File("src/test/java/activities/getResponse.json");
        Response response= given().contentType(ContentType.JSON)//Set header
                .pathParam("username","ritos")//Setting up parameter
                .when().get(ROOT_URL+"/{username}");//Send the GET request



        String outPutResponse=response.getBody().asPrettyString();

        try{
            outputJson.createNewFile();
            FileWriter writer= new FileWriter(outputJson.getPath());
            writer.write(outPutResponse);
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("<-----getUser response starts------>");
        System.out.println(response.body().prettyPrint());//print response
        System.out.println("<-----getUser response ends------>");

        //assertion
        long timeInMilliSeconds=response.time();
        long timeInSeconds=response.timeIn(TimeUnit.SECONDS);

        assertEquals(timeInSeconds, timeInMilliSeconds/1000);

        response.then().body("id",equalTo(113274));
        response.then().body("username",equalTo("ritos"));
        response.then().body("phone",equalTo("8390241078"));


    }

    @Test(priority = 3)
    public void deleteUser(){

        Response response= given().contentType(ContentType.JSON) //Set headers
                .pathParam("username","ritos") //Set parameter
                .when().delete(ROOT_URL+"/{username}");  //Send the DELETE request

        System.out.println("<-----deleteUser response starts------>");
        System.out.println(response.body().prettyPrint());//print response
        System.out.println("<-----deleteUser response ends------>");

        //assertion
        response.then().statusCode(200);
        response.then().body("code",equalTo(200));
        response.then().body("message",equalTo("ritos"));
    }
}
