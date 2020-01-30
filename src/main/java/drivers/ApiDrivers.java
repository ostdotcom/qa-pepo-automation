package drivers;

import java.util.HashMap;
import java.util.TreeMap;

import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;
import io.restassured.config.EncoderConfig;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONException;
import org.json.JSONObject;

public class ApiDrivers {


    public void rotateUsers(HashMap<String, Object> queryParams){
        getRequest(queryParams,"/api/v1/rotate-account" );
    }


    public JSONObject loginUsers(HashMap<String, Object> queryParams){

        // Sorting map
        //TreeMap<String,String> sortedMap = new TreeMap<String,String>(queryParams);


        TreeMap<String,Object> map = new TreeMap<>(queryParams);

        System.out.println(map);
        return postRequest(map,"/api/v1/auth/twitter-login" );
    }


    private static JSONObject getRequest(HashMap<String, Object> queryParams, String apiPath)
    {

        Response response = given()
                .queryParams(queryParams)
                .when()
                .log().all()
                .get("http://stagingpepo.com"+apiPath)
                .then()
                .log().all()
                //.statusCode(200)
                .extract()
                .response();

        JSONObject jsonObject = null;
        try {
            jsonObject = new JSONObject(response.getBody().asString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObject;
    }


    private static JSONObject postRequest(TreeMap<String, Object> queryParams, String apiPath)
    {
        Response response = given()
                .config(RestAssured.config() .encoderConfig(EncoderConfig.encoderConfig() .encodeContentTypeAs("x-www-form-urlencoded", ContentType.URLENC)))
                .when()
                .log().all()
                .contentType(ContentType.URLENC.withCharset("UTF-8"))
                .formParams(queryParams)
                .post("https://stagingpepo.com"+apiPath)
                .then()
                .log().all()
                //.statusCode(200)
                .extract()
                .response();

        JSONObject jsonObject = null;
        try {
            jsonObject = new JSONObject(response.getBody().asString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObject;
    }
}
