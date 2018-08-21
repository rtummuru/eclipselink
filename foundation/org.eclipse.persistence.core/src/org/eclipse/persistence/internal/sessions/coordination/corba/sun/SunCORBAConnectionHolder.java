/*
 * Copyright (c) 1998, 2018 Oracle and/or its affiliates. All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0,
 * or the Eclipse Distribution License v. 1.0 which is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 *
 * SPDX-License-Identifier: EPL-2.0 OR BSD-3-Clause
 */

// Contributors:
//     Oracle - initial API and implementation from Oracle TopLink
package org.eclipse.persistence.internal.sessions.coordination.corba.sun;


/**
* org/eclipse/persistence/internal/remotecommand/corba/sun/SunCORBAConnectionHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.1"
* from rcm.idl
* Tuesday, March 30, 2004 2:00:14 PM EST
*/
public final class SunCORBAConnectionHolder implements org.omg.CORBA.portable.Streamable {
    public org.eclipse.persistence.internal.sessions.coordination.corba.sun.SunCORBAConnection value = null;

    public SunCORBAConnectionHolder() {
    }

    public SunCORBAConnectionHolder(org.eclipse.persistence.internal.sessions.coordination.corba.sun.SunCORBAConnection initialValue) {
        value = initialValue;
    }

    @Override
    public void _read(org.omg.CORBA.portable.InputStream i) {
        value = org.eclipse.persistence.internal.sessions.coordination.corba.sun.SunCORBAConnectionHelper.read(i);
    }

    @Override
    public void _write(org.omg.CORBA.portable.OutputStream o) {
        org.eclipse.persistence.internal.sessions.coordination.corba.sun.SunCORBAConnectionHelper.write(o, value);
    }

    @Override
    public org.omg.CORBA.TypeCode _type() {
        return org.eclipse.persistence.internal.sessions.coordination.corba.sun.SunCORBAConnectionHelper.type();
    }
}
