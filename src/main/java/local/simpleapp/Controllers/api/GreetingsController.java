package local.simpleapp.Controllers.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import local.simpleapp.AppProperties;
import local.simpleapp.Models.GreetingResponseObject;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/greetings")
public class GreetingsController {

    private final Logger logger = LoggerFactory.getLogger(GreetingsController.class);

    private final AppProperties appProperties;

    @GetMapping("/healthcheck")
    public GreetingResponseObject healthCheck() {
        logger.info("Inside healthcheck..");
        return new GreetingResponseObject("running");
    }


    @GetMapping("/env")
    public GreetingResponseObject greeting() {
        logger.info("Inside greeting..");
        return new GreetingResponseObject(this.appProperties.getGreetingText() + " - Live APR 04 2023");
    }
    
}
