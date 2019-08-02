package pcr.reports;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import pcr.common.constants.AppConfigConstants;

@SpringBootApplication
public class ReportsMain {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(ReportsMain.class);
		app.setAdditionalProfiles(AppConfigConstants.SPRING_PROFILE_GLOBAL_CONFIG);
		app.run(args);
	}
}
