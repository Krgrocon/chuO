package DSA.chuO.service;

import org.springframework.stereotype.Service;

import DSA.chuO.model.Member;
import DSA.chuO.repositroy.MemberRepositroy;
import DSA.chuO.repositroy.MemberRepositroyImpl;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberService {
	
	private MemberRepositroy memberRepositroy;

	public Member addMember(Member member) {
		return member;
		
	}

}
