/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grucas.web.empleados.windows;

import com.grucas.web.empleados.domain.EmpleadoService;
import com.grucas.web.empleados.model.Empleado;
import com.grucas.web.empleados.model.Usuario;
import com.vaadin.data.Binder;
import com.vaadin.data.converter.LocalDateTimeToDateConverter;
import com.vaadin.data.converter.LocalDateToDateConverter;
import com.vaadin.data.converter.StringToIntegerConverter;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.server.VaadinSession;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.DateField;
import com.vaadin.ui.DateTimeField;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.NativeSelect;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import com.vaadin.ui.themes.ValoTheme;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import org.rubicone.vaadin.fam3.silk.Fam3SilkIcon;

/**
 *
 * @author EduardoC
 */
public class WindowEmpleado extends Window {
    
    Usuario user = (Usuario) VaadinSession.getCurrent().getAttribute("UsuarioActivo");
    
    VerticalLayout layout = new VerticalLayout();
    
    FormLayout form = new FormLayout();
    
    TextField txtId = new TextField("Id:");
    TextField txtNombre = new TextField("Nombre:");
    TextField txtPaterno = new TextField("Apellido Paterno:");
    TextField txtMaterno = new TextField("Materno:");
    TextField txtNss = new TextField("NSS:");
    TextField txtRfc = new TextField("RFC:");
    TextField txtCurp = new TextField("CURP:");
    DateField txtFechaNacimiento = new DateField("Fecha Nacimiento:",LocalDate.now());

    NativeSelect<String> cboEmpresa_id = new NativeSelect("Selecciona Empresa:");
    NativeSelect<String> cboUnidad_id = new NativeSelect("Selecciona Unidad:");  
    TextField txtEmpresa = new TextField("Empresa:");
    TextField txtUnidad = new TextField("Unidad:");
    TextField txtDepartamento = new TextField("Departamento:");
    TextField txtPuesto = new TextField("Puesto:");
    //DateField txtFechaIngreso = new DateField("Fecha de Ingreso:", LocalDate.now());
    DateTimeField txtFechaIngreso = new DateTimeField("Fecha de Ingreso:",LocalDateTime.now());
    DateTimeField txtFechaBaja = new DateTimeField("Fecha de Baja:");
    TextField txtRazonBaja = new TextField("Razon de Baja:");
    NativeSelect<String> cboEstado = new NativeSelect("Estado:");
    
    TextField txtDireccion = new TextField("Direccion:");
    TextField txtColonia = new TextField("Colonia:");
    TextField txtCiudad = new TextField("Ciudad:");
    TextField txtEstado = new TextField("Estado:");
    TextField txtPais = new TextField("Pais:");
    TextField txtCp = new TextField("CP.:");
    
    TextField txtNumeroTelefono = new TextField("Numero Telefono:");
    TextField txtCelular = new TextField("Celular:");
    TextField txtCorreoGrucas = new TextField("Correo Grucas:");
    TextField txtCorreoPersonal = new TextField("Correo Personal:");
    
    
    TextField txtVacacionesRestantantes = new TextField("Restan:");
    TextField txtVacacionesUsados = new TextField("Usados:");
    TextField txtAccesosSistemas = new TextField("Accesos a Sistemas:");
    
   
    Button btnAceptar = new Button("Guardar",Fam3SilkIcon.DISK);
    Button btnCancel = new Button("Cancelar",Fam3SilkIcon.DELETE);
    Button btnCancel2 = new Button("Cancelar",VaadinIcons.CLOSE);
    
    
    Empleado empleado = new Empleado();
    Binder<Empleado> bind = new Binder();
    Boolean edit = false;
    

    public WindowEmpleado() {
        initComponents();
    }

    public WindowEmpleado(Empleado empleado) {
        initComponents();
        edit = true;
        bind.readBean(empleado);
    }
    
