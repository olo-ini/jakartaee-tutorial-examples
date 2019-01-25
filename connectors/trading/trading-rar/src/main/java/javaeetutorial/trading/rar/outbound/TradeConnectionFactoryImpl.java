/*
 * Copyright (c) 2014, 2019 Oracle and/or its affiliates. All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Distribution License v. 1.0, which is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 *
 * SPDX-License-Identifier: BSD-3-Clause
 */

package javaeetutorial.trading.rar.outbound;

import java.util.logging.Logger;
import javaeetutorial.trading.rar.api.TradeConnection;
import javaeetutorial.trading.rar.api.TradeConnectionFactory;
import javax.resource.ResourceException;
import javax.resource.spi.ConnectionManager;

/* Implements the class that applications use to request connection 
 * handles to the EIS */
public class TradeConnectionFactoryImpl implements TradeConnectionFactory {

    private static final Logger log = Logger.getLogger("TradeConnectionFactoryImpl");
    private ConnectionManager cmanager;
    private TradeManagedConnectionFactory mcfactory;
    
    /* The container creates instances of this class 
     * through TradeManagedConnectionFactory.createConnectionFactory() */
    TradeConnectionFactoryImpl(TradeManagedConnectionFactory mcfactory,
                               ConnectionManager cmanager) {
        this.mcfactory = mcfactory;
        this.cmanager = cmanager;
    }
    
    /* Applications call this method, which delegates on the container's
     * connection manager to obtain a connection instance through
     * TradeManagedConnectionFactory */
    @Override
    public TradeConnection getConnection() throws ResourceException {
        log.info("[TradeConnectionFactoryImpl] getConnection()");
        return (TradeConnection) cmanager.allocateConnection(mcfactory, null);
    }
}
