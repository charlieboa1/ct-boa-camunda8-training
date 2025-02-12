package camunda.io.saas.zeebe.saas_zeebe;

import io.camunda.zeebe.client.ZeebeClient;
import io.camunda.zeebe.client.api.response.ActivatedJob;
import io.camunda.zeebe.spring.client.annotation.JobWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Service
@EnableAsync
public class ZeebeService {

    @Autowired
    ZeebeClient zeebeClient ;


    @JobWorker(type = "testJobWorker1" )
    public Map<String,Object> handleJobFoo(final ActivatedJob job) {
        // do whatever you need to do
        Map<String,Object> jobVars = job.getVariablesAsMap();
        jobVars.put("testWorkerVar1", "test worker var 1");
        return jobVars;

    }

    @Async
    public void startProcessByProcessId(String processId) {

        Duration requestTimeOut = Duration.ofSeconds(40);
        zeebeClient.newCreateInstanceCommand().bpmnProcessId(processId).latestVersion()
                .requestTimeout(requestTimeOut).send().join(40, TimeUnit.SECONDS);

    }



}
