package local.simpleapp.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import local.simpleapp.Models.GreetingResponseObject;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/")
public class ProbeController {
    @GetMapping("/livez")
    public GreetingResponseObject getLivez() {
        
        return new GreetingResponseObject("running");
    }

    @GetMapping("/readyz")
    public GreetingResponseObject getReadyz() {
        return new GreetingResponseObject("ok");
    }
}
