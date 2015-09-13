package org.sujit.git.resumebuilder.config;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.sujit.git.resumebuilder.model.GitRepositry;
import org.sujit.git.resumebuilder.model.UserInfo;
import org.sujit.git.resumebuilder.service.ResumeBuilderService;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@SuppressWarnings("unchecked")
public class ResumeBuilderController {
	
	@Autowired
	private ResumeBuilderService resumeBuilderService;

	@RequestMapping("/")
	public String home() {
		return "home";
	}
	
	@RequestMapping(value="/generateResume", method=RequestMethod.POST)
	public ModelAndView generateResume(@RequestParam String userName, RedirectAttributes redirectAttributes) {
		String view = "redirect:/";
		final Map<String, Object> model = new HashMap<String, Object>();
		try {
			 UserInfo userInfo = resumeBuilderService.getUserLanguages(userName);
			System.out.println(userInfo);
			model.put("userInfo", userInfo);
			view = "resume";
		} catch (HttpStatusCodeException e) {
			try {
				String message = ((Map<String, String>) new ObjectMapper().readValue(e.getResponseBodyAsByteArray(), new TypeReference<HashMap<String,String>>(){})).get("message");
				redirectAttributes.addFlashAttribute("message", (message == null || message.trim().isEmpty())? e.getStatusText() : message);
			} catch (IOException ioException) {
				redirectAttributes.addFlashAttribute("message", e.getStatusText());
			}
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("message", e.getMessage());
		}
		return new ModelAndView(view, model);
	}
	
	@RequestMapping(value = "/{userName}/selLanguage/{lang}", method = RequestMethod.GET)
	public String selectedLanguage(Model model, @PathVariable("userName") String userName, @PathVariable("lang") String lang) {
		UserInfo userInfo = resumeBuilderService.getUserLanguages(userName);
		Map<String, GitRepositry> gitRepos = new HashMap<String, GitRepositry>(userInfo.getGitRepositries()); 
		gitRepos.keySet().retainAll(userInfo.getLanguages().get(lang));
		model.addAttribute("repositries", gitRepos.values());
		model.addAttribute("selLanguage", lang);
		return "resume :: selLanguage";
	}
	
	@RequestMapping("/*")
	public String redirectHome(RedirectAttributes redirectAttributes) {
		redirectAttributes.addFlashAttribute("message", "Requested Page is not available");
		return "redirect:/";
	}
	
	@ExceptionHandler(Exception.class)
	public ModelAndView handleError(HttpServletRequest req, Exception exception) {
		final Map<String, Object> model = new HashMap<String, Object>();
		exception.printStackTrace();
		model.put("url", req.getRequestURL());
		model.put("exception", exception);
		System.out.println(model);
		return new ModelAndView("error", model);
	}
}
