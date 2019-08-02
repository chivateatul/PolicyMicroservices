package pcr.claims.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pcr.common.entity.claim.ClaimInfo;

@Service
public class KafkaClaimPubSubServiceImpl {

	@Autowired
	ClaimCRUDServiceImpl claimCRUDServiceImpl;

	public void publishToNewClaimsKafkaTopic(Long claimId) {

	}

	public void subscribeToRiskyClaims() {
		updateRiskyClaimStatus(0L);
	}

	private void updateRiskyClaimStatus(Long claimId) {

		ClaimInfo claimInfo = claimCRUDServiceImpl.getClaim(claimId).get();
		claimInfo.setStatus("RISKY_CLAIM");

		claimCRUDServiceImpl.updateClaim(claimInfo);

	}

}
