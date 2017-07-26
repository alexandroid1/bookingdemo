package romaniancoder.booking;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Александр on 26.07.2017.
 */

@RestController
public class DemoController {

    @RequestMapping("/hello")
    public String hello(){
        return "Hello";
    }
}
