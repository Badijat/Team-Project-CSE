package ie.tus;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;

@ManagedBean
@SessionScoped
public class LogoutBean implements Serializable {

    // Logout method

    public String logout() {
        // Perform logout logic here, e.g., invalidate the session and redirect to a logged-out page
        
        // For this example, we will invalidate the session and redirect to a "logged-out" page
        javax.faces.context.FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "logged-out.xhtml?faces-redirect=true";
    }
}