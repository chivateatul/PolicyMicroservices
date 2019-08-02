package pcr.risks.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pcr.common.dto.AppRespInfo;
import pcr.common.entity.risk.RiskInfo;
import pcr.risks.services.RiskCRUDServiceImpl;

@RestController
@RequestMapping("/api/service/Risk/crud")
public class RiskCRUDServiceController {

	@Autowired
	@Qualifier(RiskCRUDServiceImpl.BEAN_ID)
	RiskCRUDServiceImpl crudServiceImpl;

	@RequestMapping("create")
	public ResponseEntity<AppRespInfo> create(@RequestBody RiskInfo RiskInfo) {

		crudServiceImpl.createRisk(RiskInfo);

		AppRespInfo appRespInfo = new AppRespInfo();
		appRespInfo.addData("RESULT", "Success");

		return ResponseEntity.ok().body(appRespInfo);
	}

	@RequestMapping("update")
	public ResponseEntity<AppRespInfo> update(@RequestBody RiskInfo RiskInfo) {

		crudServiceImpl.createRisk(RiskInfo);

		AppRespInfo appRespInfo = new AppRespInfo();
		appRespInfo.addData("RESULT", "Success");

		return ResponseEntity.ok().body(appRespInfo);
	}

	@RequestMapping("delete")
	public ResponseEntity<AppRespInfo> delete(@RequestBody Long id) {

		crudServiceImpl.deleteRisk(id);

		AppRespInfo appRespInfo = new AppRespInfo();
		appRespInfo.addData("RESULT", "Success");

		return ResponseEntity.ok().body(appRespInfo);
	}

	@RequestMapping("get")
	public ResponseEntity<AppRespInfo> get(@RequestBody Long id) {

		RiskInfo RiskInfo = crudServiceImpl.getRisk(id).get();

		AppRespInfo appRespInfo = new AppRespInfo();
		appRespInfo.addData("RESULT", RiskInfo);

		return ResponseEntity.ok().body(appRespInfo);
	}

	@RequestMapping("getAll")
	public ResponseEntity<AppRespInfo> getAll() {

		Iterable<RiskInfo> iterable = crudServiceImpl.getAllPolicies();

		AppRespInfo appRespInfo = new AppRespInfo();
		appRespInfo.addData("RESULT", iterable);

		return ResponseEntity.ok().body(appRespInfo);

	}
}
