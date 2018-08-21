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
package org.eclipse.persistence.testing.models.jpa.datatypes;

import javax.persistence.*;

@Entity
@Table(name = "CMP3_PCHARARRAY_TYPE")
public class CharArrayType implements java.io.Serializable {

    private int id;
    private char[] primitiveCharArrayData;

    public CharArrayType()
    {
    }

    public CharArrayType(char[] primitiveCharArrayData)
    {
        this.primitiveCharArrayData = primitiveCharArrayData;
    }

    @Id
    @Column(name="PCA_ID")
    @GeneratedValue(strategy=GenerationType.TABLE, generator="PCHARARRAY_TABLE_GENERATOR")
    @TableGenerator(
        name="PCHARARRAY_TABLE_GENERATOR",
        table="CMP3_PCHARARRAY_SEQ",
        pkColumnName="SEQ_NAME",
        valueColumnName="SEQ_COUNT",
        pkColumnValue="PCHARARRAY_SEQ"
    )
    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id= id;
    }

    @Column(name = "PCHARARRAY_DATA")
    public char[] getPrimitiveCharArrayData()
    {
        return primitiveCharArrayData;
    }
    public void setPrimitiveCharArrayData(char[] primitiveCharArrayData)
    {
        this.primitiveCharArrayData = primitiveCharArrayData;
    }

}
