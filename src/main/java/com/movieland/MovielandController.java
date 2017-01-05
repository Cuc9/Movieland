package com.movieland;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by arpi on 05.01.2017.
 */
@Controller
@RequestMapping("/v1")
public class MovielandController {
    @RequestMapping(method = RequestMethod.GET)
    public void index() {
        //Here I must call index.jsp
    }


}
