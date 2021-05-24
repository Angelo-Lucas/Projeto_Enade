/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.enade.converter;

import com.mycompany.enade.model.Tipoquestao;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Named;

/**
 *
 * @author @author angelo.lucas
 */
@FacesConverter("tipoquestaoConverter")
@Named
public class TipoQuestaoConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
        if (value != null && !value.isEmpty()) {
            return uic.getAttributes().get(value);
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object value) {
        if (value instanceof Tipoquestao) {
            Tipoquestao obj = (Tipoquestao) value;
            if (obj != null) {
                uic.getAttributes().put(obj.getId().toString(), obj);
                return obj.getId().toString();
            }
            return "";
        }
        return "";
    }

}
