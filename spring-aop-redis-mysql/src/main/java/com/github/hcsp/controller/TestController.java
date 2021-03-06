package com.github.hcsp.controller;

import com.github.hcsp.aspect.AspectAdvice;
import com.github.hcsp.aspect.Cache;
import com.github.hcsp.service.TestService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

@RestController
public class TestController {
    @Resource
    private TestService testService;

    @AspectAdvice
    @Cache(cacheSecond = 2)
    @RequestMapping("/")
    public ModelAndView index(HttpServletRequest request) {
        HashMap<String, Object> model = new HashMap<>();
        model.put("items", testService.getOrderRank());
        return new ModelAndView("index", model);
    }
}
