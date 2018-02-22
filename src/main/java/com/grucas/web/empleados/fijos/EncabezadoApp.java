/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grucas.web.empleados.fijos;

import com.grucas.web.empleados.model.Usuario;
import com.vaadin.server.VaadinSession;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.MenuBar.Command;
import com.vaadin.ui.MenuBar.MenuItem;
import org.rubicone.vaadin.fam3.silk.Fam3SilkIcon;

/**
 *
 * @author GrucasDev
 */
public class EncabezadoApp extends HorizontalLayout{
    
    Usuario user = (Usuario) VaadinSession.getCurrent().getAttribute("UsuarioActivo");
    
    MenuBar menu = new MenuBar();
    
    public EncabezadoApp(){
        
        setHeight("40%");
        setWidth("100%");
        setSpacing(true);
        setMargin(false);
        
        Command acciones = new Command() {
            @Override
            public void menuSelected(MenuItem selectedItem) {
                
                switch(selectedItem.getText()){
                    
                    case("Empleados"):{
                        getUI().getNavigator().navigateTo("EMPLEADOS");
                        break;
                    }
                    
                    case("Clientes"):{
                        getUI().getNavigator().navigateTo("CLIENTES");
                        break;
                    }
                    
                    case("Inventarios"):{
                        getUI().getNavigator().navigateTo("CLIENTES");
                        break;
                    }
                    
                    case("Salir"):{
                        getUI().getNavigator().navigateTo("LOGIN");
                        //VaadinSession.getCurrent().close();
                        break;
                    }
                }

            }
        };
        
        MenuItem menuEmpleados = menu.addItem("Empleados", acciones);
        menuEmpleados.setIcon(Fam3SilkIcon.USER);
        
        MenuItem menuCatalogos = menu.addItem("Catalogos", null);
        menuCatalogos.setIcon(Fam3SilkIcon.BOOK);
        
        //MenuItem subMenu_Clientes = menuCatalogos.addItem("Clientes", acciones);
        //subMenu_Clientes.setIcon(Fam3SilkIcon.USER);
        
        MenuItem menuSalir = menu.addItem("Salir", acciones);
        menuSalir.setIcon(Fam3SilkIcon.ARROW_OUT);
        
        /*
        MenuItem menuReportes = menu.addItem("Reportes", null);
        menuReportes.setIcon(Fam3SilkIcon.REPORT_GO);
        
        MenuItem subMenuRepOper = menuReportes.addItem("Operaciones", null);
        subMenuRepOper.setIcon(Fam3SilkIcon.FOLDER_WRENCH);
        
        MenuItem subMenuRepClientes = subMenuRepOper.addItem("Reporte Facturas", acciones);
        subMenuRepClientes.setIcon(Fam3SilkIcon.PAGE_GO);
        
        MenuItem subMenuRepFacturas = subMenuRepOper.addItem("Reporte Concentrado de Facturas", acciones);
        subMenuRepFacturas.setIcon(Fam3SilkIcon.PAGE_RED);
        
        
                
        MenuItem subMenu_Facturas = menuCatalogos.addItem("Facturas", null);
        subMenu_Facturas.setIcon(Fam3SilkIcon.PAGE_ATTACH);
        */
        addComponents(menu,new Label(user.toString()){{setStyleName("mystyle");}});
        setComponentAlignment(getComponent(1), Alignment.TOP_RIGHT);
        
        
        /*
        if(user.getRol().equals("CLIENTE")){
            
//            menuCatalogos.setVisible(false);
            
        }else if(user.getRol().equals("CAPTURISTA")){
            
            menuReportes.setVisible(false);
            
        }else{
            subMenu_Facturas.setVisible(false);
        }
        */
        
    }
    
}