package pcr.risks.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pcr.risks.services.RiskDeterminationServiceImpl;

@RestController
@RequestMapping("/api/services/risk/determination")
public class RiskDeterminationController {

	@Autowired
	RiskDeterminationServiceImpl serviceImpl;

	@RequestMapping("perform")
	public void performRiskDetermination(@RequestBody Long claimId) {
		serviceImpl.performRiskDetermination(claimId);
	}

}
