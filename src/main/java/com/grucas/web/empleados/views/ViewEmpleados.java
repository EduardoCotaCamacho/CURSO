/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grucas.web.empleados.views;

import com.grucas.web.empleados.domain.EmpleadoService;
import com.grucas.web.empleados.model.Empleado;
import com.grucas.web.empleados.model.Usuario;
import com.grucas.web.empleados.fijos.EncabezadoApp;
import com.grucas.web.empleados.windows.WindowEmpleado;
import com.vaadin.navigator.View;
import com.vaadin.server.VaadinSession;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.Grid;
import com.vaadin.ui.Grid.SelectionMode;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.NativeSelect;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.renderers.DateRenderer;
import org.rubicone.vaadin.fam3.silk.Fam3SilkIcon;

/**
 *
 * @author GrucasDev
 */
public class ViewEmpleados extends Panel implements View {
    
    VerticalLayout vLay = new VerticalLayout();
            
    Usuario user = (Usuario) VaadinSession.getCurrent().getAttribute("UsuarioActivo");
        
    Button btnAgregar = new Button("",Fam3SilkIcon.APPLICATION_ADD);
    Button btnModificar = new Button("",Fam3SilkIcon.APPLICATION_EDIT);
    Button btnEliminar = new Button("",Fam3SilkIcon.APPLICATION_DELETE);
    Button btnImprimir = new Button("",Fam3SilkIcon.PRINTER);
    Button btnBuscar = new Button("",Fam3SilkIcon.FIND);
    
    TextField txtBusqueda = new TextField();
    
    NativeSelect<String> cboPrueba = new NativeSelect();
    
    Grid<Empleado> gridEmpleados = new Grid();
    
    CheckBox chkActivos = new CheckBox("Activos", true);
    
