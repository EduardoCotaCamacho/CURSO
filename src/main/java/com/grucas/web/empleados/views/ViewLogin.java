/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grucas.web.empleados.views;

import com.grucas.web.empleados.domain.UsuarioService;
import com.vaadin.navigator.View;
import com.vaadin.server.VaadinSession;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;
import org.rubicone.vaadin.fam3.silk.Fam3SilkIcon;

/**
 *
 * @author GrucasDev
 */
public class ViewLogin extends VerticalLayout implements View {

    public ViewLogin() {

        TextField txtUsuario = new TextField("Usuario:");
        PasswordField txtPass = new PasswordField("Contraseña:");

        Button btnOk = new Button("Entrar", Fam3SilkIcon.ACCEPT);
        Button btnCancel = new Button("Cancelar", Fam3SilkIcon.DELETE);

        btnCancel.setStyleName(ValoTheme.BUTTON_DANGER);
        
        txtUsuario.setIcon(Fam3SilkIcon.USER);
        txtPass.setIcon(Fam3SilkIcon.LOCK);
        
        txtUsuario.setValue("ecota");
        txtPass.setValue("ecota");

        btnOk.addClickListener(ev -> {
            
            if (txtUsuario.getValue().isEmpty() && txtPass.getValue().isEmpty()) {
                Notification.show("Debe colocar un valor.", Notification.Type.ERROR_MESSAGE);
            } else {

                UsuarioService service = new UsuarioService();
                //System.out.println("----- entrando al sistema -----------" + txtPass.getValue());
                if (service.login(txtUsuario.getValue(), txtPass.getValue())) {
                    VaadinSession.getCurrent().setAttribute("UsuarioActivo", service.getObject());
                    //getUI().getNavigator().navigateTo("PRINCIPAL");
                    getUI().getNavigator().navigateTo("PRINCIPAL");
                } else {
                    Notification.show(service.getNotification(), Notification.Type.ERROR_MESSAGE);
                }
            }
            
        });

        addComponents(
                new Label("B I E N V E N I D O") {
            {
                setStyleName("h1");
            }
        },
                txtUsuario, txtPass,
                new HorizontalLayout(btnCancel, btnOk));

        setComponentAlignment(getComponent(0), Alignment.MIDDLE_CENTER);
        setComponentAlignment(txtUsuario, Alignment.MIDDLE_CENTER);
        setComponentAlignment(txtPass, Alignment.MIDDLE_CENTER);
        setComponentAlignment(getComponent(3), Alignment.MIDDLE_CENTER);

    }

}