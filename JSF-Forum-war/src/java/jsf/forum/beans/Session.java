/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf.forum.beans;

import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import jsf.forum.controller.SessionController;
import org.apache.log4j.Logger;

/**
 *
 * @author Tobi
 */
@ManagedBean(name = "Session")
@SessionScoped
public class Session implements Serializable {

	@EJB
	private SessionController sessionCtr;
	Logger log = Logger.getLogger(Session.class);
	//User specific Informations
	private String username;
	private String password;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public boolean loggedIn() {
		return sessionCtr.isLoggedIn();
	}

	public String login() {
		log.info(username + password);
		sessionCtr.login(username, password);

		return "index.xhtml?faces-redirect=true";
	}

	public String logout() {
		sessionCtr.logout();
		
		return "index.xhtml?faces-redirect=true";
	}
}
