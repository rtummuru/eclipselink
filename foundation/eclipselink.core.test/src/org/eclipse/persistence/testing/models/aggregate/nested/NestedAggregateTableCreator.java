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
package org.eclipse.persistence.testing.models.aggregate.nested;

import org.eclipse.persistence.tools.schemaframework.TableDefinition;

/**
 * TopLink generated Project class.
 * <b>WARNING</b>: This code was generated by an automated tool.
 * Any changes will be lost when the code is re-generated
 */
public class NestedAggregateTableCreator extends org.eclipse.persistence.tools.schemaframework.TableCreator {

    /**
     * <b>WARNING</b>: This code was generated by an automated tool.
     * Any changes will be lost when the code is re-generated
     */
    public NestedAggregateTableCreator() {
        applyPROJECT();
        buildSTUDENTTable();
    }

    /**
     * TopLink generated method.
     * <b>WARNING</b>: This code was generated by an automated tool.
     * Any changes will be lost when the code is re-generated
     */
    protected void applyPROJECT() {
        setName("NestedAggregate");
    }

    /**
     * TopLink generated method.
     * <b>WARNING</b>: This code was generated by an automated tool.
     * Any changes will be lost when the code is re-generated
     */
    protected void buildSTUDENTTable() {
        org.eclipse.persistence.tools.schemaframework.TableDefinition tabledefinition = new org.eclipse.persistence.tools.schemaframework.TableDefinition();

        // SECTION: TABLE
        tabledefinition.setName("STUDENT");

        // SECTION: FIELD
        org.eclipse.persistence.tools.schemaframework.FieldDefinition field = new org.eclipse.persistence.tools.schemaframework.FieldDefinition();
        field.setName("ID");
        field.setTypeName("NUMERIC");
        field.setShouldAllowNull(false);
        field.setIsPrimaryKey(true);
        field.setUnique(false);
        field.setIsIdentity(true);
        tabledefinition.addField(field);

        // SECTION: FIELD
        org.eclipse.persistence.tools.schemaframework.FieldDefinition field1 = new org.eclipse.persistence.tools.schemaframework.FieldDefinition();
        field1.setName("STUDENT_FIRSTNAME");
        field1.setTypeName("VARCHAR");
        field1.setShouldAllowNull(true);
        field1.setIsPrimaryKey(false);
        field1.setUnique(false);
        field1.setIsIdentity(false);
        tabledefinition.addField(field1);

        // SECTION: FIELD
        org.eclipse.persistence.tools.schemaframework.FieldDefinition field2 = new org.eclipse.persistence.tools.schemaframework.FieldDefinition();
        field2.setName("STUDENT_LASTNAME");
        field2.setTypeName("VARCHAR");
        field2.setShouldAllowNull(true);
        field2.setIsPrimaryKey(false);
        field2.setUnique(false);
        field2.setIsIdentity(false);
        tabledefinition.addField(field2);

        // SECTION: FIELD
        org.eclipse.persistence.tools.schemaframework.FieldDefinition field3 = new org.eclipse.persistence.tools.schemaframework.FieldDefinition();
        field3.setName("GUARDIAN_FIRSTNAME");
        field3.setTypeName("VARCHAR");
        field3.setShouldAllowNull(true);
        field3.setIsPrimaryKey(false);
        field3.setUnique(false);
        field3.setIsIdentity(false);
        tabledefinition.addField(field3);

        // SECTION: FIELD
        org.eclipse.persistence.tools.schemaframework.FieldDefinition field4 = new org.eclipse.persistence.tools.schemaframework.FieldDefinition();
        field4.setName("GUARDIAN_LASTNAME");
        field4.setTypeName("VARCHAR");
        field4.setShouldAllowNull(true);
        field4.setIsPrimaryKey(false);
        field4.setUnique(false);
        field4.setIsIdentity(false);
        tabledefinition.addField(field4);

        // SECTION: FIELD
        org.eclipse.persistence.tools.schemaframework.FieldDefinition field5 = new org.eclipse.persistence.tools.schemaframework.FieldDefinition();
        field5.setName("STREET");
        field5.setTypeName("VARCHAR");
        field5.setShouldAllowNull(true);
        field5.setIsPrimaryKey(false);
        field5.setUnique(false);
        field5.setIsIdentity(false);
        tabledefinition.addField(field5);

        // SECTION: FIELD
        org.eclipse.persistence.tools.schemaframework.FieldDefinition field6 = new org.eclipse.persistence.tools.schemaframework.FieldDefinition();
        field6.setName("CITY");
        field6.setTypeName("VARCHAR");
        field6.setShouldAllowNull(true);
        field6.setIsPrimaryKey(false);
        field6.setUnique(false);
        field6.setIsIdentity(false);
        tabledefinition.addField(field6);

        // SECTION: FIELD
        org.eclipse.persistence.tools.schemaframework.FieldDefinition field7 = new org.eclipse.persistence.tools.schemaframework.FieldDefinition();
        field7.setName("PROVINCE");
        field7.setTypeName("VARCHAR");
        field7.setShouldAllowNull(true);
        field7.setIsPrimaryKey(false);
        field7.setUnique(false);
        field7.setIsIdentity(false);
        tabledefinition.addField(field7);

        // SECTION: FIELD
        org.eclipse.persistence.tools.schemaframework.FieldDefinition field8 = new org.eclipse.persistence.tools.schemaframework.FieldDefinition();
        field8.setName("COUNTRY");
        field8.setTypeName("VARCHAR");
        field8.setShouldAllowNull(true);
        field8.setIsPrimaryKey(false);
        field8.setUnique(false);
        field8.setIsIdentity(false);
        tabledefinition.addField(field8);

        // SECTION: FIELD
        org.eclipse.persistence.tools.schemaframework.FieldDefinition field9 = new org.eclipse.persistence.tools.schemaframework.FieldDefinition();
        field9.setName("POSTALCODE");
        field9.setTypeName("VARCHAR");
        field9.setShouldAllowNull(true);
        field9.setIsPrimaryKey(false);
        field9.setUnique(false);
        field9.setIsIdentity(false);
        tabledefinition.addField(field9);
        addTableDefinition(tabledefinition);
    }

