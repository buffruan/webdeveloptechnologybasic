package moe.kotake.webhw4;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

@Controller
public class mainController {
    private List<contact> contactList = new ArrayList<>();
    private int id = 0;
    private String u_name;

    @RequestMapping(value = {"/login", "/"}, method = RequestMethod.GET)
    public String login(String username, String password, Model model) {
        if (username != null && password != null) {
            if (Objects.equals(username, "kotake") && Objects.equals(password, "lalala")) {
                model.addAttribute("username", username);
                u_name = username;
                return "redirect:/contact_main";
            }
        }
        return "login";
    }

    @RequestMapping("/contact_main")
    public ModelAndView index(Model model) {
        model.addAttribute("contact", contactList);
        model.addAttribute("username", u_name);
        ModelAndView mav = new ModelAndView("contact_main", "contactModel", model);
        return mav;
    }

    /*-----delete-----*/
    @PostMapping(value = "/delete/{num}")
    public String delete(@PathVariable("num") int id) {
        Iterator<contact> iter = contactList.iterator();
        while (iter.hasNext()) {
            contact temp = iter.next();
            if (temp.current_id == id) {
                iter.remove();
                break;
            }
        }
        return "redirect:/contact_main";
    }

    /*-----add-----*/
    @RequestMapping("/contact_add")
    public String Add(Model model) {
        id++;
        model.addAttribute("one", new contact(id));
        return "contact_add";
    }

    @PostMapping(value = "/contact_add/post")
    public String add(contact temp) {
        contactList.add(temp);
        return "redirect:/contact_main";
    }

    /*-----change-----*/
    @GetMapping(value = "/change/{num}")
    public ModelAndView change(@PathVariable("num") int id, Model model) {
        Iterator<contact> iter = contactList.iterator();
        while (iter.hasNext()) {
            contact temp = iter.next();
            if (temp.current_id == id) {
                model.addAttribute("one", temp);
                break;
            }
        }
        ModelAndView mav = new ModelAndView("change", "contactModel", model);
        return mav;
    }

    @PostMapping(value = "/change/post/{num}")
    public String changepost(@PathVariable("num") int id, contact con, Model model) {
        int t_id = con.current_id;
        Iterator<contact> iter = contactList.iterator();
        while (iter.hasNext()) {
            contact temp = iter.next();
            if (temp.current_id == t_id) {
                Collections.replaceAll(contactList, temp, con);
                break;
            }
        }
        return "redirect:/contact_main";
    }
}
