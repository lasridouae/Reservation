package Dao;

public interface UsersDao {

    public UsersDao findUserByEmail(String email);

    public void saveUser(UsersDao usersDao);
}
