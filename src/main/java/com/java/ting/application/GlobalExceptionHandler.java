package com.java.ting.application;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * 统一异常管理
 * @author TingOu
 */
@Controller
@Slf4j
public class GlobalExceptionHandler implements ErrorController {

    @Override
    public String getErrorPath() {
        // 出现异常时跳到 @RequestMapping("/error") 进行处理
        return "/error";
    }

    @RequestMapping("/error")
    public String handleError(HttpServletRequest request, Exception e) {
        //获取statusCode:401,404,500
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        if (statusCode == 401) {
            return "errorPage/401";
        } else if (statusCode == 404) {
            return "errorPage/404";
        } else if (statusCode == 403) {
            return "errorPage/403";
        } else {
            return "errorPage/500";
        }

    }


//    @ExceptionHandler(value = Exception.class)
//    public String defaultErrorHandler(HttpServletRequest req, Exception e, Model model) throws Exception {
//        Map<String, Object> errorMap = new HashMap<String, Object>();
//        errorMap.put("exception", e);
//        errorMap.put("url", req.getRequestURL());
//        System.out.println("错误提示：：---" + e);
//        model.addAttribute("exception", e);
//        return "errorPage/404";
//    }
//    @RequestMapping("/error")
//    public String error(){
//        return "/error/404.jsp";
//    }

}
