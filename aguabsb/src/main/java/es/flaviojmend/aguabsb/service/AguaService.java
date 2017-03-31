package es.flaviojmend.aguabsb.service;

import es.flaviojmend.aguabsb.persistence.entity.Volume;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class AguaService {

//    @Autowired
//    CrazyAirRepository repository;


    public List<Volume> getVolumes() throws IOException {
        Document doc = Jsoup.connect("http://www.adasa.df.gov.br/monitoramento/niveis-de-reservatorios/historico").get();
        Elements document = doc.select("div[itemprop$=articleBody]");

        Elements datas = doc.select("body > main > section > div.container.paginas-internas > div.col-lg-10 > div.item-page > div > table > tbody > tr:nth-child(5) > td > p");
        Elements volDescoberto = doc.select("body > main > section > div.container.paginas-internas > div.col-lg-10 > div.item-page > div > table > tbody > tr:nth-child(2) > td:nth-child(2) > div");
        Elements volStaMaria = doc.select("body > main > section > div.container.paginas-internas > div.col-lg-10 > div.item-page > div > table > tbody > tr:nth-child(2) > td:nth-child(4) > div");
        Elements dataHora = doc.select("body > main > section > div.container.paginas-internas > div.col-lg-10 > div.item-page > div > table > tbody > tr:nth-child(5) > td");

        List<Volume> volumes = new ArrayList<>();

        for(int i=0 ; i<datas.size() ; i++) {
            Volume volume = new Volume();
            volume.setData(datas.get(i).html().replace("<strong>Data:</strong>&nbsp;",""));
            volume.setVolumeDescoberto(Double.parseDouble(volDescoberto.get(i).html().replace(",", ".").replace("%","")));
            volume.setVolumeStaMaria(Double.parseDouble(volStaMaria.get(i).html().replace(",", ".").replace("%","")));
            volume.setDataHora(dataHora.get(i).childNodes().get(4).toString().replace("&nbsp;",""));

            volumes.add(volume);

        }


        return volumes;
    }
}
