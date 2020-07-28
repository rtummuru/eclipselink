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
//     Mike Norman - May 06 2008, created DBWS tools package

package org.eclipse.persistence.tools.dbws;

//javase imports
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.jar.JarOutputStream;
import java.util.jar.Manifest;
import java.util.zip.ZipEntry;
import static java.util.jar.Attributes.Name.MANIFEST_VERSION;

//EclipseLink imports
import static org.eclipse.persistence.internal.xr.Util.DBWS_OR_XML;
import static org.eclipse.persistence.internal.xr.Util.DBWS_OX_XML;
import static org.eclipse.persistence.internal.xr.Util.DBWS_SCHEMA_XML;
import static org.eclipse.persistence.internal.xr.Util.DBWS_SERVICE_XML;
import static org.eclipse.persistence.internal.xr.Util.DBWS_SESSIONS_XML;
import static org.eclipse.persistence.internal.xr.Util.META_INF_PATHS;
import static org.eclipse.persistence.internal.xr.Util.WSDL_DIR;
import static org.eclipse.persistence.tools.dbws.Util.SWAREF_FILENAME;

/**
 * <p>
 * <b>INTERNAL:</b> JarArchiver implements the {@link DBWSPackager.Archiver} interface. <br>
 * This helper class takes the files generated by a DBWSPackager and puts them into an archive,<br>
 * in this case, a <tt>.jar</tt> file.
 * <p>
 *
 * @author Mike Norman - michael.norman@oracle.com
 * @since EclipseLink 1.x
 * <pre>
 * Jar-file layout
 *    \
 *    |   eclipselink-dbws-schema.xsd
 *    |   swaref.xsd                  -- optional if attachements are enabled
 *    \---META-INF
 *        |   eclipselink-dbws-or.xml
 *        |   eclipselink-dbws-ox.xml
 *        |   eclipselink-dbws-sessions.xml
 *        |   eclipselink-dbws.xml
 * </pre>
 */
public class JarArchiver implements DBWSPackager.Archiver {

    static final int BUF_SIZE = 1024;
    static final String DEFAULT_JAR_FILENAME = "dbws.jar";
    static final String DEFAULT_MANIFEST =
        MANIFEST_VERSION.toString() + ": 1.0\n" +
        "Created-by: DBWSBuilder 1.0\n\n";

    protected DBWSPackager packager;
    protected String jarFilename = null;
    protected JarOutputStream jarOutputStream = null;
    protected File f;
    protected FileInputStream fis;
    protected byte[] buffer = new byte[BUF_SIZE];

    public JarArchiver() {
    }
    public JarArchiver(DBWSPackager packager) {
        this.packager = packager;
    }

    public DBWSPackager getPackager() {
        return packager;
    }
    public void setPackager(DBWSPackager packager) {
        this.packager = packager;
    }

    public String getFilename() {
        return jarFilename;
    }
    public void setFilename(String jarFilename) {
        if (!(jarFilename.endsWith(".jar"))) {
            jarFilename += ".jar";
        }
        this.jarFilename = jarFilename;
    }

