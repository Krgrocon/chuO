package DSA.chuO.service;

import DSA.chuO.model.Member;

public interface MemberService {
	
	void registerMember(Member meber);
	Member findUserId(String email);
	boolean MemberEmailVerification(String email);

}
