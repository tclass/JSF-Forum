/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package jsf.forum.beans.install;

import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import jsf.forum.controller.CategoryController;
import jsf.forum.controller.ForumController;
import jsf.forum.controller.UserController;
import org.apache.log4j.Logger;

/**
 *
 * @author Tobi
 */
@Named(value="TestCase")
@RequestScoped
public class TestCase {


    @EJB
    private ForumController forumCtr;

    @EJB
    private UserController userCtr;

    @EJB
    private CategoryController catCtr;


   // Logger log = Logger.getLogger(TestCase.class);
    public TestCase() {
    }

    public void createDefault(){

        try{
        userCtr.createUser("Tobi", "test", "Tobias", "Klasse", 12, "t.klasse@googlemail.com");
        userCtr.createUser("jsf", "test", "Mia", "Klein", 19, "mia.klein@googlemail.com");
        userCtr.createUser("jsftest", "test", "cat", "Mehr", 20, "susi@googlemail.com");


        forumCtr.createForum("News", "Neue Updates etc.");
        forumCtr.createForum("Aktuelles", "Aktuelle Themen aus dem Internet");
        forumCtr.createForum("Hobby", "Themen aus dem Bereich Hobby");

        catCtr.createCategory("Plauderecke", "Die neusten Update, Patches, Leaks und vieles mehr", forumCtr.getForumById(1));
        catCtr.createCategory("Musik", "welche neuen Alben sind rausgekommen usw.", forumCtr.getForumById(1));
        catCtr.createCategory("Allgemeines", "Allgemeine Themen rund um alles was in der Welt abgeht", forumCtr.getForumById(1));

        catCtr.createCategory("Themenschau", "Alle allgemeinen Themen werden hier angesprochen, vieles Buntes usw.", forumCtr.getForumById(2));
        catCtr.createCategory("Linux", "Alles rund um Linux und die Welt", forumCtr.getForumById(2));
        catCtr.createCategory("Kochen", "Tausch die neusten Rezepte aus, auch Restaurantkritiken sind willkommen", forumCtr.getForumById(3));

        }
        catch(Exception e){
        //    log.info("TestCase created");
            e.printStackTrace();
        }

    }

}
