package pcr.risks.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KafkaClaimPubSubServiceImpl {

	@Autowired
	RiskDeterminationServiceImpl serviceImpl;

	public void subscribeToNewClaimKafkaTopic() {
		serviceImpl.performRiskDetermination(0L);
	}

	public void publishToRiskyClaimRiskKafkaTopic() {
		//Publish to kafka
	}
	
}
