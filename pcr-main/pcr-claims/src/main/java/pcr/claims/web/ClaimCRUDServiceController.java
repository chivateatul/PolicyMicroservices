package pcr.claims.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pcr.claims.services.ClaimCRUDServiceImpl;
import pcr.common.dto.AppRespInfo;
import pcr.common.entity.claim.ClaimInfo;

@RestController
@RequestMapping("/api/service/claim/crud")
public class ClaimCRUDServiceController {

	@Autowired
	@Qualifier(ClaimCRUDServiceImpl.BEAN_ID)
	ClaimCRUDServiceImpl crudServiceImpl;

	@RequestMapping("create")
	public ResponseEntity<AppRespInfo> create(@RequestBody ClaimInfo claimInfo) {

		crudServiceImpl.createClaim(claimInfo);

		AppRespInfo appRespInfo = new AppRespInfo();
		appRespInfo.addData("RESULT", "Success");

		return ResponseEntity.ok().body(appRespInfo);
	}

	@RequestMapping("update")
	public ResponseEntity<AppRespInfo> update(@RequestBody ClaimInfo claimInfo) {

		crudServiceImpl.createClaim(claimInfo);

		AppRespInfo appRespInfo = new AppRespInfo();
		appRespInfo.addData("RESULT", "Success");

		return ResponseEntity.ok().body(appRespInfo);
	}

	@RequestMapping("delete")
	public ResponseEntity<AppRespInfo> delete(@RequestBody Long id) {

		crudServiceImpl.deleteClaim(id);

		AppRespInfo appRespInfo = new AppRespInfo();
		appRespInfo.addData("RESULT", "Success");

		return ResponseEntity.ok().body(appRespInfo);
	}

	@RequestMapping("get")
	public ResponseEntity<AppRespInfo> get(@RequestBody Long id) {

		ClaimInfo claimInfo = crudServiceImpl.getClaim(id).get();

		AppRespInfo appRespInfo = new AppRespInfo();
		appRespInfo.addData("RESULT", claimInfo);

		return ResponseEntity.ok().body(appRespInfo);
	}

	@RequestMapping("getAll")
	public ResponseEntity<AppRespInfo> getAll() {

		Iterable<ClaimInfo> iterable = crudServiceImpl.getAllPolicies();

		AppRespInfo appRespInfo = new AppRespInfo();
		appRespInfo.addData("RESULT", iterable);

		return ResponseEntity.ok().body(appRespInfo);

	}
}
