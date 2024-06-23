package DSA.chuO.repositroy;

import org.springframework.data.jpa.repository.JpaRepository;

import DSA.chuO.model.Member;

public interface MemberRepositroy extends JpaRepository<Member, Long>{
	
	Member findByEmail(String email);
}
