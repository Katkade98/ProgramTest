package API_Utility;

public class PayLoadUtility {

	public static String  updateUserPayload(String userName,String userJob)
	{
		return "{\r\n"
				+ "    \"name\": \""+userName+"\",\r\n"
				+ "    \"job\": \""+userJob+"\"\r\n"
				+ "}";
	}
	
	public static String createUserGoRestPayLoad(String userName, String gender, String email,String status)
	{
		return "{\"name\":\""+userName+"\", \"gender\":\""+gender+"\", \"email\":\""+email+"\", \"status\":\""+status+"\"}";
		
	}
}
