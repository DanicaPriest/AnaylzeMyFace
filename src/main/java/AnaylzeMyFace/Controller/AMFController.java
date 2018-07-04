package AnaylzeMyFace.Controller;

import AnaylzeMyFace.Model.DetectedFaces;
import AnaylzeMyFace.Service.AMFService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("analyzemyface/")
public class AMFController {
    @Autowired
    AMFService amfService;

    @RequestMapping("/")
    public DetectedFaces faceFacts(@RequestParam(value="url") String url){
        return amfService.faceFacts(url);
    }

}
