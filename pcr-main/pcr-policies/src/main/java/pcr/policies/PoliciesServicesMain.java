package pcr.policies;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import pcr.common.constants.AppConfigConstants;

@SpringBootApplication
@EntityScan(basePackages = "pcr.common.entity.policy")
public class PoliciesServicesMain {

	public static void main(String[] args) {
		// SpringApplication.run(PoliciesServicesMain.class, args);
		SpringApplication app = new SpringApplication(PoliciesServicesMain.class);
		app.setAdditionalProfiles(AppConfigConstants.SPRING_PROFILE_GLOBAL_CONFIG);
		app.run(args);
	}

}
