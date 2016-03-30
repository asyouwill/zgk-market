package cn.thinkjoy.zgk.market.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by dengshaofei on 16/3/30.
 */
@Controller
@RequestMapping("/")
public class WebCotroller {

    /**
     * login
     * @return
     */
    @RequestMapping("/login")
    public ModelAndView test()
    {
        return new ModelAndView("/register/register");
    }
}
