package es.flaviojmend.aguabsb.persistence.entity;

/**
 * Created by flavio on 30/03/17.
 */
public class Volume {


    private String data;
    private String dataHora;
    private Double volumeDescoberto;
    private Double volumeStaMaria;

    public String getData() {
        return data;
    }

    public Volume setData(String data) {
        this.data = data;
        return this;
    }

    public String getDataHora() {
        return dataHora;
    }

    public Volume setDataHora(String dataHora) {
        this.dataHora = dataHora;
        return this;
    }

    public Double getVolumeDescoberto() {
        return volumeDescoberto;
    }

    public Volume setVolumeDescoberto(Double volumeDescoberto) {
        this.volumeDescoberto = volumeDescoberto;
        return this;
    }

    public Double getVolumeStaMaria() {
        return volumeStaMaria;
    }

    public Volume setVolumeStaMaria(Double volumeStaMaria) {
        this.volumeStaMaria = volumeStaMaria;
        return this;
    }
}
