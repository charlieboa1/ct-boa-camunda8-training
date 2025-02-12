package camunda.io.saas.zeebe.saas_zeebe;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import static org.springframework.boot.SpringApplication.run;
import io.camunda.zeebe.spring.client.annotation.Deployment;

@SpringBootApplication
@Deployment(resources = "classpath:test-sample-camunda8.bpmn")
public class SaasZeebeApplication {

	public static void main(String[] args) {
		run(SaasZeebeApplication.class, args);
	}



}
