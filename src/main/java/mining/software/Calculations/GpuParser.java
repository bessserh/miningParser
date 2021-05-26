package mining.software.Calculations;

import mining.software.model.GpuWeb;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


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

            String model = el.select("td:nth-child(1) > a:nth-child(1)").text().trim(); // model
            String info = el.select("td:nth-child(3) > div:nth-child(1)").text().trim(); // all power and hash
            String power = el.select("td:nth-child(3) > div:nth-child(1) > small:nth-child(1)").text().trim();
            power = power.replaceAll("\\D+","");
            String revenue =  el.select("td:nth-child(4)").text().trim(); //revenue
            String profit = el.select("td:nth-child(5)").text().trim(); //profit

            if(model.equals("") || info.equals("") || power.equals("") || revenue.equals("")
                && profit.equals("")) {
                continue;
            } else {
               gpuListShow.add(new GpuWeb(model, info, power, revenue, profit));
            }
        }

    return gpuListShow;
    }
}


// todo all this below
            /*
            matcher cant find double WHY? IllegPointExc
            Pattern pattern = Pattern.compile("[0-9]{1,}[,.][0-9]{1,}");
            Matcher matcher = pattern.matcher(hashrate);
            //String power = el.select("td:nth-child(3) > div:nth-child(1) > small:nth-child(1)").text();
            //power = power.replaceAll("\\D+","")
            */
