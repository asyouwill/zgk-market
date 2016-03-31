package cn.thinkjoy.zgk.market.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class WebCotroller {

    /**
     * login
     *
     * @return
     */
    @RequestMapping("/login")
    public ModelAndView test() {
        return new ModelAndView("/register/register");
    }

    /**
     * user-detail
     *
     * @return
     */
    @RequestMapping("/user-detail")
    public ModelAndView userDetail() {
        return new ModelAndView("/user-detail/user-detail");
    }

    /**
     * user-detail
     *
     * @return
     */
    @RequestMapping("/vip")
    public ModelAndView vip() {
        return new ModelAndView("/vip/vip");
    }

    /**
     * vip-check
     *
     * @return
     */
    @RequestMapping("/vip-check")
    public ModelAndView vipCheck() {
        return new ModelAndView("/vip-check/vip-check");
    }
    /**
     * vip-buy
     *
     * @return
     */
    @RequestMapping("/vip-buy")
    public ModelAndView vipBuy() {
        return new ModelAndView("/vip-buy/vip-buy");
    }

    /**
     * order
     *
     * @return
     */

    @RequestMapping("/order")
    public ModelAndView order() {
        return new ModelAndView("/order/order");
    }

    /**
     * modify-user-detail
     *
     * @return
     */
    @RequestMapping("/modify-user-detail")
    public ModelAndView modifyUserDetail() {
        return new ModelAndView("/modify-user-detail/modify-user-detail");
    }

    /**
     * find-password
     *
     * @return
     */
    @RequestMapping("/find-password")
    public ModelAndView findPassword() {
        return new ModelAndView("/find-password/find-password");
    }

    /**
     * code
     *
     * @return
     */
    @RequestMapping("/code")
    public ModelAndView code() {
        return new ModelAndView("/code/code");
    }


}
