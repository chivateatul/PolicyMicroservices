package pcr.common.entity.claim;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import pcr.common.entity.BaseEntity;

@Entity
@Table(name = "claim_info")
public class ClaimInfo extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@Column(name = "member_id", nullable = false)
	private Long memberId;

	public Long getMemberId() {
		return memberId;
	}

	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}

}
