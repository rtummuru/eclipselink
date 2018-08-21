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
package org.eclipse.persistence.testing.tests.remote.suncorba;

/**
* org/eclipse/persistence/testing/Remote/SunCORBA/_CORBAServerManagerImplBase.java
* Generated by the IDL-to-Java compiler (portable), version "3.0"
* from CORBAServerManager.idl
* Wednesday, August 23, 2000 1:20:43 PM EDT
*/

public abstract class _CORBAServerManagerImplBase extends org.omg.CORBA.portable.ObjectImpl
                implements org.eclipse.persistence.testing.tests.remote.suncorba.CORBAServerManager, org.omg.CORBA.portable.InvokeHandler
{

  private static java.util.Hashtable _methods = new java.util.Hashtable ();
  static
  {
    _methods.put ("createRemoteSessionController", new java.lang.Integer (0));
  }

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:org/eclipse/persistence/testing/Remote/SunCORBA/CORBAServerManager:1.0"};

  // Constructors
  public _CORBAServerManagerImplBase ()
  {
  }
  public String[] _ids ()
  {
    return __ids;
  }
  public org.omg.CORBA.portable.OutputStream _invoke (String method,
                                org.omg.CORBA.portable.InputStream in,
                                org.omg.CORBA.portable.ResponseHandler rh)
  {
    org.omg.CORBA.portable.OutputStream out = rh.createReply();
    java.lang.Integer __method = (java.lang.Integer)_methods.get (method);
    if (__method == null)
      throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);

    switch (__method.intValue ())
    {
       case 0:  // org/eclipse/persistence/testing/Remote/SunCORBA/CORBAServerManager/createRemoteSessionController
       {
         org.eclipse.persistence.sessions.remote.corba.sun.CORBARemoteSessionController __result = null;
         __result = this.createRemoteSessionController ();
         org.eclipse.persistence.sessions.remote.corba.sun.CORBARemoteSessionControllerHelper.write (out, __result);
         break;
       }

       default:
         throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);
    }

    return out;
  } // _invoke
} // class _CORBAServerManagerImplBase
