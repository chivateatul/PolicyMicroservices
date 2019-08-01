package pcr.policies.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pcr.common.entity.policy.PolicyInfo;

@Repository(PolicyCRUDServiceDAO.BEAN_ID)
public interface PolicyCRUDServiceDAO extends CrudRepository<PolicyInfo, Long> {
	public static final String BEAN_ID = "PolicyCRUDServiceDAO";

}
