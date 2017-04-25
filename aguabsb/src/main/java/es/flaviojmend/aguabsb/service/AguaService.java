package es.flaviojmend.aguabsb.service;

import es.flaviojmend.aguabsb.persistence.entity.Volume;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class AguaService {


    @Cacheable(value = "volume", key = "#cacheKey")
    public List<Volume> getVolumes(String cacheKey) throws IOException {
        Document doc = Jsoup.connect("http://www.adasa.df.gov.br/monitoramento/niveis-dos-reservatorios").get();

        Elements volDescoberto = doc.select("body > main > section > div.container > div.col-lg-10 > div > div:nth-child(1) > div > div:nth-child(2) > span > table > tbody > tr:nth-child(2) > td:nth-child(2) > div");
        Elements volStaMaria = doc.select("body > main > section > div.container > div.col-lg-10 > div > div:nth-child(1) > div > div:nth-child(2) > span > table > tbody > tr:nth-child(2) > td:nth-child(4) > div");
        Elements dataHora = doc.select("body > main > section > div.container > div.col-lg-10 > div > div:nth-child(1) > div > div:nth-child(2) > span > table > tbody > tr:nth-child(5) > td");

        List<Volume> volumes = new ArrayList<>();

        for(int i=0 ; i<dataHora.size() ; i++) {
            Volume volume = new Volume();
            volume.setVolumeDescoberto(Double.parseDouble(volDescoberto.get(i).html().replace(",", ".").replace("%","")));
            volume.setVolumeStaMaria(Double.parseDouble(volStaMaria.get(i).html().replace(",", ".").replace("%","")));
            volume.setData(dataHora.get(i).childNodes().get(1).childNodes().get(1).toString().replace("&nbsp;",""));
            volume.setHora(dataHora.get(i).childNodes().get(4).toString().replace("&nbsp;",""));
            volumes.add(volume);

        }

        return volumes;
    }
}
