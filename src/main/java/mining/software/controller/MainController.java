package mining.software.controller;

import mining.software.Parsers.GpuParser;
import mining.software.Parsers.PriceParser;
import mining.software.model.GpuWeb;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MainController {

    GpuParser gpuParser = new GpuParser();
    PriceParser priceParser = new PriceParser();

    @GetMapping("/")
    public String main() {
        return "main";
    }

    @GetMapping("/whattomine")
    public String innerLink() {
        return "redirect:https://whattomine.com/";
    }

    @GetMapping("/parsed")
    public String fromWeb(Model model) {
        List<GpuWeb> gpuWebs = gpuParser.parserGpu();
        model.addAttribute("allGpus", gpuWebs);
        return "parsed";
    }

    @GetMapping("/test")
    public String checkSelector(Model model) {
        //only one shown, hotline selector???
        model.addAttribute("testParser", priceParser.parserPrice());
        return "priceTest";
    }


}
