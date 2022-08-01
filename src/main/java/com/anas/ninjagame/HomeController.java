package com.anas.ninjagame;

import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class HomeController {
	

    public int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

	
	@RequestMapping("/")
	public String start(){
		return "redirect:/ninga";
	}
	@RequestMapping("/ninga")
	public String index(HttpSession session, Model model) {
        if (session.getAttribute("gold") == null){
		 session.setAttribute("gold",0);
		 ArrayList<String> messages = new ArrayList<String>();
		 session.setAttribute("messages", messages);
        }
        model.addAttribute("gold",(int)session.getAttribute("gold"));
		ArrayList<String> getmessage = (ArrayList<String>)session.getAttribute("messages");
        model.addAttribute("messages", getmessage);
        return "index.jsp";
        }
	
	@PostMapping("/findgold")
	public String count(HttpSession session, @RequestParam(value="location")String location) {
		if (location.equals("farm")) {
			int random = getRandomNumber(10,20);
			session.setAttribute("gold",(int) session.getAttribute("gold")+ random);
			if (random >0) {
				ArrayList<String> getmessage = (ArrayList<String>)session.getAttribute("messages");
				getmessage.add("you enterd a farm and earnd " + random + " gold " + new Date().toString());
				session.setAttribute("messages", getmessage);
			}
			return "redirect:/";
		}
		else if (location.equals("cave")) {
			int random = getRandomNumber(5,10);
			session.setAttribute("gold",(int) session.getAttribute("gold")+ random);
			if (random >0) {
				ArrayList<String> getmessage = (ArrayList<String>)session.getAttribute("messages");
				getmessage.add("you enterd a cave and earnd " + random + " gold " + new Date().toString());
				session.setAttribute("messages", getmessage);
			}
			return "redirect:/";
		}
		else if (location.equals("house")) {
			int random = getRandomNumber(2,5);
			session.setAttribute("gold",(int) session.getAttribute("gold")+ random);
			if (random >0) {
				ArrayList<String> getmessage = (ArrayList<String>)session.getAttribute("messages");
				getmessage.add("you enterd a house and earnd " + random + " gold " + new Date().toString());
				session.setAttribute("messages", getmessage);
			}
			return "redirect:/";
		}
		else if (location.equals("casino")) {
			int random = getRandomNumber(-50,50);
			session.setAttribute("gold",(int) session.getAttribute("gold")+ random);
			if (random >0) {
				ArrayList<String> getmessage = (ArrayList<String>)session.getAttribute("messages");
				getmessage.add("you enterd a casino and earnd " + random + " gold " + new Date().toString());
				session.setAttribute("messages", getmessage);
			}
			else {
				ArrayList<String> getmessage = (ArrayList<String>)session.getAttribute("messages");
				getmessage.add("you enterd a casino and lose " + random + " gold " + new Date().toString());
				session.setAttribute("messages", getmessage);
				}
			return "redirect:/";
			}
		return "redirect:/";		
	}

	@RequestMapping("/playagain")
    public String delet(HttpSession session){
        session.removeAttribute("gold");
        return "redirect:/";
    	}
}
	
