package romaniancoder.booking;

import org.omg.CORBA.Environment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

/**
 * Created by Александр on 29.07.2017.
 */

@Controller
public class ViewController {

    @Value("${app-mode}")
    private String appMode;

    @RequestMapping("/")
    public String index(Model model){

        model.addAttribute("datetime", new Date());
        model.addAttribute("username", "John");
        model.addAttribute("mode", appMode);

        return "index";
    }
}
