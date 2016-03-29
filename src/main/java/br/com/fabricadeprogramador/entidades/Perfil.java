package br.com.fabricadeprogramador.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by Matheus on 22/03/2016.
 */

@Entity
public class Perfil {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String descricao;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Perfil)) return false;

        Perfil perfil = (Perfil) o;

        if (getId() != null ? !getId().equals(perfil.getId()) : perfil.getId() != null) return false;
        return getDescricao() != null ? getDescricao().equals(perfil.getDescricao()) : perfil.getDescricao() == null;

    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getDescricao() != null ? getDescricao().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Perfil{" +
                "id=" + id +
                ", descricao='" + descricao + '\'' +
                '}';
    }
}
