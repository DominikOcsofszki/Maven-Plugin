package de.docsof2s.plugins;

/*
 * Copyright 2001-2005 The Apache Software Foundation.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Goal which touches a timestamp file.
 *
 * @goal check
 * @phase process-sources
 * @Mojo(name = "CheckStyleWomm")
 */
public class CheckStyleWomm
        extends AbstractMojo {
    /**
     * Location of the file.
     *
     * @parameter expression="${project.build.directory}"
     * @required
     */
    private File outputDirectory;

    public void execute()
            throws MojoExecutionException {
        getLog().error("###################################################");
        getLog().error("###################################################");

        getLog().error("###     Maven-Plugin by docsof2s                ###");
        getLog().error("###     Go To File /taget/docsof2sReport.txt    ###");

        getLog().error("###################################################");
        getLog().error("###################################################");

        getLog().error("------------------------------------------------------------------------");

        File f = outputDirectory;

        if (!f.exists()) {
            f.mkdirs();
        }

        File touch = new File(f, "docsof2sReport.txt");

        FileWriter w = null;
        try {
            w = new FileWriter(touch);
            w.write("Text inside target/docsof2sReport.txt");
            w.write("some more info");
            w.write("passed");
        } catch (IOException e) {
            throw new MojoExecutionException("Error creating file " + touch, e);
        } finally {
            if (w != null) {
                try {
                    w.close();
                } catch (IOException e) {
                    // ignore
                }
            }
        }
    }
}
