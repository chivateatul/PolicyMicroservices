package pcr.policies.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pcr.common.dto.AppRespInfo;
import pcr.common.entity.policy.PolicyInfo;
import pcr.policies.services.PolicyCRUDServiceImpl;

@RestController
@RequestMapping("/api/services/policy/crud")

public class PolicyCRUDServiceController {

	@Autowired
	@Qualifier(PolicyCRUDServiceImpl.BEAN_ID)
	PolicyCRUDServiceImpl crudServiceImpl;

	@RequestMapping("create")
	public ResponseEntity<String> createPolicy(@RequestBody PolicyInfo policyInfo) {
		crudServiceImpl.createPolicy(policyInfo);
		return ResponseEntity.ok().body("CreateSuccess");
	}

	@RequestMapping("update")
	public ResponseEntity<String> updatePolicy(@RequestBody PolicyInfo policyInfo) {
		crudServiceImpl.updatePolicy(policyInfo);
		return ResponseEntity.ok().body("UpdateSuccess");
	}

	@RequestMapping("delete")
	public ResponseEntity<String> deletePolicy(@RequestBody Long id) {
		crudServiceImpl.deletePolicy(id);
		return ResponseEntity.ok().body("DeleteSuccess");
	}

	@RequestMapping("get")
	public ResponseEntity<PolicyInfo> getPolicy(@RequestBody Long id) {
		PolicyInfo policyInfo = crudServiceImpl.getPolicy(id).get();
		return ResponseEntity.ok().body(policyInfo);
	}

	@RequestMapping("getAll")
	public ResponseEntity<AppRespInfo> getAllPolicies() {
		Iterable<PolicyInfo> iterable = crudServiceImpl.getAllPolicies();

		AppRespInfo appRespInfo = new AppRespInfo();
		appRespInfo.addData("ALL", iterable);

		return ResponseEntity.ok().body(appRespInfo);

	}

}
