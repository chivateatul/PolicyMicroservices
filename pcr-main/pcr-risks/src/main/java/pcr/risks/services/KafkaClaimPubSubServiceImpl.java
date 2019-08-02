package pcr.risks.services;

import java.util.Arrays;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

@ConditionalOnProperty(name = "pcr.messaging.technology.kafka", value = "true")
@Service
public class KafkaClaimPubSubServiceImpl {

	@Autowired
	RiskDeterminationServiceImpl serviceImpl;

	Properties producerPrioperties = new Properties();
	Properties consumerPrioperties = new Properties();

	public void subscribeToNewClaimKafkaTopic() {

		KafkaConsumer<Long, Long> consumer = new KafkaConsumer<Long, Long>(consumerPrioperties);
		consumer.subscribe(Arrays.asList("NEW_CLAIMS"));
		while (true) {

			ConsumerRecords<Long, Long> records = consumer.poll(100);
			for (ConsumerRecord<Long, Long> record : records) {
				Long claimId = record.value();
				serviceImpl.performRiskDetermination(claimId);
			}
		}
	}

	public void publishToRiskyClaimRiskKafkaTopic(Long claimId) {
		// Publish to kafka
		KafkaProducer<Long, Long> producer = new KafkaProducer<Long, Long>(producerPrioperties);
		producer.send(new ProducerRecord<Long, Long>("RISKY_CLAIMS", claimId));

	}

}
