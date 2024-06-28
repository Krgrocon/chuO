package DSA.chuO.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import DSA.chuO.model.Member;
import DSA.chuO.repositroy.MemberRepositroy;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

	private final MemberRepositroy memberRepositroy;
	LocalDateTime localDateTime = LocalDateTime.now();

	@Override
	public void registerMember(Member member) {

		try {
			member.setCreateAt(localDateTime);
			log.info("출력되긴하나요?{}", member);
			memberRepositroy.save(member);

		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public Member findUserId(String email) {
		Member member = memberRepositroy.findByEmail(email);
		return member;
	}

	public boolean MemberEmailVerification(String email){
		boolean ismembereamil = true;
		System.out.println("email: " + email);
		Member memberemail = memberRepositroy.findByEmail(email);
		if(memberemail == null){
			ismembereamil = false;
		}
		return ismembereamil;
	}

}
