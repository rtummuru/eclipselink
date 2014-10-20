/*******************************************************************************
 * Copyright (c) 1998, 2013 Oracle and/or its affiliates. All rights reserved.
 * This program and the accompanying materials are made available under the 
 * terms of the Eclipse Public License v1.0 and Eclipse Distribution License v. 1.0 
 * which accompanies this distribution. 
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at 
 * http://www.eclipse.org/org/documents/edl-v10.php.
 *
 * Contributors:
 *     Oracle - initial API and implementation from Oracle TopLink
 ******************************************************************************/  
package org.eclipse.persistence.testing.tests.jdkversiondetection;

import org.eclipse.persistence.*;
import org.eclipse.persistence.internal.helper.JavaSEPlatform;

/**
 *  Simple class for manual test of JDK version detection.
 *  This class implements a main() method which makes use of our org.eclipse.persistence.Version
 *  class to detect JDK versions.  It then prints the results.
 */
public class JDKVersionDetectionTester 
{

	public static void main(String[] args)
	{
		System.out.println(Version.getProduct() + " " + Version.getVersion());
		System.out.println("Build " + Version.getVersionString() + " on " + Version.getBuildDate());
		System.out.println("Java SE platform - " + JavaSEPlatform.CURRENT.toString());
	}
}
