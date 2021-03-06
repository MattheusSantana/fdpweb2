package br.com.fabricadeprogramador.entidades;

import javax.persistence.*;

/**
 * Created by Matheus on 28/02/2016.
 */

@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    @Column(nullable=false,length=20)
    private String nome;
    @Column(nullable=false,length=20)
    private String login;
    @Column(nullable=false,length=20)
    private String senha;

    @ManyToOne
    @JoinColumn
    private Perfil perfil;
    private Boolean ativo;



    public Usuario() {

    }

    public Usuario(String nome, String login, String senha) {
        super();
        this.nome = nome;
        this.login = login;
        this.senha = senha;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
    public Perfil getPerfil() {
        return perfil;
    }
    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }
    public boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    @Override
    public String toString() {
        return "Usuario [id=" + id + ", nome=" + nome + ", login=" + login + ", senha=" + senha + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Usuario)) return false;

        Usuario usuario = (Usuario) o;

        if (getId() != null ? !getId().equals(usuario.getId()) : usuario.getId() != null) return false;
        if (getNome() != null ? !getNome().equals(usuario.getNome()) : usuario.getNome() != null) return false;
        if (getLogin() != null ? !getLogin().equals(usuario.getLogin()) : usuario.getLogin() != null) return false;
        return getSenha() != null ? getSenha().equals(usuario.getSenha()) : usuario.getSenha() == null;

    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getNome() != null ? getNome().hashCode() : 0);
        result = 31 * result + (getLogin() != null ? getLogin().hashCode() : 0);
        result = 31 * result + (getSenha() != null ? getSenha().hashCode() : 0);
        return result;
    }
}
