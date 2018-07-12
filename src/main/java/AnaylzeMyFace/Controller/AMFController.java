package AnaylzeMyFace.Controller;


import AnaylzeMyFace.Service.AMFService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/analyzemyface")
public class AMFController {
    @Autowired
    AMFService amfService;

    @RequestMapping("/")
    public ModelAndView home(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("home");
        return modelAndView;
    }

    @RequestMapping("/json")
    public com.ibm.watson.developer_cloud.visual_recognition.v3.model.DetectedFaces faceFacts(@RequestParam(value="url") String url){
        return  amfService.faceFacts(url);
    }

}
