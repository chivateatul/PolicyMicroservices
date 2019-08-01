package pcr.common.entity.claim;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import pcr.common.entity.BaseEntity;

@Entity
@Table(name = "member_info")
public class MemberInfo extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@Column(name = "first_name", length = 50, nullable = false)
	private String firstName;

	@Column(name = "last_name", length = 50, nullable = false)
	private String lastName;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}
