package net.n1books.dev.miniproj;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.watson.developer_cloud.conversation.v1.Conversation;
import com.ibm.watson.developer_cloud.conversation.v1.model.Context;
import com.ibm.watson.developer_cloud.conversation.v1.model.InputData;
import com.ibm.watson.developer_cloud.conversation.v1.model.MessageOptions;
import com.ibm.watson.developer_cloud.conversation.v1.model.MessageResponse;

@RestController
@RequestMapping("projTest")
public class ChatbotController {
private static final Logger logger = LoggerFactory.getLogger(ChatbotController.class);
	
	@RequestMapping("watsonsay")
	public MessageResponse watsonsay(String isay, HttpSession session) {
		logger.info("user input : " + isay );
		//가장 최신 버젼으로 가져옴.
		Conversation service = new Conversation(Conversation.VERSION_DATE_2017_05_26);
		service.setUsernameAndPassword("{id}", "{pw}");
		
		MessageOptions options = null;
		if (!isay.equals("")) {
			options = new MessageOptions.Builder(
					"{workspace}")
					.input(new InputData.Builder(isay).build())
					//기존의 context를 빼와서 (없으면 null)
					//build함. 해당 내용을 아래에서 다시 context객체로 session저장
					.context((Context)session.getAttribute("context"))
					.build();
		} else {
			//공백이 넘어왔을 때는 세션 유지하지 않고 재시작.
			options = new MessageOptions.Builder(
					"{workspace}")
					.input(new InputData.Builder(isay).build())
					.build();
		}
		MessageResponse response = service.message(options).execute();
		session.setAttribute("context", response.getContext());
		String watsonsay = response.getOutput().getText().get(0);
		
		logger.info("watson : " + watsonsay.toString());
		return response;
				
	}
}
