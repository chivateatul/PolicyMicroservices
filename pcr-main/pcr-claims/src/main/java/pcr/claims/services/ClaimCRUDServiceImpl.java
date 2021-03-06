package pcr.claims.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import pcr.claims.dao.ClaimCRUDServiceDAO;
import pcr.common.entity.claim.ClaimInfo;

@Service(ClaimCRUDServiceImpl.BEAN_ID)
public class ClaimCRUDServiceImpl {

	public static final String BEAN_ID = "ClaimCRUDServiceImpl";

	@Autowired
	@Qualifier(ClaimCRUDServiceDAO.BEAN_ID)
	ClaimCRUDServiceDAO crudServiceDAO;

	@Autowired
	KafkaClaimPubSubServiceImpl claimPubSubServiceImpl;
	
	public void createClaim(ClaimInfo claimInfo) {		
		crudServiceDAO.save(claimInfo);
		claimPubSubServiceImpl.publishToNewClaimsKafkaTopic(claimInfo.getId());
	}

	public void updateClaim(ClaimInfo claimInfo) {
		crudServiceDAO.save(claimInfo);
		claimPubSubServiceImpl.publishToNewClaimsKafkaTopic(claimInfo.getId());
	}

	public void deleteClaim(Long id) {
		crudServiceDAO.deleteById(id);
	}

	public Optional<ClaimInfo> getClaim(Long id) {
		return crudServiceDAO.findById(id);
	}

	public Iterable<ClaimInfo> getAllPolicies() {
		return crudServiceDAO.findAll();

	}

}
