package com.webapp.youcode.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "admin_table", schema = "public", catalog = "reservation")
public class Admin extends Users implements Serializable {
    private Long id;
    private int userId;
    private int idAdmin;
    private Users users;

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "user_id", nullable = false)
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Id
    @Column(name = "id_admin", nullable = false)
    public int getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(int idAdmin) {
        this.idAdmin = idAdmin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Admin admin = (Admin) o;

        if (userId != admin.userId) return false;
        if (idAdmin != admin.idAdmin) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId;
        result = 31 * result + idAdmin;
        return result;
    }
    @ManyToOne
    @JoinColumn(name = "id_user", referencedColumnName = "id_user")
    public Users getUsersById() {
        return users;
    }

    public void setUsersById(Users usersById) {
        this.users = usersById;
    }
}
