package be.thomasmore.travelmore.controller;

import java.util.List;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

@ManagedBean
public class ImagesView {

    private List<String> images;

    @PostConstruct
    public void init() {
        images = new ArrayList<String>();
        for (int i = 1; i <= 5; i++) {
            images.add("reis" + i + ".jpg");
        }
    }

    public List<String> getImages() {
        return images;
    }
}
