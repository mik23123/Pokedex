public class pokemon {
    int identificativo;
    String nome ;
    String tipo1;
    String tipo2;
    float altezza;
    float peso;

    public void setIdentificativo(int identificativo) {
        this.identificativo = identificativo;
    }

    @Override
    public String toString() {
        return "pokemon{" +
                "identificativo=" + identificativo +
                ", nome='" + nome + '\'' +
                ", tipo1='" + tipo1 + '\'' +
                ", tipo2='" + tipo2 + '\'' +
                ", altezza=" + altezza +
                ", peso=" + peso +
                '}';
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTipo1(String tipo1) {
        this.tipo1 = tipo1;
    }

    public void setTipo2(String tipo2) {
        this.tipo2 = tipo2;
    }

    public void setAltezza(float altezza) {
        this.altezza = altezza;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public int getIdentificativo() {
        return identificativo;
    }

    public float getPeso() {
        return peso;
    }

    public float getAltezza() {
        return altezza;
    }

    public String getTipo2() {
        return tipo2;
    }

    public String getTipo1() {
        return tipo1;
    }

    public String getNome() {
        return nome;
    }
}
