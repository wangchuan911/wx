package my.hehe.controller;

import org.apache.log4j.Logger;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MessageExceptionHandler {
	Logger logger = Logger.getLogger(MessageExceptionHandler.class);
	@ExceptionHandler
	public String exceptionHandler(Exception ex, Model model) {
		model.addAttribute("error", ex);
		return "error";
	}
}
