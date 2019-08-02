package pcr.risks.services;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import pcr.common.entity.claim.ClaimInfo;
import pcr.common.entity.risk.RiskInfo;

@Service("RiskDeterminationServiceImpl")
public class RiskDeterminationServiceImpl {

	@Autowired
	RestTemplate restTemplate;

	@Autowired
	RiskCRUDServiceImpl riskCRUDServiceImpl;

	public void performRiskDetermination(Long claimId) {

//		ClaimInfo claimInfo = restTemplate.exchange(null, ClaimInfo.class);
//
//		if (claimInfo.getClaimAmount() > 10000) {
//
//			RiskInfo riskInfo = new RiskInfo();
//			riskInfo.setClaimId(claimId);
//			riskCRUDServiceImpl.createRisk(riskInfo);
//
//		}
	}

}
