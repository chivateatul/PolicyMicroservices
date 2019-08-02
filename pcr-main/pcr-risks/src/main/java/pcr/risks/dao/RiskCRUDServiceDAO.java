package pcr.risks.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pcr.common.entity.risk.RiskInfo;

@Repository(RiskCRUDServiceDAO.BEAN_ID)
public interface RiskCRUDServiceDAO extends CrudRepository<RiskInfo, Long> {

	public static final String BEAN_ID = "RiskCRUDServiceDAO";

}
