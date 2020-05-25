package restAssuredTesting;

import java.util.Iterator;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class TestAPI 

{
	@Test
	public void getResponce()
	{
		SoftAssert softassert=new SoftAssert();
		Response responce=RestAssured.get("https://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=439d4b804bc8187953eb36d2a8c26a02");
		System.out.println("-----------"+responce.statusCode());
		Assert.assertEquals(responce.statusCode(), 200, "Its not successful...........");
		System.out.println("-----------"+responce.asString());
		String Jasondata=responce.asString();
		JSONObject jasonobject=new JSONObject(Jasondata);
	    System.out.println(jasonobject.getJSONObject("coord").get("lon"));
	    System.out.println(jasonobject.getJSONObject("coord").get("lat"));
	    String array1=jasonobject.getJSONArray("weather").get(0).toString();
	    System.out.println(array1);
		JSONObject jasonobject1=new JSONObject(array1);
	    System.out.println(jasonobject1.get("icon"));
	    String name=jasonobject.get("name").toString();
	    softassert.assertEquals(name, "London", "Name is not matching");
	    System.out.println(jasonobject.getJSONObject("coord").get("lat"));
	    softassert.assertAll();
	    Headers headers=responce.getHeaders();
	    Iterator<Header> header=headers.iterator();
	    while(header.hasNext())
	    {
	    Header h1=header.next();
	    System.out.println(h1.getValue());
	    }

		System.out.println("-----------"+responce.getBody());
		System.out.println("-----------"+responce.getContentType());
		System.out.println("-----------"+responce.getStatusLine());
		System.out.println("-----------"+responce.getTime());
		System.out.println("-----------"+responce.time());
		System.out.println("-----------"+responce.statusCode());
		

	}

}
