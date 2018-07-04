package AnaylzeMyFace.Service;

import com.ibm.watson.developer_cloud.service.security.IamOptions;
import com.ibm.watson.developer_cloud.visual_recognition.v3.VisualRecognition;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.DetectFacesOptions;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.DetectedFaces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class AMFService {
    @Autowired
    RestTemplate restTemplate;

    public DetectedFaces faceFacts(String image){
        String apikey = "XTK4tyF63bMdIQ0PwUzoYXdJE2NRzO7dx0ObiZ7QcVVu";
        IamOptions options = new IamOptions.Builder().apiKey(apikey).build();
        VisualRecognition service = new VisualRecognition("2018-03-19", options);
        DetectFacesOptions detectFacesOptions = new DetectFacesOptions.Builder().url(image).build();
        DetectedFaces result = service.detectFaces(detectFacesOptions).execute();

        /*String url = "https://gateway.watsonplatform.net/visual-recognition/api/v3/detect_faces?version=2018-03-19&url=" + image;

        DetectedFaces result = restTemplate.getForObject(url, DetectedFaces.class);*/
        return result;
    }
}
