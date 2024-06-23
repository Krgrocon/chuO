package DSA.chuO.service;

import DSA.chuO.model.Member;
import DSA.chuO.model.Post;

public interface PostService {
	
	// 게시글 저장
	void savePost(Post post, Member member);
	
}
	