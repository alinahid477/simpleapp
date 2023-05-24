package local.simpleapp;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.http.MediaType;
// import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.reactive.server.WebTestClient;

import local.simpleapp.Controllers.api.GreetingsController;
import local.simpleapp.Models.GreetingResponseObject;

@WebFluxTest(GreetingsController.class)
class SimpleAppApplicationTests {

	@Autowired
	private WebTestClient webTestClient;

	
	@Test
    public void shouldPassIfStringMatches() throws Exception {
        // assertTrue(restTemplate.getForObject("http://localhost:" + port + "/api/greetings/healthcheck", String.class).contains("running"));
		webTestClient.get().uri("/api/greetings/healthcheck").accept(MediaType.APPLICATION_JSON).exchange()
			.expectStatus().isOk()
			.expectBody(GreetingResponseObject.class).value(resp -> resp.getGreetingText().equals("running"));
    }


}
