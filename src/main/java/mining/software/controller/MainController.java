package mining.software.controller;


import mining.software.Calculations.GpuParser;
import mining.software.model.GpuWeb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.LinkedList;
import java.util.List;

@Controller
public class MainController {


    GpuParser gpuParser = new GpuParser();

    @GetMapping("/")
    public String main() {
        return "main";
    }

    @GetMapping("/whattomine")
    public String innerLink() {
        return "redirect:https://whattomine.com/";
    }

    //parse

    @GetMapping("/parsed")
    public String fromWeb(Model model) {
        List<GpuWeb> gpuWebs;
        gpuWebs = gpuParser.parserGpu();
        model.addAttribute("allGpus", gpuWebs);
        return "parsed";
    }


}
