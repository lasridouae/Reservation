package models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "role_table", schema = "public", catalog = "reservations")
public class Role implements Serializable {
    private Long id;
    private long idRole;
    private String nameRole;

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    @Column(name = "id_role", nullable = false)
    public long getIdRole() {
        return idRole;
    }

    public void setIdRole(long idRole) {
        this.idRole = idRole;
    }

    @Basic
    @Column(name = "name_role", nullable = true, length = -1)
    public String getNameRole() {
        return nameRole;
    }

    public void setNameRole(String nameRole) {
        this.nameRole = nameRole;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Role role = (Role) o;

        if (idRole != role.idRole) return false;
        if (nameRole != null ? !nameRole.equals(role.nameRole) : role.nameRole != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (idRole ^ (idRole >>> 32));
        result = 31 * result + (nameRole != null ? nameRole.hashCode() : 0);
        return result;
    }
}
