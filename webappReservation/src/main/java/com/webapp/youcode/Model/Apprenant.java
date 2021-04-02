package com.webapp.youcode.Model;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name ="user_id" )
public class Apprenant extends Users implements Serializable {
	
    @OneToOne
    @JoinColumn(name = "userId")
    private Users users;
    
    @OneToMany(mappedBy = "apprenant")
    private List<Reservation> reservations;

    public Apprenant() {

    }

    public Apprenant(Users users) {
        this.users = users;
    }

    public Apprenant(String userNom, String userPrenom, String userEmail, String userPassword, Roles role, Users users) {
        super(userNom, userPrenom, userEmail, userPassword, role);
        this.users = users;
    }

    public Apprenant(Long userId, String userNom, String userPrenom, String userEmail, String userPassword, Roles role, Users users) {
        super(userId, userNom, userPrenom, userEmail, userPassword, role);
        this.users = users;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

	public List<Reservation> getReservations() {
		return reservations;
	}



    public void setReservation(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    public void addReservation(Reservation reservation) {
        if (reservations == null) {
            reservations = new ArrayList<Reservation>();
        }

        reservations.add(reservation);

        reservation.setApprenant(this);
    }
//    


}