package regService.controller;

import javax.jws.WebParam.Mode;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import regService.member.LoginCommand;
import regService.member.MemberVO;

@Controller
public class LoginController {
	
	
	
	@RequestMapping(value="/member/login", method=RequestMethod.GET)
	public String handleLogin(@ModelAttribute("loginMemberData") LoginCommand command) {
		return "loginForm";
	}
	
	@RequestMapping(value="/member/login", method=RequestMethod.POST)
	public String handleLogin(@ModelAttribute("loginMemberData") LoginCommand command, HttpSession session) {
		
		
		
		
		return "main";
	}
 	
	

}
