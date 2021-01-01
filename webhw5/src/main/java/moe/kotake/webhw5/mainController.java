package moe.kotake.webhw5;

import moe.kotake.webhw5.dao.contactRepository;
import moe.kotake.webhw5.contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@Controller
public class mainController {
    private Long id = Long.valueOf(0);
    private String u_name;
    private contactRepository contactRepos;

    @Autowired
    void setContactRepos(contactRepository contactRepos)
    {
        this.contactRepos = contactRepos;
    }

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
    public ModelAndView index(Model model,
                              @RequestParam(value = "start",defaultValue = "0") Integer start,
                              @RequestParam(value = "limit",defaultValue = "3") Integer limit) {
        start = start<0?0:start;
        Sort sort = Sort.by(Sort.Direction.DESC,"id");
        Pageable pageable = PageRequest.of(start,limit,sort);
        Page<contact> contactList = contactRepos.findAll(pageable);
        model.addAttribute("contact", contactList);
        model.addAttribute("username", u_name);
        ModelAndView mav = new ModelAndView("contact_main", "contactModel", model);
        return mav;
    }

    /*-----delete-----*/
    @PostMapping(value = "/delete/{num}")
    public String delete(@PathVariable("num") int id) {
        contactRepos.deleteById((long) id);
        return "redirect:/contact_main";
    }

    /*-----add-----*/
    @RequestMapping("/contact_add")
    public String Add(Model model) {
        id++;
        model.addAttribute("one", new contact((long) id));
        return "contact_add";
    }

    @PostMapping(value = "/contact_add/post")
    public String add(contact temp) {
        temp.id = id;
        id++;
        System.out.println(temp.name);
        System.out.println(temp.addr);
        System.out.println(temp.id);
        System.out.println(temp.bir);
        System.out.println(temp.email);
        System.out.println(temp.tel);
        System.out.println(temp.qq);
        contact ta = new contact(temp.id,temp.name,temp.tel,temp.email,temp.qq,temp.addr,temp.bir);
        contactRepos.save(ta);
        return "redirect:/contact_main";
    }

    @RequestMapping(value = "/contact_add/check_phone")
    public @ResponseBody
    void check_phone(HttpServletRequest request, HttpServletResponse response)
    {
        int flag = 1;
        List<contact> findC = contactRepos.findByTel(request.getParameter("now_tel"));
        if(findC.isEmpty())
        {
            flag = 1;
        }
        try {
            response.getWriter().write(String.valueOf(flag));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /*-----change-----*/
    @GetMapping(value = "/change/{num}")
    public ModelAndView change(@PathVariable("num") int id, Model model) {
        Optional<contact> contactOptional = contactRepos.findById((long) id);
        if(contactOptional.isPresent())
        {
            contact con = contactOptional.get();
            model.addAttribute("one", con);
        }
        ModelAndView mav = new ModelAndView("change", "contactModel", model);
        return mav;
    }

    @PostMapping(value = "/change/post/{num}")
    public String changepost(@PathVariable("num") int id, contact con, Model model) {
        contactRepos.deleteById((long) id);
        contactRepos.save(con);
        return "redirect:/contact_main";
    }
}
