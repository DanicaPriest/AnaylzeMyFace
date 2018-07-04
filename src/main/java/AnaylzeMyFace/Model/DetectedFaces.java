package AnaylzeMyFace.Model;

public class DetectedFaces {
    int images_processed;
    Images[] images;

    public Images[] getImages() {
        return images;
    }

    public void setImages(Images[] images) {
        this.images = images;
    }

    public int getImages_processed() {
        return images_processed;
    }

    public void setImages_processed(int images_processed) {
        this.images_processed = images_processed;
    }
}
