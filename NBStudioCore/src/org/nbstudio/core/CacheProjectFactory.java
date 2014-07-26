/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.nbstudio.core;

import java.io.IOException;
import org.nbstudio.cachefilesystem.CacheFileObject;
import org.netbeans.api.project.Project;
import org.netbeans.spi.project.ProjectFactory;
import org.netbeans.spi.project.ProjectState;
import org.openide.filesystems.FileObject;
import org.openide.util.lookup.ServiceProvider;

/**
 *
 * @author daimor
 */
@ServiceProvider(service = ProjectFactory.class)
public class CacheProjectFactory implements ProjectFactory {

    @Override
    public boolean isProject(FileObject prj) {
        if (prj instanceof CacheFileObject) {
            return prj.getExt().equalsIgnoreCase("prj") || prj.isRoot();
        } else {
            return false;
        }
    }

    @Override
    public Project loadProject(FileObject prj, ProjectState state) throws IOException {
        return isProject(prj) ? new CacheProject(prj, state) : null;
    }

    @Override
    public void saveProject(Project project) throws IOException, ClassCastException {
    }
}
