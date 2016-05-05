package br.com.hugo.pubsbeer;

/**
 * Created by rk on 04/05/2016.
 */
public class Cerveja {
    private String nome;
    private String origem;
    private String tipo;
    private int[] bares;

    public Cerveja(String nome, String origem, String tipo, int... bares) {
        this.nome = nome;
        this.origem = origem;
        this.tipo = tipo;
        this.bares = bares;
    }

    public Cerveja() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int[] getBares() {
        return bares;
    }

    public void setBares(int[] bares) {
        this.bares = bares;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cerveja cerveja = (Cerveja) o;

        return nome != null ? nome.equals(cerveja.nome) : cerveja.nome == null;

    }

    @Override
    public int hashCode() {
        return nome != null ? nome.hashCode() : 0;
    }
}
