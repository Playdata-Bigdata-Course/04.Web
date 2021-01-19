package probono.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class People {
	private String id;
	private String name;
	private String password;

	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("1. 재능 기부자 id : ");
		builder.append(id);
		builder.append(" 2. 이름 : ");
		builder.append(name);
		builder.append(" 3. 비밀번호 : ");
		builder.append(password);
		return builder.toString();
	}
}