    public void archive() {
        try {
            JarOutputStream jarOutputStream = buildJarOutputStream();
            if (jarOutputStream != null) {
                Manifest manifest = buildManifest();
                if (manifest != null) {
                    ZipEntry e = new ZipEntry(JarFile.MANIFEST_NAME);
                    jarOutputStream.putNextEntry(e);
                    manifest.write(new BufferedOutputStream(jarOutputStream));
                    jarOutputStream.closeEntry();
                }
                addFilesToJarOutputStream(jarOutputStream);
                jarOutputStream.close();
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected Manifest buildManifest() {
        Manifest manifest = null;
        try {
            new Manifest(new ByteArrayInputStream(DEFAULT_MANIFEST.getBytes("ISO-8859-1")));
        }
        catch (Exception e) {
            // e.printStackTrace();
        }
        return manifest;
    }

    protected JarOutputStream buildJarOutputStream() {
        JarOutputStream jarOutputStream = null;
        try {
            if (jarFilename == null || jarFilename.length() == 0) {
                jarFilename = DEFAULT_JAR_FILENAME;
            }
            jarOutputStream = new JarOutputStream(new FileOutputStream(
                new File(packager.getStageDir(), jarFilename)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jarOutputStream;
    }

    protected JarEntry getSchemaJarEntry() {
        return new JarEntry(DBWS_SCHEMA_XML);
    }

    protected JarEntry getSWARefJarEntry() {
        return new JarEntry(SWAREF_FILENAME);
    }

    protected JarEntry getOrJarEntry() {
        return new JarEntry(META_INF_PATHS[0] + DBWS_OR_XML);
    }

    protected JarEntry getOxJarEntry() {
        return new JarEntry(META_INF_PATHS[0] + DBWS_OX_XML);
    }

    protected JarEntry getSessionsJarEntry() {
        return new JarEntry(META_INF_PATHS[0] + packager.getSessionsFileName());
    }

    protected JarEntry getServiceJarEntry() {
        return new JarEntry(META_INF_PATHS[0] + DBWS_SERVICE_XML);
    }

    protected void addFilesToJarOutputStream(JarOutputStream jarOutputStream) {
        // copy files from disk into jar file, then clean up
        try {
            // eclipselink-dbws-schema.xsd
            jarOutputStream.putNextEntry(getSchemaJarEntry());
            f = new File(packager.getStageDir(), DBWS_SCHEMA_XML);
            fis = new FileInputStream(f);
            for (int read = 0; read != -1; read = fis.read(buffer)) {
                jarOutputStream.write(buffer, 0, read);
            }
            fis.close();
            f.deleteOnExit();

            if (packager.hasAttachments()) {
                // swaref.xsd
                jarOutputStream.putNextEntry(getSWARefJarEntry());
                f = new File(packager.getStageDir(), SWAREF_FILENAME);
                fis = new FileInputStream(f);
                for (int read = 0; read != -1; read = fis.read(buffer)) {
                    jarOutputStream.write(buffer, 0, read);
                }
                fis.close();
                f.deleteOnExit();
            }

            // META-INF/eclipselink-dbws-or.xml
            f = new File(packager.getStageDir(), DBWS_OR_XML);
            if (f.length() > 0) {
                jarOutputStream.putNextEntry(getOrJarEntry());
                fis = new FileInputStream(f);
                for (int read = 0; read != -1; read = fis.read(buffer)) {
                    jarOutputStream.write(buffer, 0, read);
                }
                fis.close();
                }
            f.deleteOnExit();

            // META-INF/eclipselink-dbws-ox.xml
            f = new File(packager.getStageDir(), DBWS_OX_XML);
            if (f.length() > 0) {
                jarOutputStream.putNextEntry(getOxJarEntry());
                fis = new FileInputStream(f);
                for (int read = 0; read != -1; read = fis.read(buffer)) {
                    jarOutputStream.write(buffer, 0, read);
                }
                fis.close();
            }
            f.deleteOnExit();

            // META-INF/eclipselink-dbws-sessions.xml
            jarOutputStream.putNextEntry(getSessionsJarEntry());
            f = new File(packager.getStageDir(), DBWS_SESSIONS_XML);
            fis = new FileInputStream(f);
            for (int read = 0; read != -1; read = fis.read(buffer)) {
                jarOutputStream.write(buffer, 0, read);
            }
            fis.close();
            f.deleteOnExit();

            // META-INF/eclipselink-dbws.xml
            jarOutputStream.putNextEntry(getServiceJarEntry());
            f = new File(packager.getStageDir(), DBWS_SERVICE_XML);
            fis = new FileInputStream(f);
            for (int read = 0; read != -1; read = fis.read(buffer)) {
                jarOutputStream.write(buffer, 0, read);
            }
            fis.close();
            f.deleteOnExit();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getOrProjectPathPrefix() {
        return META_INF_PATHS[0];
    }
    public String getOxProjectPathPrefix() {
        return META_INF_PATHS[0];
    }
    public String getWSDLPathPrefix() {
        return WSDL_DIR;
    }
}
