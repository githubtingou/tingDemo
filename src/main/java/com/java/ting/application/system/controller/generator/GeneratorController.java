package com.java.ting.application.system.controller.generator;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Tingou
 * @since 2019年4月29日
 */
@Controller
@RequestMapping(value = "${frontPath}/generator")
public class GeneratorController {

    @RequestMapping(value = "/generator")
    public String generatorHtml() {
        return "admin/Generator";
    }
}
