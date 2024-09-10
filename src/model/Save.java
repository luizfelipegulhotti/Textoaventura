package model;

public class Save {
    private String id_save;

    public String getId_save() {
        return id_save;
    }

    public void setId_save(String id_save) {
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

    private Cena cenaAtual;
    private Inventariosave inventarioAtual;

    @Override
    public String toString() {
        return "Save{" +
                "id_save='" + id_save + '\'' +
                ", cenaAtual=" + cenaAtual +
                ", inventarioAtual=" + inventarioAtual +
                '}';
    }
}
