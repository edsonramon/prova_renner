package br.df.edsonramon.rest.tests;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.df.edsonramon.rest.core.BaseTest;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestesAPI extends BaseTest {
		
	@Test
	public void t01_listarTodosUsuariosDaPagina() {				
		given()
		.queryParam("page", "2")
		.when()
		.get("users")
		.then()		
		.statusCode(200)
		.body("page", is(2))
		.body("data", hasSize(6))
		.body("data[0].id", is(7))
		.body("data.first_name", hasItems("Michael", "Lindsay", "Tobias", "Byron", "George", "Rachel"))
		.body("support.url", is("https://reqres.in/#support-heading"))
		;
	}
	
	@Test
	public void t02_listarUsuarioJanet() {
		given()		
		.when()
		.get("users/2")
		.then()		
		.statusCode(200)
		.body("data.email", is("janet.weaver@reqres.in"))
		.body("data.first_name", is("Janet"))
		.body("support.text", containsString("To keep ReqRes free"))
		;
	}
	
	@Test
	public void t03_listarUsuarioNaoEncontrado() {
		given()		
		.when()
		.get("users/23")
		.then()		
		.statusCode(404)
		;
	}
	
	@Test
	public void t04_criarUsuarioViaMap() {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("name", "morpheus");
		params.put("job", "leader");
		params.put("id", 509);
		params.put("createdAt", "2021-05-13T23:10:17.703Z");
		
		given()		
		.body(params)
		.when()
		.post("users")
		.then()		
		.statusCode(201)
		.body("name", is("morpheus"))
		.body("job", is("leader"))
		.body("id", is(509))
		.body("createdAt", is(notNullValue()))
		;
	}
	
	@Test
	public void t05_alterarUsuarioViaObjeto() {
		User user = new User("morpheus", "zion resident");
		
		given()
		.body(user)
		.when()
		.put("users/2")
		.then()		
		.statusCode(200)
		.body("name", is("morpheus"))
		.body("job", is("zion resident"))
		.body("updatedAt", is(notNullValue()))
		;
	}
	
	@Test
	public void t06_alterarUsuarioViaPatch() {
		given()		
		.body("{\"name\": \"morpheus\", \"job\": \"zion resident\"}")
		.when()
		.patch("users/2")
		.then()		
		.statusCode(200)
		.body("name", is("morpheus"))
		.body("job", containsString("zion resident"))
		.body("updatedAt", is(containsString("2021-05")))
		;
	}
	
	@Test
	public void t07_deletarUsuario() {
		given()		
		.when()
		.delete("users/2")
		.then()		
		.statusCode(204)
		;
	}
}