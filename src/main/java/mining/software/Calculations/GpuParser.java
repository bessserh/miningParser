package mining.software.Calculations;

import mining.software.model.GpuWeb;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GpuParser {

    public List<GpuWeb> parserGpu() {

        List<GpuWeb> gpuListShow = new ArrayList<>();
        Document doc = null;
        try {
            doc = Jsoup.connect("https://whattomine.com/gpus?cost=0.06")
                    .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:88.0) Gecko/20100101 Firefox/88.0")
                    .referrer("https://www.google.com")
                    .get();
        } catch (IOException e) {
            e.printStackTrace(); //logger
        }

        Elements listGpu = doc.select("table");

        for (Element el : listGpu.select("tr")) {

            String model = el.select(
                    "td:nth-child(1) > a:nth-child(1)").text().trim(); // model
            String allInfo = el.select(
                    "td:nth-child(3) > div:nth-child(1)").text().trim(); // all power.hash.algo
            String power = el.select(
                    "td:nth-child(3) > div:nth-child(1) > small:nth-child(1)").text().trim(); //power
            String revenue =  el.select(
                    "td:nth-child(4)").text().trim(); //revenue
            String profit = el.select(
                    "td:nth-child(5)").text().trim(); //profit

            if(model.equals("") || allInfo.equals("") || power.equals("") || revenue.equals("")
                && profit.equals("")) {
                continue;
            } else {
               gpuListShow.add(new GpuWeb(model,
                       RegexpConverter.doubleConverter(allInfo),
                       RegexpConverter.measurement(allInfo),
                       RegexpConverter.algorithm(allInfo),
                       RegexpConverter.intConverter(power),
                       RegexpConverter.doubleConverter(revenue),
                       RegexpConverter.doubleConverter(profit)));
            }
        }

    return gpuListShow;
    }
}