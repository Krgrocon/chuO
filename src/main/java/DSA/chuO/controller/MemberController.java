package DSA.chuO.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import DSA.chuO.model.Member;
import DSA.chuO.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Controller
public class MemberController {
	
	private final MemberService memberService;
	
	@GetMapping("/create")
	public String logForm() {
		
		return "/create";
	}
	
	@PostMapping("/create")
	public String addMember(@ModelAttribute Member member) {
		memberService.addMember(member);
		return "redirect:/";
		
	}
}
