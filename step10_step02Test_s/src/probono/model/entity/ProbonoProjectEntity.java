/*
CREATE TABLE probono_project (
	   probono_project_id     		NUMBER(5) PRIMARY KEY,
	   probono_project_name 		VARCHAR2(50) NOT NULL,
       probono_id           			VARCHAR2(50) NOT NULL,       
       activist_id          				VARCHAR2(20) NOT NULL,
       receive_id           				VARCHAR2(20) NOT NULL, 
       project_content      			VARCHAR2(100) NOT NULL
);   */

package probono.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "probono_project")
public class ProbonoProjectEntity {
	@Id
	@Column(name="probono_project_id")
	private int probonoProjectId;
	
	@Column(name="probono_project_name")
	private String probonoProjectName;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="probono_id")
	private ProbonoEntity probonoId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="activist_id")
	private ActivistEntity activistId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="receive_id")
	private RecipientEntity receiveId;
	
	@Column(name="project_content")
	private String projectContent;
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("1. 프로젝트 id : ");
		builder.append(probonoProjectId);
		builder.append("2. 프로보노 프로젝트명 : ");
		builder.append(probonoProjectName);
		builder.append("3. 프로보노 정보 : ");
		builder.append(probonoId);
		builder.append("4. 재능 기부자 정보 : ");
		builder.append(activistId);
		builder.append("5. 수해자 정보 : ");
		builder.append(receiveId);
		builder.append("6. 프로젝트 제공내용 : ");
		builder.append(projectContent);
		return builder.toString();
	}
}