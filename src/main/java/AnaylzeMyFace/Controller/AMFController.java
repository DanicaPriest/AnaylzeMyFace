package AnaylzeMyFace.Controller;


import AnaylzeMyFace.Service.AMFService;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.DetectedFaces;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.Face;
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

    @RequestMapping("/home")
    public ModelAndView home(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("home");
        return modelAndView;
    }
    @RequestMapping("/results")
    public ModelAndView results(){
        ModelAndView modelAndView = new ModelAndView();
        String test = "https://priestontherun.files.wordpress.com/2017/06/rock-n-roll-liverpool-2017-16.jpg";
        Face df = amfService.faceFacts(test).getImages().get(0).getFaces().get(0);
        modelAndView.addObject("gender",df.getGender().getGender() );
        modelAndView.addObject("minAge", df.getAge().getMin());
        modelAndView.addObject("maxAge", df.getAge().getMax());
        modelAndView.setViewName("result");
        return modelAndView;
    }

    @RequestMapping("/json")
    public com.ibm.watson.developer_cloud.visual_recognition.v3.model.DetectedFaces faceFacts(@RequestParam(value="url") String url){
        return  amfService.faceFacts(url);
    }

}
