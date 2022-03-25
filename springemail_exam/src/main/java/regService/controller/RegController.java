package regService.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import regService.email.EmailSendService;
import regService.member.MemberVO;
import regService.member.RegService;

@Controller
public class RegController {
	@Autowired
	private RegService regService;
	
	@Autowired
	private EmailSendService mss;
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	
	@RequestMapping(value="/member/signup", method=RequestMethod.GET)
	public String handleReg (@ModelAttribute("regMemberData") MemberVO memberVO, Model model) {
		return "regForm";
	}
	
	@RequestMapping(value="/member/signup", method = RequestMethod.POST)
	public String handleReg (@Valid @ModelAttribute("regMemberData") MemberVO memberVO, BindingResult bindingResult) {
		
		if(bindingResult.hasErrors()) {
			return "regForm";
		}
		System.out.println("??" + memberVO);
		
		//패스워드 인코딩
		String encodePwd = passwordEncoder.encode(memberVO.getPwd());

		memberVO.setPwd(encodePwd);
		//db등록
		System.out.println("가입컨트롤러 " + memberVO);
		regService.signup(memberVO);
		
		
		//임의키 auth 생성 및 이메일 발송
		String auth = mss.sendAuthMail(memberVO.getEmail());
		memberVO.setAuth(auth);

		
		//db auth 업데이트
		regService.updateAuth(memberVO.getEmail(), memberVO.getAuth());
		
		return "signup/regnext";
	}
	
	@RequestMapping(value="/member/signUpConfirm")
	public String signupConfirm(String email, String auth, Model model) {	
		System.out.println("인증전\n"+email +", " + auth);
		regService.updateAuthStatus(email, auth);
		System.out.println("email 인증 완료 ");

		model.addAttribute("email", email);
		
		return "signup/authnext";
	}
	
}
