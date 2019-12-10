package sa.user.service;

import sa.user.model.User;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class UserService {

    @PersistenceContext
    EntityManager entityManager;

    public List<User> getAllUsers(int first, int maxResult) {
	System.out.print("+++++++++++++++++++++++++++++++++++++\n");
	System.out.print("Prueba de seguimiento en User getAllUsers(int first, int maxResult).\n");
        return entityManager.createNamedQuery(User.FIND_ALL)
                .setFirstResult(first).setMaxResults(maxResult).getResultList();
    }

    public User getUserById(int id){
	System.out.print("+++++++++++++++++++++++++++++++++++++\n");
	System.out.print("Prueba de seguimiento en User getUserById(int id).\n");
        return entityManager.find(User.class, id);
    }

    public User createUser(User user) {
	System.out.print("+++++++++++++++++++++++++++++++++++++\n");
	System.out.print("Prueba de seguimiento en User createUser(User user).\n");
        entityManager.persist(user);
        entityManager.flush();
        return user;
    }

    public User updateUser(int id, User user) {
	System.out.print("+++++++++++++++++++++++++++++++++++++\n");
	System.out.print("Prueba de seguimiento en User updateUser(int id, User user).\n");
        User userToUpdate = entityManager.find(User.class, id);
        userToUpdate.setFirstName(user.getFirstName());
        userToUpdate.setLastName(user.getLastName());
        userToUpdate.setUsername(user.getUsername());
        userToUpdate.setPassword(user.getPassword());
        entityManager.merge(userToUpdate);
        return entityManager.find(User.class, id);
    }

    public int deleteUser(int id) {
	System.out.print("+++++++++++++++++++++++++++++++++++++\n");
	System.out.print("Prueba de seguimiento en User deleteUser(int id).\n");
        User userToDelete = entityManager.find(User.class, id);
        entityManager.remove(userToDelete);
        return id;
    }
}
