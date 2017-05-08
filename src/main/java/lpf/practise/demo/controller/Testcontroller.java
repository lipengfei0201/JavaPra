package lpf.practise.demo.controller;

import lpf.practise.demo.service.TestControllerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by IDEA
 * User: lipengfei.li
 * Date: 17-5-8
 * Time: 下午8:49
 * To change this： File Header
 *
 * @Description:
 */
@Controller
@RequestMapping(value = "test")
public class Testcontroller {
    @Resource
    private TestControllerService testControllerService;

    @RequestMapping(value = "/controller",method = RequestMethod.GET)
    @ResponseBody
    public void setTestControllerService(){
        testControllerService.display();
    }
}
