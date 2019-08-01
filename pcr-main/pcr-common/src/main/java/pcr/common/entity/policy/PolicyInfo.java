package pcr.common.entity.policy;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import pcr.common.entity.BaseEntity;

@Entity
@Table(name = "policy_info")
public class PolicyInfo extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@Column(name = "name", nullable = false, length = 100)
	private String name;

	@Column(name = "description", nullable = false, length = 100)
	private String description;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
