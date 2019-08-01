package pcr.risks;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import pcr.common.constants.AppConfigConstants;

@SpringBootApplication
@EntityScan(basePackages = "pcr.common.entity.risk")
public class RisksServicesMain {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(RisksServicesMain.class);
		app.setAdditionalProfiles(AppConfigConstants.SPRING_PROFILE_GLOBAL_CONFIG);
		app.run(args);
	}

}
