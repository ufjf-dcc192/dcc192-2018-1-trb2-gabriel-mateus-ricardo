package Funcionamento;

public class Participante {
    private Integer codigo;
    private String nome;
    private String email;
    private String senha;
    private Integer codigoAmigoOculto;

    public Participante(String nome, String email, String senha) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    
    
    public Participante() {
    }
    
    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }    

    public Integer getCodigoAmigoOculto() {
        return codigoAmigoOculto;
    }

    public void setCodigoAmigoOculto(Integer codigoAmigoOculto) {
        this.codigoAmigoOculto = codigoAmigoOculto;
    }
}
