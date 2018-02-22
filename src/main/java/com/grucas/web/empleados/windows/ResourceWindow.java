/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grucas.web.empleados.windows;

import com.vaadin.server.StreamResource;
import com.vaadin.server.StreamResource.StreamSource;
import com.vaadin.ui.Embedded;
import com.vaadin.ui.Window;

/**
 *
 * @author Grucas
 */
public class ResourceWindow extends Window{
    
    String file_name;
    StreamSource source;
    StreamResource resource;
    String mimeType;
    Embedded emb;

    public ResourceWindow(String file_name, StreamSource source) {
        this.file_name = file_name;
        this.source = source;
        initWindow();
    }

    public ResourceWindow(String file_name, StreamResource resource) {
        this.file_name = file_name;
        this.resource = resource;
        initWindow();
    }    
    
    public ResourceWindow(StreamSource source) {
        this.source = source;
        initWindow();
    }

    public ResourceWindow(StreamResource resource) {
        this.resource = resource;
        initWindow();
    }
    
    public void initWindow(){
        setDraggable(false);
        setResizable(false);
        setScrollLeft(15);
        center();
        setModal(true);
    }

    public String getFile_name() {
        return file_name;
    }

    public void setFile_name(String file_name) {
        this.file_name = file_name;
    }

    public StreamSource getSource() {
        return source;
    }

    public void setSource(StreamSource source) {
        this.source = source;
    }

    public StreamResource getResource() {
        return resource;
    }

    public void setResource(StreamResource resource) {
        this.resource = resource;
    }

    public String getMimeType() {
        return mimeType;
    }

    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }

    public Embedded getEmb() {
        return emb;
    }

    public void setEmb(Embedded emb) {
        this.emb = emb;
    }
    
    public void insertEmbedded(){
        emb = new Embedded("", resource );
        emb.setType(Embedded.TYPE_BROWSER);
        emb.setMimeType(getMimeType());
        emb.setSizeFull();
        setContent(emb);
    }

}
