package com.myimooc.qrcode.jquery;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 控制层
 *
 * @author zc 2017-06-23
 */
@Controller
public class DemoController {

    @GetMapping(value = {"", "/"})
    public ModelAndView qrcode() {
        return new ModelAndView("/qrcode");
    }
}
