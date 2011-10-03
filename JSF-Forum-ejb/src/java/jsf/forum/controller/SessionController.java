package jsf.forum.controller;

import javax.ejb.Stateful;
import javax.ejb.LocalBean;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.servlet.http.HttpSession;
import jsf.forum.entities.User;
import org.apache.log4j.Logger;

/**
 * @author Tobi
 */
@Stateful
@LocalBean
public class SessionController {

	Logger log = Logger.getLogger(SessionController.class);
	@PersistenceContext
	private EntityManager em;

	/*
	 * returns the current session, if the session is null, it creates a new one and returns it
	 */
	public HttpSession getSession() {
		FacesContext context = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) context.getExternalContext().getSession(false);
		if(session == null){
			session = (HttpSession) context.getExternalContext().getSession(true);
		}
		return session;
	}
	
	/**
	 * Checks if User is Logged in
	 * @return true or false
	 */
	public boolean isLoggedIn() {
		if(getSession().getAttribute("loggedIn") == null)
			return false;
		return (Boolean)getSession().getAttribute("loggedIn");
	}
	
	/**
	 * returns the Userobject from the session
	 * @return User user
	 */
	public User getUser()  {
		return (User)getSession().getAttribute("user");
	}

	
	/*
	 * login the User with the correct username + password 
	 */
	public boolean login(String username, String password) {

		log.info("Search for user in DB");

		try {

			Query q = em.createNamedQuery("Userlogin");

			q.setParameter("username", username);
			q.setParameter("password", password);
			User user = (User) q.getSingleResult();
			HttpSession session = getSession();

			if (user != null) {
				
				session.setAttribute("user", user);
				session.setAttribute("loggedIn", Boolean.TRUE);
				log.debug("User" + user.getUsername() + "gefunden");
			}
			else{
				session.setAttribute("loggedIn", Boolean.FALSE);
			}

		} catch (Exception e) {
			log.info("User nicht in der DB auffindbar" + e.getMessage());
			return false;
		}
		return true;
	}
	
	
	/*
	 * logouts the user and invalidates the session
	 */
	public void logout() {
		getSession().invalidate();
	}
}
