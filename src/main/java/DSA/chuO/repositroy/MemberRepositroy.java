package DSA.chuO.repositroy;

import org.springframework.data.jpa.repository.JpaRepository;

import DSA.chuO.model.Member;

public interface MemberRepositroy extends JpaRepository<Member, Long>{
	
	// 이메일로 로그인처리
	Member findByEmail(String email);

}
