/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grucas.web.empleados.views;

import com.grucas.web.empleados.fijos.EncabezadoApp;
import com.vaadin.navigator.View;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;


/**
 *
 * @author GrucasDev
 */
public class ViewPrincipal extends Panel implements View{
    
    VerticalLayout vLay = new VerticalLayout();
    
    public ViewPrincipal(){
        setSizeFull();
        
        vLay.setSpacing(true);
        vLay.setMargin(false);

        vLay.addComponents(
                new EncabezadoApp());
        
        setContent(vLay);
        
    }
    
}