    public void initComponents() {
        // PRIMER HORIZONTAL
        txtId.setWidth("45px");
        txtId.setStyleName(ValoTheme.TEXTFIELD_TINY);
        txtNombre.setWidth("130px");
        txtNombre.setStyleName(ValoTheme.TEXTFIELD_TINY);
        txtNombre.setStyleName(ValoTheme.TEXTFIELD_TINY);
        txtPaterno.setWidth("130px");
        txtPaterno.setStyleName(ValoTheme.TEXTFIELD_TINY);
        txtMaterno.setWidth("130px");
        txtMaterno.setStyleName(ValoTheme.TEXTFIELD_TINY);
        txtRfc.setWidth("125px");
        txtRfc.setStyleName(ValoTheme.TEXTFIELD_TINY);
        txtNss.setWidth("125px");
        txtNss.setStyleName(ValoTheme.TEXTFIELD_TINY);
        txtCurp.setWidth("162px");
        txtCurp.setStyleName(ValoTheme.TEXTFIELD_TINY);
        txtFechaNacimiento.setWidth("120px");
        txtFechaNacimiento.setStyleName(ValoTheme.TEXTFIELD_TINY);
        
        // SEGUNDO HORIZONTAL
        txtDireccion.setWidth("192px");
        txtDireccion.setStyleName(ValoTheme.TEXTFIELD_TINY);
        txtColonia.setWidth("180px");
        txtColonia.setStyleName(ValoTheme.TEXTFIELD_TINY);
        txtCiudad.setWidth("180px");
        txtCiudad.setStyleName(ValoTheme.TEXTFIELD_TINY);
        txtEstado.setWidth("180px");
        txtEstado.setStyleName(ValoTheme.TEXTFIELD_TINY);
        txtPais.setWidth("180px");
        txtPais.setStyleName(ValoTheme.TEXTFIELD_TINY);
        txtCp.setWidth("79px");
        txtCp.setStyleName(ValoTheme.TEXTFIELD_TINY);
        
        //TERCER HORIZONTAL
        cboEmpresa_id.setHeight("30");
        cboEmpresa_id.setWidth("230");
        cboEmpresa_id.setStyleName(ValoTheme.COMBOBOX_TINY);
        cboEmpresa_id.setItems("Grupo Castañeda, S.C.", "Unitrans","Recinto Fiscalizado");
        cboEmpresa_id.setSelectedItem("Grupo Castañeda, S.C.");
        cboEmpresa_id.setEmptySelectionAllowed(false);
        cboUnidad_id.setHeight("30");
        cboUnidad_id.setWidth("230");
        cboUnidad_id.setStyleName(ValoTheme.COMBOBOX_TINY);
        cboUnidad_id.setItems("Dac Tampico - Altamira", "Dac Veracruz","Dac Manzanillo", "Unitrans Altamira", "Unitrans Matamoros","Unitrans Nuevo Laredo");
        cboUnidad_id.setSelectedItem("Grupo Castañeda, S.C.");
        cboUnidad_id.setEmptySelectionAllowed(false);
        txtDepartamento.setWidth("300px");
        txtDepartamento.setStyleName(ValoTheme.TEXTFIELD_TINY);
        txtPuesto.setWidth("255px");
        txtPuesto.setStyleName(ValoTheme.TEXTFIELD_TINY);
        
        // CUARTO HORIZONTAL
        txtNumeroTelefono.setWidth("210px");
        txtNumeroTelefono.setStyleName(ValoTheme.TEXTFIELD_TINY);
        txtCelular.setWidth("205px");
        txtCelular.setStyleName(ValoTheme.TEXTFIELD_TINY);
        txtCorreoGrucas.setWidth("210px");
        txtCorreoGrucas.setStyleName(ValoTheme.TEXTFIELD_TINY);
        txtCorreoPersonal.setWidth("210px");
        txtCorreoPersonal.setStyleName(ValoTheme.TEXTFIELD_TINY);
        txtVacacionesRestantantes.setWidth("79px");
        txtVacacionesRestantantes.setDescription("Dias Restantes de Vacaciones");
        txtVacacionesRestantantes.setStyleName(ValoTheme.TEXTFIELD_TINY);
        txtVacacionesUsados.setWidth("79px");
        txtVacacionesUsados.setDescription("Dias Usados de Vacaciones");
        txtVacacionesUsados.setStyleName(ValoTheme.TEXTFIELD_TINY);
 
        // CUARTO HORIZONTAL
        txtAccesosSistemas.setWidth("335px");
        txtAccesosSistemas.setStyleName(ValoTheme.TEXTFIELD_TINY);
        txtFechaIngreso.setWidth("120px");
        txtFechaIngreso.setStyleName(ValoTheme.TEXTFIELD_TINY);
        txtFechaBaja.setWidth("120px");
        txtFechaBaja.setStyleName(ValoTheme.TEXTFIELD_TINY);
        txtRazonBaja.setWidth("335px");
        txtRazonBaja.setStyleName(ValoTheme.TEXTFIELD_TINY);
        cboEstado.setHeight("30");
        cboEstado.setWidth("90");
        cboEstado.setStyleName(ValoTheme.COMBOBOX_SMALL);
        cboEstado.setItems("Activo", "Baja");
        cboEstado.setSelectedItem("Activo");
        cboEstado.setEmptySelectionAllowed(false);
        
        bind.forField(txtId)
                .withConverter(new StringToIntegerConverter("Must enter a number"))
                .bind(Empleado::getId,Empleado::setId);
        bind.forField(txtNombre).bind(Empleado::getNombre,Empleado::setNombre);
        bind.forField(txtPaterno).bind(Empleado::getApellido_paterno,Empleado::setApellido_paterno);
        bind.forField(txtMaterno).bind(Empleado::getApellido_materno,Empleado::setApellido_materno);
        bind.forField(txtRfc).bind(Empleado::getRfc,Empleado::setRfc);
        bind.forField(txtNss).bind(Empleado::getNss,Empleado::setNss);
        bind.forField(txtCurp).bind(Empleado::getCurp,Empleado::setCurp);
        
        
        txtUnidad.setValue(cboEmpresa_id.getValue());
        
        bind.forField(txtUnidad).bind(Empleado::getUnidad,Empleado::setUnidad);
        
        bind.forField(txtFechaNacimiento)
                .withConverter(new LocalDateToDateConverter())
                .bind(Empleado::getFecha_nacimiento, Empleado::setFecha_nacimiento);
        
        bind.forField(txtFechaIngreso)
                .withConverter(new LocalDateTimeToDateConverter(ZoneId.systemDefault()))
                .bind(Empleado::getFecha_ingreso, Empleado::setFecha_ingreso);

        bind.forField(txtFechaBaja)
                .withConverter(new LocalDateTimeToDateConverter(ZoneId.systemDefault()))
                .bind(Empleado::getFecha_baja, Empleado::setFecha_baja);
        
        bind.forField(cboEstado).bind(Empleado::getEstado,Empleado::setEstado);
      
        
     
        form.addComponents(new HorizontalLayout(txtId,txtNombre,txtPaterno,txtMaterno,txtRfc,txtNss,txtCurp,txtFechaNacimiento),
                new HorizontalLayout(txtDireccion,txtColonia,txtCiudad,txtEstado,txtPais,txtCp),
                new HorizontalLayout(cboEmpresa_id,cboUnidad_id,txtDepartamento,txtPuesto),
                new HorizontalLayout(txtNumeroTelefono,txtCelular,txtCorreoGrucas,txtCorreoPersonal,txtVacacionesRestantantes,txtVacacionesUsados),
                new HorizontalLayout(txtAccesosSistemas,txtFechaIngreso,txtFechaBaja,txtRazonBaja,cboEstado));
                
        layout.addComponents(
                new Label("ALTA DE EMPLEADO"){{setStyleName("h3");}},
                form,
                new Label(""){{setStyleName("h7");}}, // ESPACIO PARA BOTONES
                new HorizontalLayout(btnAceptar,btnCancel));
                
        layout.setComponentAlignment(layout.getComponent(0), Alignment.TOP_CENTER);
        layout.setComponentAlignment(layout.getComponent(1), Alignment.TOP_CENTER);
        layout.setComponentAlignment(layout.getComponent(3), Alignment.TOP_CENTER);
        
        btnAceptar.addClickListener(ev ->{
            try {
                
                bind.writeBean(empleado);
                
                EmpleadoService servicio = new EmpleadoService();
                
                if (edit) {
                    servicio.EmpleadoUpdate(empleado);
                } else {
                    servicio.EmpleadoInsert(empleado);
                }
                
                if (servicio.getOk()) {

                    Notification.show("Empleado añadido a la base de datos");
                    close();

                } else {
                    Notification.show("Error al insertar el Empleado");
                }
            } catch (Exception e) {
                e.printStackTrace();
                Notification.show("Error en la captura del Empleado. Favor de validar. " + e.toString());
            }
        });
        
        btnCancel.addClickListener(ev -> {close();});
        
        setContent(layout);

        layout.setMargin(false);
        layout.setSpacing(true);
        form.setMargin(false);
        form.setSpacing(true);
    }
            
    
}