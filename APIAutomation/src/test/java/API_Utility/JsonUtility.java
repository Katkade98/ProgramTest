package API_Utility;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class JsonUtility {
public static String getJsonValue(Response response, String key)
{
	JsonPath jp=new JsonPath(response.asString());
	return jp.getString(key);
}
}
