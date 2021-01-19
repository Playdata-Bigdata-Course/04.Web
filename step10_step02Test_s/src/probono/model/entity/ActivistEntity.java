/**
CREATE TABLE activist (
       activist_id          	VARCHAR2(20)  PRIMARY KEY,
       name               	VARCHAR2(20) NOT NULL,
       password         	VARCHAR2(20) NOT NULL,
       major                	VARCHAR2(50) NOT NULL
); */
package probono.model.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "activist")
public class ActivistEntity {
	@Id
	@Column(name="activist_id")
	private String id;

	@Column(name="name")
	private String name;

	@Column(name="password")
	private String password;

	@Column(name="major")
	private String major;
	
	@OneToMany(mappedBy = "activistId")
	private List<ProbonoProjectEntity> projects;

	public ActivistEntity(String id, String name, String password, String major) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.major = major;
	}
}