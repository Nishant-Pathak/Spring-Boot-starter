package rs.pscode.pomodorofire.web.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WebResource {
  @RequestMapping(value = "/open/signup", method = RequestMethod.GET)
  @ResponseBody
  public ModelAndView signupPage() {
    return new ModelAndView("signup");
  }

  @RequestMapping(value = "/", method = RequestMethod.GET)
  @ResponseBody
  public ModelAndView indexPage() {
    return new ModelAndView("index");
  }

}
