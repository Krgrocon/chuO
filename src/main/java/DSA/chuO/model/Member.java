package DSA.chuO.model;

import java.time.*;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
public class Member {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MEMBER_ID")
	private Long id;
	
	@Column(unique = true)
	private String email;
	private String password;
	
	@Column(unique = true)
	private String nickname;
	private String profileImage;
	private LocalDateTime createAt;
	private LocalDateTime updateAt;
	
}
