package com.five;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;

/**
 * Created by Administrator on 2016/8/24 0024.
 * 处理所提交的表单并注册新用户
 */
@Controller
@RequestMapping("/spitter")
public class SpitterController {

    private SpitterRepository spitterRepository;

    @Autowired
    public SpitterController(SpitterRepository spitterRepository) {
        this.spitterRepository = spitterRepository;
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String showRegistrationForm(Model model){
        model.addAttribute(new Spitter());
        return "registerForm";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String processRegistration(@RequestPart("profilePicture") MultipartFile profilePicture, @Valid Spitter spitter, Errors errors, RedirectAttributes model) throws IOException { //校验Spitter输入

        if (errors.hasErrors()){ //如果校验出现错误，则重新返回表单
//            return "registerForm";
        }

        //保存图片
//        profilePicture.transferTo(new File("/uploads/" + profilePicture.getOriginalFilename()));

        spitterRepository.save(spitter); //保存Spitter

        model.addAttribute("username", spitter.getUsername());
        model.addAttribute("spitterId", spitter.getUsername());
        model.addFlashAttribute("spitter", spitter); //使用flash属性传递对象
        return "redirect:/spitter/{username}"; //通过URL模板进行重定向

//        return "redirect:/spitter/" + spitter.getUsername(); //重定向到基本信息页
    }

    @RequestMapping(value = "/{username}", method = RequestMethod.GET)
    public String showSpitterProfile(@PathVariable String username, Model model){
        if (!model.containsAttribute("spitter")){
            model.addAttribute(spitterRepository.findByUsername(username));
        }
        return "profile";
    }
}
