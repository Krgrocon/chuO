package DSA.chuO.controller;

import DSA.chuO.repositroy.MemberRepositroy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import DSA.chuO.model.Member;
import DSA.chuO.service.MemberService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RequiredArgsConstructor
@Controller
public class MemberController {

	private final MemberService memberService;

	// 회원가입처리 부분
	@GetMapping("/register")
	public String MemberRegister() {

		return "/register";
	}



	// 로그인 처리
	@PostMapping("/login")
	public String processLogin(@RequestParam("email") String email, @RequestParam("password") String password,
			Model model, HttpSession session) {
		Member findMember = memberService.findUserId(email);
		System.out.println("findMember: " + findMember);

		if (findMember != null && findMember.getPassword().equals(password)) {
			model.addAttribute("member", findMember);
			log.info("이거진짜뭐라고 뜨는데{} ", findMember);
			session.setAttribute("loginMember", findMember);
			return "redirect:/";
		} else {
			model.addAttribute("error", "잘못된 접근 방식입니다");
			return "redirect:/";
		}
	}


	@PostMapping("/register")
	public ResponseEntity<Map<String, Object>> register(@RequestBody Member form) {
		Map<String, Object> response = new HashMap<>();
		Member member = form;
		System.out.println("gdgd");
		System.out.println(member);

		boolean isEmailVerified = memberService.MemberEmailVerification(member.getEmail());
		System.out.println("isEmailVerified: " + isEmailVerified);
		if(isEmailVerified) {
			response.put("success", false);
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}
		try {
			memberService.registerMember(member);
			response.put("success", true);
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (IllegalStateException e) {
			response.put("success", false);
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}


	// 로그아웃 처리
	@PostMapping("/logout")
	public String processLogOut(HttpSession session) {
		session.removeAttribute("loginMember");
//		log.info("member{}",session);
		return "redirect:/";
	}

	@GetMapping("/main")
	public String showMainPage(HttpSession session, Model model) {
		Member loggedInUser = (Member) session.getAttribute("member");
		if (loggedInUser != null) {
			model.addAttribute("loggedInUser", loggedInUser);
			log.info("loggedInUser:{}", loggedInUser);
			return "/main";
		} else {
			return "redirect:/";
		}
	}

}
