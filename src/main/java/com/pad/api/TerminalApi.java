package com.pad.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author myl
 * Created by Administrator on 2017/7/16 0016.
 */
@Controller
@RequestMapping("/terminal")
public class TerminalApi {

    @RequestMapping("/terminal")
    public Object login() {
        return null;
    }
}
