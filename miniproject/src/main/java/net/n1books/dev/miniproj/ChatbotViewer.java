package net.n1books.dev.miniproj;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("projTest")
public class ChatbotViewer {
	@RequestMapping("watsonTest")
	public String init() {
		return "projTest/watsonTest";
	}
}
