package br.com.fabricadeprogramador.entidades;

import javax.persistence.*;

/**
 * Created by Matheus on 26/03/2016.
 */
@Entity
public class Estado {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(nullable = false, length = 2)
    private String uf;

    public Estado(String uf) {
    this.uf = uf;
    }

    public Estado() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Estado)) return false;

        Estado estado = (Estado) o;

        if (getId() != null ? !getId().equals(estado.getId()) : estado.getId() != null) return false;
        return getUf() != null ? getUf().equals(estado.getUf()) : estado.getUf() == null;

    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getUf() != null ? getUf().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Estado{" +
                "id=" + id +
                ", uf='" + uf + '\'' +
                '}';
    }
}
