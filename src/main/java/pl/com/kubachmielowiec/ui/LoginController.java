package pl.com.kubachmielowiec.ui;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.com.kubachmielowiec.application.LoginProcess;
import pl.com.kubachmielowiec.model.Admin;

@Controller
@RequestMapping("/login")
public class LoginController {

    private LoginProcess loginProcess;

    public LoginController(LoginProcess loginProcess) {
        this.loginProcess = loginProcess;
    }

    @GetMapping
    public String loginHome() {
        return "login";
    }

    @PostMapping
    public String login(Admin admin) {
        loginProcess.validate(admin.getUsername(), admin.getPassword());
        return "redirect:/webservice";
    }
}
