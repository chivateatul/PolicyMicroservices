package pcr.policies.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import pcr.common.entity.policy.PolicyInfo;
import pcr.policies.dao.PolicyCRUDServiceDAO;

@Service(PolicyCRUDServiceImpl.BEAN_ID)
public class PolicyCRUDServiceImpl {

	public static final String BEAN_ID = "PolicyCRUDServiceImpl";

	@Autowired
	@Qualifier(PolicyCRUDServiceDAO.BEAN_ID)
	PolicyCRUDServiceDAO crudServiceDAO;

	public void createPolicy(PolicyInfo policyInfo) {
		crudServiceDAO.save(policyInfo);
	}

	public void updatePolicy(PolicyInfo policyInfo) {
		crudServiceDAO.save(policyInfo);
	}

	public void deletePolicy(Long id) {
		crudServiceDAO.deleteById(id);
	}

	public Optional<PolicyInfo> getPolicy(Long id) {
		return crudServiceDAO.findById(id);
	}

	public Iterable<PolicyInfo> getAllPolicies() {
		return crudServiceDAO.findAll();

	}

}
