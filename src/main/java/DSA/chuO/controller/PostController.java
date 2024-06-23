package DSA.chuO.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import DSA.chuO.model.Member;
import DSA.chuO.model.Post;
import DSA.chuO.service.PostService;
import jakarta.servlet.http.HttpSession;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequiredArgsConstructor
@Slf4j
public class PostController {
	
	private final PostService postService; 
	
	@GetMapping("/write")
	public String writePost() {
		return "/write";
	}
	
	@PostMapping("/write")
	public String processPost(@ModelAttribute Post post, 
							  HttpSession session) {
		Member member = (Member) session.getAttribute("loginMember");
		if (member == null) {
			log.info("이거 뭐라고 뜨는건데:{}",member);
			return "redirect:/";
		}
		postService.savePost(post, member);
		return "redirect:/main";
	} 

}
