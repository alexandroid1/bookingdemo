package romaniancoder.booking;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

/**
 * Created by Александр on 29.07.2017.
 */

@Controller
public class ViewController {

    @RequestMapping("/")
    public String index(Model model){

        model.addAttribute("datetime", new Date());
        model.addAttribute("username", "Romanian Coder");
        //model.addAttribute("mode", "development");
        model.addAttribute("mode", "production");

        return "index";
    }
}