    public ViewEmpleados(){
        
        setSizeFull();
        
        vLay.setSpacing(true);
        vLay.setMargin(false);
        
        gridEmpleados.setSizeFull();
        
        cboPrueba.setItems("TODOS","NOMBRE","APELLIDO PATERNO","APELLIDO MATERNO","UNIDAD");
        cboPrueba.setEmptySelectionAllowed(false);
        cboPrueba.setValue("TODOS");
        
        
        
        gridEmpleados.addColumn(Empleado::getId).setCaption("ID");
        gridEmpleados.addColumn(Empleado::getNombre).setCaption("NOMBRE");
        gridEmpleados.addColumn(Empleado::getApellido_paterno).setCaption("A.PATERNO");
        gridEmpleados.addColumn(Empleado::getApellido_materno).setCaption("A.MATERNO");
        gridEmpleados.addColumn(Empleado::getUnidad).setCaption("UNIDAD");
        gridEmpleados.addColumn(Empleado::getNumero_de_telefono).setCaption("TELEFONO"); 
        gridEmpleados.addColumn(Empleado::getFecha_ingreso, new DateRenderer("%1$td" + "/" + "%1$tm" + "/" + "%1$tY" + " - " + "%1$tH" + ":" + "%1$tM" + ":" + "%1$tS"))
                .setCaption("FECHA DE INGRESO");
        gridEmpleados.addColumn(Empleado::getEstado).setCaption("ESTADO");
        
        /*
        gridEmpleados.addColumn(Empleado::getEmpresa_id).setCaption("ID");
        gridEmpleados.addColumn(Empleado::getRfc).setCaption("RFC");
        gridEmpleados.addColumn(Empleado::getFecha_baja).setCaption("ID");
        gridEmpleados.addColumn(Empleado::getRazon_baja).setCaption("ID");
        gridEmpleados.addColumn(Empleado::getFecha_elaboracion).setCaption("F.ELAB.");
        gridEmpleados.addColumn(Empleado::getFecha_modificacion).setCaption("F.MOD.");
        gridEmpleados.addColumn(Empleado::getEmpresa_id).setCaption("ID");
        gridEmpleados.addColumn(Empleado::getEmpresa).setCaption("ID");
        gridEmpleados.addColumn(Empleado::getUnidad_id).setCaption("ID");
        gridEmpleados.addColumn(Empleado::getUsuario).setCaption("ID");
        gridEmpleados.addColumn(Empleado::getNss).setCaption("ID");
        gridEmpleados.addColumn(Empleado::getCurp).setCaption("ID");
        gridEmpleados.addColumn(Empleado::getCorreo_grucas).setCaption("ID");
        gridEmpleados.addColumn(Empleado::getCorreo_personal).setCaption("ID");
        gridEmpleados.addColumn(Empleado::getCelular).setCaption("ID");
        gridEmpleados.addColumn(Empleado::getDireccion).setCaption("ID");
        gridEmpleados.addColumn(Empleado::getColonia).setCaption("ID");
        gridEmpleados.addColumn(Empleado::getCiudad).setCaption("ID");
        gridEmpleados.addColumn(Empleado::getEstado).setCaption("ID");
        gridEmpleados.addColumn(Empleado::getPais).setCaption("ID");
        gridEmpleados.addColumn(Empleado::getCp).setCaption("ID");
        gridEmpleados.addColumn(Empleado::getFecha_nacimiento).setCaption("ID");
        gridEmpleados.addColumn(Empleado::getPuesto).setCaption("ID");
        gridEmpleados.addColumn(Empleado::getDepartamento).setCaption("ID");
        gridEmpleados.addColumn(Empleado::getDias_vacaciones_restantes).setCaption("ID");
        gridEmpleados.addColumn(Empleado::getDias_vacaciones_usados).setCaption("ID");
        gridEmpleados.addColumn(Empleado::getAccesos_sistemas).setCaption("ID");
        */
        
        gridEmpleados.setSelectionMode(SelectionMode.SINGLE);
        
        gridEmpleados.addItemClickListener(event -> {
            
            if (event.getMouseEventDetails().isDoubleClick()) {
                if (gridEmpleados.getSelectedItems().size() == 1) {
                    WindowEmpleado ventana = new WindowEmpleado(event.getItem());
                    ventana.center();
                    ventana.setModal(true);
                    ventana.addCloseListener(ev -> {
                        fillTable();
                    });
                    getUI().addWindow(ventana);
                }
            }
        });
        
        btnBuscar.addClickListener(ev -> {fillTable();});
        
        btnAgregar.addClickListener(new Button.ClickListener() {
            
            @Override
            public void buttonClick(Button.ClickEvent event) {
             
                WindowEmpleado ventana = new WindowEmpleado();
                ventana.center();
                ventana.setModal(true);
                ventana.setResponsive(true);
                ventana.setWidth("1100px");
                ventana.setHeight("500px");
                ventana.addCloseListener(ev -> {
                    fillTable();
                });
                getUI().addWindow(ventana);
            
            }
            
        });
        
        btnModificar.addClickListener(ev ->{
            
            if (gridEmpleados.getSelectedItems().size() == 1) {
                WindowEmpleado ventana = new WindowEmpleado(gridEmpleados.getSelectedItems().iterator().next());
                ventana.center();
                ventana.setModal(true);
                ventana.addCloseListener(evt -> {
                    fillTable();
                });
                getUI().addWindow(ventana);
            } else {
                Notification.show("Seleccione un registro a modificar");
            }
            
        });

        btnEliminar.addClickListener(ev -> {
            try {

                EmpleadoService servicio = new EmpleadoService();
                servicio.EmpleadoDelete(gridEmpleados.getSelectedItems().iterator().next());

                if (servicio.getOk()) {

                    Notification.show("Empleado Eliminado de la base de datos");
                    fillTable();
                } else {
                    Notification.show("Error al eliminar el Empleado");
                }
            } catch (Exception e) {
                e.printStackTrace();
                Notification.show("Error al eliminar el Empleado. Favor de validar. " + e.toString());
            }
 
        });
        
        btnImprimir.addClickListener(ev ->{
            /*
                final HashMap map = new HashMap();
                map.put("","");

                StreamResource.StreamSource source = new StreamResource.StreamSource() {
                    @Override
                    public InputStream getStream() {
                        byte[] b = null;
                        try {

                            InputStream fileStream = getClass().getClassLoader().getResourceAsStream("/reportes/ReporteEmpleados.jasper");
                            b = JasperRunManager.runReportToPdf(fileStream, map, FactorySession.getConnection("local"));

                        } catch (JRException ex) {
                            ex.printStackTrace();
                            Notification.show("Error al generar el Reporte", Notification.Type.ERROR_MESSAGE);
                        }
                        return new ByteArrayInputStream(b);
                    }
                };
                
                StreamResource resource = new StreamResource(source, "Reporte_" + UUID.randomUUID().toString() + ".pdf");

                // Show in window
                ResourceWindow windowPDF = new ResourceWindow(resource);
                windowPDF.setCaption("Reportes - Empleados");
                windowPDF.setHeight("100%");
                windowPDF.setWidth("80%");
                windowPDF.setMimeType("application/pdf");
                windowPDF.setScrollLeft(15);
                windowPDF.insertEmbedded();
                getUI().addWindow(windowPDF);
                */
        });
        
        vLay.addComponents(
                new EncabezadoApp(),
                new Label("EMPLEADOS"){{setStyleName("h4");}},
                new HorizontalLayout(new Label("Busqueda por:"),cboPrueba,txtBusqueda,chkActivos,btnBuscar,btnAgregar,btnModificar,btnEliminar,btnImprimir),
                gridEmpleados
        );
        
        vLay.setComponentAlignment(vLay.getComponent(1), Alignment.MIDDLE_CENTER);
        vLay.setComponentAlignment(vLay.getComponent(2), Alignment.MIDDLE_CENTER);
        
        setContent(vLay);
        fillTable();
        if(user.getRol().equals("CLIENTE")){
            btnAgregar.setEnabled(false);
            btnEliminar.setEnabled(false);
        }
        
        
    }
    
    public void fillTable(){
        
        String strWhere = "";
        String strBusqueda = cboPrueba.getValue();
        
        switch(strBusqueda){
            
            case "NOMBRE":{
                strWhere = " nombre LIKE '%" + txtBusqueda.getValue().toUpperCase().trim() + "%'";
                break;
            }
            
            case "APELLIDO PATERNO":{
                strWhere = " apellido_paterno LIKE '%" + txtBusqueda.getValue().toUpperCase().trim() + "%'";
                break;
            }
            
            case "APELLIDO MATERNO":{
                strWhere = " apellido_materno LIKE '%" + txtBusqueda.getValue().toUpperCase().trim() + "%'";
                break;
            }
            
            case "UNIDAD":{
                strWhere = " unidad LIKE '%" + txtBusqueda.getValue().toUpperCase().trim() + "%'";
                break;
            }
            
            default:{
                strWhere = "";
                break;
            }
            
        }
        
        EmpleadoService servicio = new EmpleadoService();
        servicio.getEmpleado(strWhere,""," id DESC ");
        gridEmpleados.setItems(servicio.getObjects());
        txtBusqueda.setValue("");
    }
    
}