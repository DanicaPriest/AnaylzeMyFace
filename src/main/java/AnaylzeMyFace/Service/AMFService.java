package AnaylzeMyFace.Service;

import AnaylzeMyFace.Model.DetectedFaces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.File;


@Service
public class AMFService {
    @Autowired
    RestTemplate restTemplate;

    public DetectedFaces faceFacts(String image){
        String apikey = "XTK4tyF63bMdIQ0PwUzoYXdJE2NRzO7dx0ObiZ7QcVVu";

        String url = "https://gateway.watsonplatform.net/visual-recognition/api/v3/detect_faces?version=2018-03-19&url=" + image;

        DetectedFaces result = restTemplate.getForObject(url, DetectedFaces.class);
        return result;
    }
}
