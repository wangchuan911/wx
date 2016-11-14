package my.hehe.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MessageExceptionHandler {
	@ExceptionHandler
	public String exceptionHandler(Exception ex, Model model) {
		model.addAttribute("error", ex);
		return "error";
	}
}
