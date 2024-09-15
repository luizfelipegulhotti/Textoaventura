package model;

public class Save {
    private Integer id_save;
    private Cena cenaAtual;
    private Inventariosave inventarioAtual;

    public Save(Integer id_save, Cena cenaAtual, Inventariosave inventarioAtual) {
        this.id_save = id_save;
        this.cenaAtual = cenaAtual;
        this.inventarioAtual = inventarioAtual;
    }

    public Integer getId_save() {
        return id_save;
    }

    public void setId_save(Integer id_save) {
        this.id_save = id_save;
    }

    public Cena getCenaAtual() {
        return cenaAtual;
    }

    public void setCenaAtual(Cena cenaAtual) {
        this.cenaAtual = cenaAtual;
    }

    public Inventariosave getInventarioAtual() {
        return inventarioAtual;
    }

    public void setInventarioAtual(Inventariosave inventarioAtual) {
        this.inventarioAtual = inventarioAtual;
    }

    @Override
    public String toString() {
        return "Save{" +
                "id_save=" + id_save +
                ", cenaAtual=" + cenaAtual +
                ", inventarioAtual=" + inventarioAtual +
                '}';
    }
}
