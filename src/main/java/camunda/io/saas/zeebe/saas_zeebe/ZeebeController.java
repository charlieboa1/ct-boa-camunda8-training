package camunda.io.saas.zeebe.saas_zeebe;


import io.camunda.zeebe.client.ZeebeClient;
import io.camunda.zeebe.client.api.response.ActivatedJob;
import io.camunda.zeebe.spring.client.annotation.JobWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/camunda/saas/zeebe/v1")
public class ZeebeController {

    @Autowired
    private ZeebeService zeebeService;


    @GetMapping("/createProcessInstance")
    public void createProcessInstance(@RequestParam("processInstanceId") String processInstancId) {

            zeebeService.startProcessByProcessId(processInstancId);

    }


}
