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
package org.eclipse.persistence.testing.tests.jpql;

import java.util.*;
import org.eclipse.persistence.queries.*;
import org.eclipse.persistence.expressions.*;
import org.eclipse.persistence.testing.models.employee.domain.*;

public class SimpleNotBetweenTest extends org.eclipse.persistence.testing.tests.jpql.JPQLTestCase {
    public void setup() {
        Vector employees = getSomeEmployees();
        Employee emp1 = (Employee)employees.firstElement();
        Employee emp2 = (Employee)employees.lastElement();

        ReadAllQuery raq = new ReadAllQuery();
        raq.setReferenceClass(Employee.class);

        ExpressionBuilder eb = new ExpressionBuilder();
        Expression whereClause = eb.get("id").between(emp1.getId(), emp2.getId()).not();

        raq.setSelectionCriteria(whereClause);

        employees = (Vector)getSession().executeQuery(raq);

        String ejbqlString = "SELECT OBJECT(emp) FROM Employee emp WHERE ";
        ejbqlString = ejbqlString + "emp.id NOT BETWEEN ";
        ejbqlString = ejbqlString + emp1.getId().toString();
        ejbqlString = ejbqlString + " AND ";
        ejbqlString = ejbqlString + emp2.getId().toString();

        setEjbqlString(ejbqlString);
        setOriginalOject(employees);
        super.setup();
    }
}
