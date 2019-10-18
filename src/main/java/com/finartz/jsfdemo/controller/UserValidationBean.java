package com.finartz.jsfdemo.controller;

import com.finartz.jsfdemo.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.ManagedBean;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@ManagedBean(value = "userValidationBean")
@Scope("view")
public class UserValidationBean {

    public void validateFirstName(FacesContext context, UIComponent comp, Object value) {
        boolean error = false;

        String firstName = (String) value;

        if (firstName.length() < 2) {
            ((UIInput) comp).setValid(false);
            FacesMessage message = new FacesMessage("Firstname cannot be smaller than 2");
            context.addMessage(comp.getClientId(context), message);
        }
    }
}