    /**
     * This method was created in VisualAge.
     */
    public static TableDefinition tableDefinition() {
        TableDefinition tabledefinition = new TableDefinition();

        // SECTION: TABLE
        tabledefinition.setName("STUDENT");

        // SECTION: FIELD
        org.eclipse.persistence.tools.schemaframework.FieldDefinition field = new org.eclipse.persistence.tools.schemaframework.FieldDefinition();
        field.setName("ID");
        field.setTypeName("NUMERIC");
        field.setShouldAllowNull(false);
        field.setIsPrimaryKey(true);
        field.setUnique(false);
        field.setIsIdentity(true);
        tabledefinition.addField(field);

        // SECTION: FIELD
        org.eclipse.persistence.tools.schemaframework.FieldDefinition field1 = new org.eclipse.persistence.tools.schemaframework.FieldDefinition();
        field1.setName("STUDENT_FIRSTNAME");
        field1.setTypeName("VARCHAR");
        field1.setSize(50);
        field1.setShouldAllowNull(true);
        field1.setIsPrimaryKey(false);
        field1.setUnique(false);
        field1.setIsIdentity(false);
        tabledefinition.addField(field1);

        // SECTION: FIELD
        org.eclipse.persistence.tools.schemaframework.FieldDefinition field2 = new org.eclipse.persistence.tools.schemaframework.FieldDefinition();
        field2.setName("STUDENT_LASTNAME");
        field2.setTypeName("VARCHAR");
        field2.setSize(50);
        field2.setShouldAllowNull(true);
        field2.setIsPrimaryKey(false);
        field2.setUnique(false);
        field2.setIsIdentity(false);
        tabledefinition.addField(field2);

        // SECTION: FIELD
        org.eclipse.persistence.tools.schemaframework.FieldDefinition field3 = new org.eclipse.persistence.tools.schemaframework.FieldDefinition();
        field3.setName("GUARDIAN_FIRSTNAME");
        field3.setTypeName("VARCHAR");
        field3.setSize(50);
        field3.setShouldAllowNull(true);
        field3.setIsPrimaryKey(false);
        field3.setUnique(false);
        field3.setIsIdentity(false);
        tabledefinition.addField(field3);

        // SECTION: FIELD
        org.eclipse.persistence.tools.schemaframework.FieldDefinition field4 = new org.eclipse.persistence.tools.schemaframework.FieldDefinition();
        field4.setName("GUARDIAN_LASTNAME");
        field4.setTypeName("VARCHAR");
        field4.setSize(50);
        field4.setShouldAllowNull(true);
        field4.setIsPrimaryKey(false);
        field4.setUnique(false);
        field4.setIsIdentity(false);
        tabledefinition.addField(field4);

        // SECTION: FIELD
        org.eclipse.persistence.tools.schemaframework.FieldDefinition field5 = new org.eclipse.persistence.tools.schemaframework.FieldDefinition();
        field5.setName("STREET");
        field5.setTypeName("VARCHAR");
        field5.setSize(50);
        field5.setShouldAllowNull(true);
        field5.setIsPrimaryKey(false);
        field5.setUnique(false);
        field5.setIsIdentity(false);
        tabledefinition.addField(field5);

        // SECTION: FIELD
        org.eclipse.persistence.tools.schemaframework.FieldDefinition field6 = new org.eclipse.persistence.tools.schemaframework.FieldDefinition();
        field6.setName("CITY");
        field6.setTypeName("VARCHAR");
        field6.setSize(50);
        field6.setShouldAllowNull(true);
        field6.setIsPrimaryKey(false);
        field6.setUnique(false);
        field6.setIsIdentity(false);
        tabledefinition.addField(field6);

        // SECTION: FIELD
        org.eclipse.persistence.tools.schemaframework.FieldDefinition field7 = new org.eclipse.persistence.tools.schemaframework.FieldDefinition();
        field7.setName("PROVINCE");
        field7.setTypeName("VARCHAR");
        field7.setSize(50);
        field7.setShouldAllowNull(true);
        field7.setIsPrimaryKey(false);
        field7.setUnique(false);
        field7.setIsIdentity(false);
        tabledefinition.addField(field7);

        // SECTION: FIELD
        org.eclipse.persistence.tools.schemaframework.FieldDefinition field8 = new org.eclipse.persistence.tools.schemaframework.FieldDefinition();
        field8.setName("COUNTRY");
        field8.setTypeName("VARCHAR");
        field8.setSize(50);
        field8.setShouldAllowNull(true);
        field8.setIsPrimaryKey(false);
        field8.setUnique(false);
        field8.setIsIdentity(false);
        tabledefinition.addField(field8);

        // SECTION: FIELD
        org.eclipse.persistence.tools.schemaframework.FieldDefinition field9 = new org.eclipse.persistence.tools.schemaframework.FieldDefinition();
        field9.setName("POSTALCODE");
        field9.setTypeName("VARCHAR");
        field9.setSize(50);
        field9.setShouldAllowNull(true);
        field9.setIsPrimaryKey(false);
        field9.setUnique(false);
        field9.setIsIdentity(false);
        tabledefinition.addField(field9);

        return tabledefinition;
    }
}
