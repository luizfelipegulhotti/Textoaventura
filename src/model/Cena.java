package model;

import java.util.List;

public class Cena {
    private Integer id_cenas;
    private String descricaoCenas;
    private List<Item> itens;

    public Integer getId_cenas() {
        return id_cenas;
    }

    public void setId_cenas(Integer id_cenas) {
        this.id_cenas = id_cenas;
    }

    public String getDescricaoCenas() {
        return descricaoCenas;
    }

    public void setDescricaoCenas(String descricaoCenas) {
        this.descricaoCenas = descricaoCenas;
    }

    public List<Item> getItens() {
        return itens;
    }

    public void setItens(List<Item> itens) {
        this.itens = itens;
    }

    @Override
    public String toString() {
        return "Cena{" +
                "id_cenas=" + id_cenas +
                ", descricaoCenas='" + descricaoCenas + '\'' +
                ", itens=" + itens +
                '}';
    }
}
