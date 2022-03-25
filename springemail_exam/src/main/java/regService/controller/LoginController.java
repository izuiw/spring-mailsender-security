package regService.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	
	
	@RequestMapping(value="/member/login", method=RequestMethod.GET)
	public String handleLogin(@ModelAttribute("loginMemberData") LoginCommand logincommand) {
		return "loginForm";
	}
	
	@RequestMapping(value="/member/login", method=RequestMethod.POST)
	public String handleLogin(@Valid @ModelAttribute("loginMemberData") LoginCommand command, BindingResult bindingResult,HttpSession session, Model model) {
		
		if(bindingResult.hasErrors()) {
			return "loginForm";
		}
		
		MemberVO memberVO = loginService.login(command.getId());
		
		String password = command.getPwd();
		String encodePassword = memberVO.getPwd();
		
		boolean pwdEncode= passwordEncoder.matches(password, encodePassword);
		//System.out.println("로그인 컨트롤러  : " + pwdEncode);
		
		if(memberVO != null && pwdEncode) {
			System.out.println("로그인 성공 : " + memberVO);
			session.setAttribute("memberVO", memberVO);	
			return "main";
		} else {
			System.out.println("로그인 정보 없음 or 비밀번호 불일치 : " + memberVO);
			model.addAttribute("msg", "해당 회원 정보가 없습니다.");
			return "loginForm";
		}
		
		
		
	}
 	
	

}
