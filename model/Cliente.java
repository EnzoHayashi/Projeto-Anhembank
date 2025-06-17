package model;

public class Cliente {
    private String nome;
    private String email;
    private String senha;
    private Conta conta;

    public Cliente(String nome, String email, String senha) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.conta = new Conta();
    }

    public String getNome() { return nome; }
    public String getEmail() { return email; }
    public String getSenha() { return senha; }
    public Conta getConta() { return conta; }
}