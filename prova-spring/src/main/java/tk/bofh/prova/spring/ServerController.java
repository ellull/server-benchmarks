package tk.bofh.prova.spring;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServerController {

    @RequestMapping("/")
    public String index(@RequestBody String payload) {
        return new Integer(payload.length()).toString();
    }

}
