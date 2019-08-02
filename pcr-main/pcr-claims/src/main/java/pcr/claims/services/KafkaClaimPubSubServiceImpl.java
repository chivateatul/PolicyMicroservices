package pcr.claims.services;

import java.util.Arrays;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pcr.common.entity.claim.ClaimInfo;

@Service
public class KafkaClaimPubSubServiceImpl {

	@Autowired
	ClaimCRUDServiceImpl claimCRUDServiceImpl;

	Properties producerPrioperties = new Properties();
	Properties consumerPrioperties = new Properties();

	public void publishToNewClaimsKafkaTopic(Long claimId) {

		KafkaProducer<Long, Long> producer = new KafkaProducer<Long, Long>(producerPrioperties);
		producer.send(new ProducerRecord<Long, Long>("NEW_CLAIMS", claimId));

	}

	public void subscribeToRiskyClaims() {
		KafkaConsumer<Long, Long> consumer = new KafkaConsumer<Long, Long>(consumerPrioperties);
		consumer.subscribe(Arrays.asList("RISKY_CLAIMS"));
		while (true) {

			ConsumerRecords<Long, Long> records = consumer.poll(100);
			for (ConsumerRecord<Long, Long> record : records) {
				Long claimId = record.value();
				updateRiskyClaimStatus(claimId);
			}

		}

	}

	private void updateRiskyClaimStatus(Long claimId) {

		ClaimInfo claimInfo = claimCRUDServiceImpl.getClaim(claimId).get();
		claimInfo.setStatus("RISKY_CLAIM");

		claimCRUDServiceImpl.updateClaim(claimInfo);

	}

}
