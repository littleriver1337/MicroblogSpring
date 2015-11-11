package com.ironyard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

/**
 * Created by MattBrown on 11/9/15.
 */
@Controller
public class ControllerMain {
    //ArrayList<Message> messages = new ArrayList<>();
    @Autowired
    MessageRepository messages;

    @RequestMapping("/")
    public String home(Model model, HttpServletRequest request){
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        String password = (String) session.getAttribute("password");
        model.addAttribute("username", username);
        model.addAttribute("messages", messages.findAll());
        model.addAttribute("password", password);
        return "home";
    }
    @RequestMapping("/login")
    public String login(HttpServletRequest request, String username, String password) {
        HttpSession session = request.getSession();
        session.setAttribute("username", username);
        session.setAttribute("password", password);
        return "redirect:/";
    }
    @RequestMapping("/add-message")
    public String addMessage(String msgtext){
        Message message = new Message();
        message.text = msgtext;
        messages.save(message);
        return "redirect:/";
    }
    @RequestMapping("/delete-message")
    public String deleteMessage(Integer id){
        Message message = messages.findOne(id);
        message.id = id;
        messages.delete(id);
        return "redirect:/";
    }
    @RequestMapping("/edit")
    public String edit(Model model, Integer id){
        Message message = messages.findOne(id);
        model.addAttribute("message", message);
        messages.save(message);
        return "edit";
    }
    @RequestMapping("edit-message")
    public String editMessage(Integer id, String msgtext){
        Message message = messages.findOne(id);
        if (message != null){
            message.text = msgtext;

        }
        messages.save(message);
        return "redirect:/";

    }

}
