/*
 * Copyright (c) 2014, 2019 Oracle and/or its affiliates. All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Distribution License v. 1.0, which is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 *
 * SPDX-License-Identifier: BSD-3-Clause
 */

package javaeetutorial.dukesbookstore.listeners;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.context.FacesContext;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.ValueChangeEvent;
import javax.faces.event.ValueChangeListener;

/**
 *
 * <p>Value change listener for the quantity entered on the
 * <code>bookshowcart.xhtml</code> page.</p>
 */
public class QuantityChanged extends Object implements ValueChangeListener {

    private static final Logger logger =
            Logger.getLogger("dukesbookstore.listeners.QuantityChanged");

    @java.lang.Override
    public void processValueChange(ValueChangeEvent event)
            throws AbortProcessingException {
        logger.log(Level.INFO, "Entering QuantityChanged.processValueChange");
        if (null != event.getNewValue()) {
            FacesContext.getCurrentInstance().getExternalContext().
                    getSessionMap().put("changed", "true");
        } else {
            FacesContext.getCurrentInstance().getExternalContext().
                    getSessionMap().put("changed", "false");
        }
    }
}
