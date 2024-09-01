package example_project;

import java.util.Objects;

public class UserDTO {
	private String checkEmailId;
	private String checkPassword;
	
	public String getCheckEmailId() {
		return checkEmailId;
	}
	public void setCheckEmailId(String checkEmailId) {
		this.checkEmailId = checkEmailId;
	}
	public String getCheckPassword() {
		return checkPassword;
	}
	public void setCheckPassword(String checkPassword) {
		this.checkPassword = checkPassword;
	}
	@Override
	public String toString() {
		return "UserDTO [checkEmailId=" + checkEmailId + ", checkPassword=" + checkPassword + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(checkEmailId, checkPassword);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserDTO other = (UserDTO) obj;
		return Objects.equals(checkEmailId, other.checkEmailId) && Objects.equals(checkPassword, other.checkPassword);
	}
	
	

}
