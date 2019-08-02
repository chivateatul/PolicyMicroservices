package pcr.risks.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import pcr.common.entity.risk.RiskInfo;
import pcr.risks.dao.RiskCRUDServiceDAO;

@Service(RiskCRUDServiceImpl.BEAN_ID)
public class RiskCRUDServiceImpl {

	public static final String BEAN_ID = "RiskCRUDServiceImpl";

	@Autowired
	@Qualifier(RiskCRUDServiceDAO.BEAN_ID)
	RiskCRUDServiceDAO crudServiceDAO;

	public void createRisk(RiskInfo RiskInfo) {
		crudServiceDAO.save(RiskInfo);
	}

	public void updateRisk(RiskInfo RiskInfo) {
		crudServiceDAO.save(RiskInfo);
	}

	public void deleteRisk(Long id) {
		crudServiceDAO.deleteById(id);
	}

	public Optional<RiskInfo> getRisk(Long id) {
		return crudServiceDAO.findById(id);
	}

	public Iterable<RiskInfo> getAllPolicies() {
		return crudServiceDAO.findAll();

	}

}
