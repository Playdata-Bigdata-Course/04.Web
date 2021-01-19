package probono.model.dto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RecipientDTO extends People {
	
	private String receiveContent;
	public RecipientDTO(String id, String name, String password, String receiveContent) {
		super(id, name, password);
		this.receiveContent = receiveContent;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(" 4. 제공받는 대상자가 제공받는 서비스 : ");
		builder.append(receiveContent);
		return builder.toString();
	}
}
