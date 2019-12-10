import drivers.ApiDrivers;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.JSONObject;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class Temp {


    public static void main(String args[])
    {

        ApiDrivers apiDrivers = new ApiDrivers();

        HashMap<String, Object> params = new HashMap<>();
        params.put("token", "1169918663371026433-zDN48wJvmz2snspAH5C3i9q7tBfo78");
        params.put("secret", "J7zgG7LXMCMx6CJCsUBFGo6t2UXlvowky1ecuqudatw3C");
        params.put("twitter_id", "1169918663371026433");
        params.put("handle", "BhavikPepo");
        JSONObject jsonObject =  apiDrivers.loginUsers(params);

        String userId = jsonObject.getJSONObject("data").getJSONObject("logged_in_user").get("user_id").toString();

        String userName = jsonObject.getJSONObject("data").getJSONObject("users").getJSONObject(userId).get("user_name").toString();

        HashMap<String, Object> params1 = new HashMap<>();
        params1.put("user_name",userName);
        apiDrivers.rotateUsers(params1);
    }
}
