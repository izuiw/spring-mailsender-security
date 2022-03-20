package regService.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import regService.member.LoginCommand;
import regService.member.LoginService;
import regService.member.MemberVO;

@Controller
public class LoginController {
	
	@Autowired
	LoginService loginService;
	
	@RequestMapping(value="/member/login", method=RequestMethod.GET)
	public String handleLogin(@ModelAttribute("loginMemberData") LoginCommand logincommand) {
		return "loginForm";
	}
	
	@RequestMapping(value="/member/login", method=RequestMethod.POST)
	public String handleLogin(@Valid @ModelAttribute("loginMemberData") LoginCommand command, BindingResult bindingResult,HttpSession session, Model model) {
		
		if(bindingResult.hasErrors()) {
			return "loginForm";
		}
		
		MemberVO memberVO = loginService.login(command.getId(), command.getPwd());

		if(memberVO != null) {
			System.out.println("로그인 성공 : " + memberVO);
			session.setAttribute("memberVO", memberVO);	
			return "signup/loginnext";
		} else {
			System.out.println("로그인 정보 없음 or 비밀번호 불일치 : " + memberVO);
			model.addAttribute("msg", "해당 회원 정보가 없습니다.");
			return "loginForm";
		}
		
		
		
	}
 	
	

}
