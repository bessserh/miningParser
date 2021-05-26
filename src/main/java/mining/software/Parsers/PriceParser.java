package mining.software.Parsers;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

/*
hotline search
pagination problem !!!
*/

public class PriceParser {

    public String parserPrice() {

        StringBuilder sb = new StringBuilder();
        Document doc = null;

        try {
            doc = Jsoup.connect(
                    "https://hotline.ua/computer/videokarty/380252-560507-586469-606235-612197-643445-646330/")
                        //hotline filter for mining suitable GPUs
                    .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) " +
                            "AppleWebKit/537.36 (KHTML, like Gecko) " +
                            "Chrome/90.0.4430.212 " +
                            "Safari/537.36")
                    .referrer("https://www.google.com")
                    .get();
        } catch (IOException e) {
            e.printStackTrace(); //logger
        }

        //TODO find correct selector
        Elements listGpu = doc.select("ul.products-list.cell-list");

        for(Element el: listGpu) {
            String gpuName = el.select(
                    "li.product-item:nth-child(1) > div:nth-child(3) > p:nth-child(1) > a:nth-child(1)").text();
            String price = el.select(
                    "li.product-item:nth-child(1) > div:nth-child(4) > div:nth-child(1) > div:nth-child(1) > span:nth-child(1)").text();
            //compare here
            String description = el.select(
                    "li.product-item:nth-child(1) > div:nth-child(3) > div:nth-child(2) > div:nth-child(2) > div:nth-child(2) > p:nth-child(1)").text();


            sb.append(gpuName).append("|").append(price).
                    append("|").append(description).append(System.lineSeparator());
        }

        return sb.toString();
    }
}
