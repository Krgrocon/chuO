package DSA.chuO.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import DSA.chuO.model.Member;
import DSA.chuO.model.Post;
import DSA.chuO.repositroy.PostRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class PostServiceImpl implements PostService{
	
	private final PostRepository postRepository;
	LocalDateTime localDateTime = LocalDateTime.now();
	
	@Override
	public void savePost(Post post, Member member) {
		post.setWriterId(member);
		post.setCreatedAt(localDateTime);
		log.info("post{}", post);
		postRepository.save(post);
		
	}

}
