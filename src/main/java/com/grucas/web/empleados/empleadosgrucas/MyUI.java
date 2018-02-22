package com.grucas.web.empleados.empleadosgrucas;

import com.grucas.web.empleados.views.ViewEmpleados;
import com.grucas.web.empleados.views.ViewLogin;
import com.grucas.web.empleados.views.ViewPrincipal;
import com.vaadin.annotations.PreserveOnRefresh;
import javax.servlet.annotation.WebServlet;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.Responsive;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.UI;

/**
 * This UI is the application entry point. A UI may either represent a browser window 
 * (or tab) or some part of an HTML page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be 
 * overridden to add component to the user interface and initialize non-component functionality.
 */
@PreserveOnRefresh
@Theme("mytheme")
public class MyUI extends UI {
    
    CssLayout layout = new CssLayout();
    Navigator navegador;

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        
        layout.setSizeFull();
        Responsive.makeResponsive(layout);
        setContent(layout);
        
        navegador = new Navigator(this, layout);
        navegador.addView("LOGIN", ViewLogin.class);
        navegador.addView("PRINCIPAL", ViewPrincipal.class);
        navegador.addView("EMPLEADOS", ViewEmpleados.class);
        
        navegador.navigateTo("LOGIN");
        
        
    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}
