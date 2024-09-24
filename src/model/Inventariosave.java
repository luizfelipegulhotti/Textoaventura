package model;

public class Inventariosave {
    private Integer id_inventory;
    private Cena id_cena_atual;

    public Inventariosave(Integer id_inventory, Cena id_cena_atual) {
        this.id_inventory = id_inventory;
        this.id_cena_atual = id_cena_atual;
    }

    public Inventariosave() {

    }

    public Integer getId_inventory() {
        return id_inventory;
    }

    public void setId_inventory(Integer id_inventory) {
        this.id_inventory = id_inventory;
    }

    public Cena getId_cena_atual() {
        return id_cena_atual;
    }

    public void setId_cena_atual(Cena id_cena_atual) {
        this.id_cena_atual = id_cena_atual;
    }

    @Override
    public String toString() {
        return "Inventariosave{" +
                "id_inventory=" + id_inventory +
                ", id_cena_atual=" + id_cena_atual +
                '}';
    }
}
