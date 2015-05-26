package nl.eveoh.jrebeltest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

    @Autowired
    private Environment environment;

    @Value("${testProperty2}")
    private String testValue;

    private String anotherTestValue;

    @RequestMapping(value = "/test1")
    @ResponseBody
    public String testMethod1(){
        return "Test1";
    }

    @RequestMapping(value = "/test2")
    @ResponseBody
    public String testMethod2(){
        return environment.getProperty("testProperty1");
    }

    @RequestMapping(value = "/test3")
    @ResponseBody
    public String testMethod3(){
        return testValue;
    }

    @RequestMapping(value = "/test4")
    @ResponseBody
    public String testMethod4(){
        return anotherTestValue;
    }

    public void setAnotherTestValue(String anotherTestValue) {
        this.anotherTestValue = anotherTestValue;
    }
}
