package com.myimooc.jqueryqrcode;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DemoController {
	
	@GetMapping(value={"","/"})
	public ModelAndView qrcode(){
		return new ModelAndView("/qrcode");
	}
	
}
