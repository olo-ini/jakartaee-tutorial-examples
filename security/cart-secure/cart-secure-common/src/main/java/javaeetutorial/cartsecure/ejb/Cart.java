/*
 * Copyright (c) 2014, 2019 Oracle and/or its affiliates. All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Distribution License v. 1.0, which is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 *
 * SPDX-License-Identifier: BSD-3-Clause
 */

package javaeetutorial.cartsecure.ejb;


import java.util.List;
import javaeetutorial.cartsecure.util.BookException;
import javax.ejb.Remote;


@Remote
public interface Cart {
    public void initialize(String person) throws BookException;

    public void initialize(
        String person,
        String id) throws BookException;

    public void addBook(String title);

    public void removeBook(String title) throws BookException;

    public List<String> getContents();

    public void remove();
}
