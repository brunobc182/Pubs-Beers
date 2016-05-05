package br.com.hugo.pubsbeer;

import java.io.Serializable;


public class Bar implements Serializable {
    private String nome;
    private String endereco;
    private int[] cervejas;

    public Bar(String nome, String endereco, int... cervejas) {
        this.nome = nome;
        this.endereco = endereco;
        this.cervejas = cervejas;
    }

    public Bar() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int[] getCervejas() {
        return cervejas;
    }

    public void setCervejas(int[] cervejas) {
        this.cervejas = cervejas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Bar bar = (Bar) o;

        return nome.equals(bar.nome);

    }

    @Override
    public int hashCode() {
        return nome.hashCode();
    }
}
