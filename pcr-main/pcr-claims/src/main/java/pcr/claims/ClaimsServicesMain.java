package pcr.claims;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import pcr.common.constants.AppConfigConstants;

@SpringBootApplication
@EntityScan(basePackages = "pcr.common.entity.claim")
public class ClaimsServicesMain {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(ClaimsServicesMain.class);
		app.setAdditionalProfiles(AppConfigConstants.SPRING_PROFILE_GLOBAL_CONFIG);
		app.run(args);
	}

}
