package pl.com.kubachmielowiec.ui;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.com.kubachmielowiec.application.WebService;

@Controller
@RequestMapping("/webservice")
public class WebServiceController {

    WebService webService;

    public WebServiceController(WebService webService) {
        this.webService = webService;
    }

    @GetMapping
    public String webserviceHome() {
        return "webservice";
    }

    @ModelAttribute("total")
    public Long calculateTotal() {
        return webService.calculateTotalSubmissions();
    }
}
