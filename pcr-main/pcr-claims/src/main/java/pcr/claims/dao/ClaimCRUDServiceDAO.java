package pcr.claims.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pcr.common.entity.claim.ClaimInfo;

@Repository(ClaimCRUDServiceDAO.BEAN_ID)
public interface ClaimCRUDServiceDAO extends CrudRepository<ClaimInfo, Long> {

	public static final String BEAN_ID = "ClaimCRUDServiceDAO";

}
