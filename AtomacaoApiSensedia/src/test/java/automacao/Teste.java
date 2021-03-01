package automacao;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.nullValue;

import org.hamcrest.Matchers;
import org.junit.Test;

import io.restassured.RestAssured;

public class Teste {

	@Test
	public void criarUmCard() {

		given()
			.log().all()
			.contentType("application/json")
		.when()
			.post("https://api.trello.com/1/cards?key=9e8cd01ef0bcda1f29e85e6fd8340e88&token=ea2e432d4110363798d5b965d253dc2347d26bf9be01f34ae00da038ea82ffc6&idList=603accde8791516349c0fe04&name=Teste de API Sensedia")
		.then()
			.statusCode(200)
			.body("name", is("Teste de API Sensedia"))

		;

	}

	@Test
	public void editarCard() {

		
		given()
			.log().all()
			.contentType("application/json")
			.body("{\"name\" : \"Teste Sensedia\"}")
				
		.when()
			.put("https://api.trello.com/1/cards/603d0b84cad9d7511dfaef10?key=9e8cd01ef0bcda1f29e85e6fd8340e88&token=ea2e432d4110363798d5b965d253dc2347d26bf9be01f34ae00da038ea82ffc6")
		.then()
			.log().all()
			.statusCode(200)
			.body("name", is("Teste Sensedia"))
			
			
			;
		
	}

	
	@Test
	public void excluirCard() {
		
		given()
			.log().all()
		.when()
			.delete("https://api.trello.com/1/cards/603d0b84cad9d7511dfaef10?key=9e8cd01ef0bcda1f29e85e6fd8340e88&token=ea2e432d4110363798d5b965d253dc2347d26bf9be01f34ae00da038ea82ffc6")
		.then()
			.log().all()
			.statusCode(200)
			
		
		
		
		
		;
		
	}
}
