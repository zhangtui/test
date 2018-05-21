package interfacerestAssured;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import org.junit.BeforeClass;
import org.junit.Test;


public class TestAppLogin {

	@BeforeClass
	public static void setup(){
		useRelaxedHTTPSValidation();
		RestAssured.baseURI = "http://supperapp.jmc.com.cn";		
	}
	@Test
	public void GetBaseApk(){
		given()
			.accept("*/*")
			.header("User-Agent","TMJMCApp/3.1.0 (iPhone; iOS 11.3.1; Scale/3.00)")
		.when()
			.get("/uap/plugin/tag/getBaseApk").prettyPeek()
		.then()
			.statusCode(200)
			.body("status", equalTo("failure"))
			;
	}
	@Test
	public void Login(){
		final String bodyString = 
			"{\"account\":\"admin\",\"password\":\"5euWNREuDMIOIECV8ahkUA==\",\"mobile\":\"13611962595\",\"pwdType\":\"1\",\"deviceCode\":\"215B9649-B2E1-4D33-BFBF-0A988DD4B640\",\"deviceNo\":\"171976fa8a8b1c13448\",\"currentVersion\":\"3.1.0\",\"sysType\":\"2\",\"appVersion\":\"3.1.0\",\"loginType\":\"app\"}";
		Response response = given()
			.contentType("application/json")
			.body(bodyString)
		.when()
			.post("/uap/login?appKey=SUPERAPP&sign=1c426338d1809e1b5f23f17857a8dea6&timestamp=1526633789810").prettyPeek()
		.then()
			.statusCode(200)
			.body("status", equalTo("success")).extract().response()
			;
		
		String aid = response.path("data.aid");
		String name = response.path("data.name");
		String token = response.path("data.token");
		System.out.println(token);
		System.out.println(aid);
		System.out.println(name);
		
		given().contentType("application/json")
		.parameters("appkey", "5339399909", "signt","1526633850000","sign","4b48db8db4aadaead899177264bf4950","token",token)
		.when().get("https://mg.jmc.com.cn/vehicle-customer/vehicle/getVehiclesByToken").prettyPeek()
		.then().statusCode(200)
		;
	}
	@Test
	public void vehicleCustomer(){
		given().contentType("application/json")
		.parameters("appkey", "5339399909", "signt","1526633850000","sign","4b48db8db4aadaead899177264bf4950","token","")
		.when();
	}
//	@Test
//	public void LoginOut(){
//		
//		given()
//		.parameters("appkey","SUPERAPP","token","st_23cc6b30da134dce9fbdf0ca098491b6","sign","de27392fe22dbec6c2788708bb99a166")
//		.when().get("http://superappuat.jmc.com.cn/user/logout")
//		.then()
//			.statusCode(400);
//	}
//	@Test
//	public void VehicleStatus(){
//		final String url = "http://mguat.jmc.com.cn/vehicle-status/public/condition/getSnapshotV2?nonce=0112A335-EDA2-4999-85F2-7A080AA8F357&appkey=9847076556&signt=1526544516000&token=st_23cc6b30da134dce9fbdf0ca098491b6&sign=205c9c581023d1c2f64c929b72303081";
//		final String bodyString = "{\"vin\":\"LEFADDE14JHP11559\",\"statusCode\":\"\",\"sort\":\"\"}";
//		given()
//			.contentType("application/json")
//			.request().body(bodyString)
//		.when()
//			.post(url).prettyPeek()
//		.then()
//			;
//	}
//    @Test
//    public void testCreate() {
//        final String bodyString = "{\"customerId\": \"CDICC\",\"broker\": \"test\",\"editUserId\": \"wadexu\"}";
//       
//        given().
//        contentType("application/json").
//        request().body(bodyString).
//        expect().
//          statusCode(200).
//          body(
//          "success", equalTo(true)).
//        when().
//        post("/order");
//    }
//	

}
