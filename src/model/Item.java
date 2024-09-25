package model;

public class Item {
    private Integer id_itens;
    private String nome;
    private String descricaoItens;
    private String descricao_Positiva;
    private String descricao_Negativa;
    private String comando_correto;
    private Integer cena_Atual;
    private Integer proxima_Cena;

    public Integer getId_itens() {
        return id_itens;
    }

    public void setId_itens(Integer id_itens) {
        this.id_itens = id_itens;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao_Positiva() {
        return descricao_Positiva;
    }

    public void setDescricao_Positiva(String descricao_Positiva) {
        this.descricao_Positiva = descricao_Positiva;
    }

    public String getDescricao_Negativa() {
        return descricao_Negativa;
    }

    public void setDescricao_Negativa(String descricao_Negativa) {
        this.descricao_Negativa = descricao_Negativa;
    }

    public String getComando_correto() {
        return comando_correto;
    }

    public void setComando_correto(String comando_correto) {
        this.comando_correto = comando_correto;
    }

    public Integer getCena_Atual() {
        return cena_Atual;
    }

    public void setCena_Atual(Integer cena_Atual) {
        this.cena_Atual = cena_Atual;
    }

    public Integer getProxima_Cena(int proximaCena) {
        return proxima_Cena;
    }

    public void setProxima_Cena(Integer proxima_Cena) {
        this.proxima_Cena = proxima_Cena;
    }

    public String getDescricaoItens() {
        return descricaoItens;
    }

    public void setDescricaoItens(String descricaoItens) {
        this.descricaoItens = descricaoItens;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id_itens=" + id_itens +
                ", nome='" + nome + '\'' +
                ", descricaoItens='" + descricaoItens + '\'' +
                ", descricao_Positiva='" + descricao_Positiva + '\'' +
                ", descricao_Negativa='" + descricao_Negativa + '\'' +
                ", comando_correto='" + comando_correto + '\'' +
                ", cena_Atual=" + cena_Atual +
                ", proxima_Cena=" + proxima_Cena +
                '}';
    }
}
