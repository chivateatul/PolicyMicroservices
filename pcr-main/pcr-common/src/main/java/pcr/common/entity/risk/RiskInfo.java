package pcr.common.entity.risk;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import pcr.common.entity.BaseEntity;

@Entity
@Table(name = "risk_info")
public class RiskInfo extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@Column(name = "claim_id", nullable = false)
	private Long claimId;

	public Long getClaimId() {
		return claimId;
	}

	public void setClaimId(Long claimId) {
		this.claimId = claimId;
	}

}
