package vacation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class FirstPageController {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showPage() {
        return "initial";
    }
}
