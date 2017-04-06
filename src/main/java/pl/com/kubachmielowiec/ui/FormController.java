package pl.com.kubachmielowiec.ui;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.com.kubachmielowiec.application.ApplyingProcess;
import pl.com.kubachmielowiec.model.JobApplication;
import pl.com.kubachmielowiec.model.JobPosition;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/form")
public class FormController {

    ApplyingProcess applyingProcess;


    public FormController(ApplyingProcess applyingProcess) {
        this.applyingProcess = applyingProcess;
    }

    @GetMapping("/{jobPosition}")
    public String form(@PathVariable String jobPosition) {
        return "form";
    }

    @PostMapping("/{jobPosition}")
    public String submitApplication(@PathVariable String jobPosition, JobApplication jobApplication, HttpServletRequest request) {
        jobApplication.setJobPosition(new JobPosition(jobPosition));
        jobApplication.setIpAddress(getIpAddress(request));
        applyingProcess.apply(jobApplication);
        return "redirect:/form/success";
    }

    private String getIpAddress(HttpServletRequest request) {
            String remoteAddr = "";

            if (request != null) {
                remoteAddr = request.getHeader("X-FORWARDED-FOR");
                if (remoteAddr == null || remoteAddr.isEmpty()) {
                    remoteAddr = request.getRemoteAddr();
                }
            }

            return remoteAddr;
    }

    @GetMapping("/success")
    public String success() {
        return "thankYou";
    }
}
