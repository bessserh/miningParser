package mining.software.controller;

import mining.software.Calculations.Calc;
import mining.software.model.Gpu;
import mining.software.model.StartData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ManualCalcController {

    private final StartData st = new StartData();
    private final Gpu gpu = new Gpu();
    private Calc calculate;

    @GetMapping("/manual")
    public String mainPage(Model model) {
        model.addAttribute("startData", st);
        return "manual";
    }

    @PostMapping("/manual")
    public String postMain(@RequestParam("kw") Double kw,
                           @RequestParam("mh") Double mh,
                           @RequestParam("fee") Double fee) {
        st.setDailyProfit(mh);
        st.setPricePerKw(kw);
        st.setAllFees(fee);

        return "redirect:/manual/gpu";
    }

    @GetMapping("/manual/gpu")
    public String gpuPage(Model model){
        model.addAttribute("gpu", gpu);
        model.addAttribute("startData", st);
        return "gpuInit";
    }

    @PostMapping("/manual/gpu")
    public String initGpu(@RequestParam("product") String name,
                          @RequestParam("price") double price,
                          @RequestParam("hashrate") double hashrate,
                          @RequestParam("power") int power) {

        gpu.setName(name);
        gpu.setPrice(price);
        gpu.setHashrate(hashrate);
        gpu.setPowerConsumption(power);

        return "redirect:result";
    }

    @GetMapping("/manual/result")
    public String result(Model model) {
        model.addAttribute("gpu", gpu);
        model.addAttribute("startData", st);
        calculate = new Calc(st, gpu);

        model.addAttribute("calculate", calculate);

        return "result";
    }
}
