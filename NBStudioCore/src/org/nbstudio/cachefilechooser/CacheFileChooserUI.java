package org.nbstudio.cachefilechooser;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.TransferHandler;
import javax.swing.UIManager;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileSystemView;
import javax.swing.plaf.metal.MetalFileChooserUI;
import org.nbstudio.cachefilesystem.CacheFileSystemView;
import org.nbstudio.cachefilesystem.CacheRootFile;
import sun.awt.shell.ShellFolder;
import sun.swing.FilePane;
import sun.swing.SwingUtilities2;

/**
 *
 * @author daimor
 */
public class CacheFileChooserUI extends MetalFileChooserUI {

    private Handler handler;
    private static final Insets shrinkwrap = new Insets(0, 0, 0, 0);
    private static final Dimension hstrut5 = new Dimension(5, 1);
    private boolean usesSingleFilePane;
    private JButton macFilesButton;
    private JButton intFilesButton;
    private JButton basFilesButton;
    private JButton clsFilesButton;
    private JButton cspFilesButton;
    private JButton mvbFilesButton;
    private ImageIcon macFilesIcon;
    private ImageIcon clsFilesIcon;
    private ImageIcon intFilesIcon;
    private ImageIcon basFilesIcon;
    private ImageIcon cspFilesIcon;
    private ImageIcon mvbFilesIcon;
    private String readonlyFlagText = null;
    private String showsystemFlagText = null;
    private String showgeneratedFlagText = null;
    private boolean readonlyFlag = false;
    private Action approveSelectionAction = new ApproveSelectionAction();
    private CacheFileChooser fileChooser;

    public CacheFileChooserUI(CacheFileChooser fileChooser) {
        super(fileChooser);
        this.fileChooser = fileChooser;
    }

    @Override
    public CacheFileChooser getFileChooser() {
        return fileChooser;
    }

    @Override
    protected void installIcons(JFileChooser fc) {
        super.installIcons(fc);
        macFilesIcon = new ImageIcon(getClass().getResource("/resources/macFilesIcon.gif"));
        intFilesIcon = new ImageIcon(getClass().getResource("/resources/intFilesIcon.gif"));
        basFilesIcon = new ImageIcon(getClass().getResource("/resources/basFilesIcon.gif"));
        clsFilesIcon = new ImageIcon(getClass().getResource("/resources/clsFilesIcon.gif"));
        cspFilesIcon = new ImageIcon(getClass().getResource("/resources/cspFilesIcon.gif"));
        mvbFilesIcon = new ImageIcon(getClass().getResource("/resources/mvbFilesIcon.gif"));
    }

    @Override
    protected void installStrings(JFileChooser fc) {
        super.installStrings(fc);

        readonlyFlagText = "Open as read-only";
        showsystemFlagText = "Include System Items";
        showgeneratedFlagText = "Show Generated";
    }

    @Override
    public void installComponents(final JFileChooser fileChooser) {
        super.installComponents(fileChooser);
        CacheFileSystemView fsv = (CacheFileSystemView) fileChooser.getFileSystemView();

        JComponent south = null;
        JComponent topButtonPanel = null;
        BorderLayout layout = (BorderLayout) fileChooser.getLayout();
        for (Component child : fileChooser.getComponents()) {
            if (BorderLayout.SOUTH == layout.getConstraints(child)) {
                south = (JComponent) child;
            }
            // search btn's panel
            if (BorderLayout.NORTH == layout.getConstraints(child)) {
                JComponent topPanel = (JComponent) child;
                BorderLayout topPanelLayout = ((BorderLayout) topPanel.getLayout());
                for (Component childTP : topPanel.getComponents()) {
                    if (BorderLayout.AFTER_LINE_ENDS == topPanelLayout.getConstraints(childTP)) {
                        topButtonPanel = (JComponent) childTP;
                    }
                }
            }
        }
        if (south != null) {
            JPanel flagsPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
            JCheckBox readonlyFlag = new JCheckBox(readonlyFlagText);
            readonlyFlag.addItemListener(new ItemListener() {
                @Override
                public void itemStateChanged(ItemEvent e) {
                    setReadOnlyFlag(e.getStateChange() == ItemEvent.SELECTED);
                }
            });
            flagsPanel.add(readonlyFlag);

            JCheckBox showsystemFlag = new JCheckBox(showsystemFlagText, fsv.getShowSystemFiles());
            showsystemFlag.addItemListener(new ItemListener() {
                @Override
                public void itemStateChanged(ItemEvent e) {
                    boolean showsystemFiles = (e.getStateChange() == ItemEvent.SELECTED);
                    CacheFileSystemView fsv = (CacheFileSystemView) fileChooser.getFileSystemView();
                    fsv.setShowSystemFiles(showsystemFiles);
                    rescanCurrentDirectory(fileChooser);
                }
            });
            flagsPanel.add(showsystemFlag);

            JCheckBox showgeneratedFlag = new JCheckBox(showgeneratedFlagText, fsv.getShowGeneratedFiles());
            showgeneratedFlag.addItemListener(new ItemListener() {
                @Override
                public void itemStateChanged(ItemEvent e) {
                    boolean showGeneratedFiles = (e.getStateChange() == ItemEvent.SELECTED);
                    CacheFileSystemView fsv = (CacheFileSystemView) fileChooser.getFileSystemView();
                    fsv.setShowGeneratedFiles(showGeneratedFiles);
                    rescanCurrentDirectory(fileChooser);
                }
            });
            flagsPanel.add(showgeneratedFlag);

            south.add(flagsPanel, BorderLayout.NORTH);

            /// not supported yet
            readonlyFlag.setEnabled(false);
        }

        if (topButtonPanel != null) {
            topButtonPanel.add(Box.createRigidArea(hstrut5));

            ButtonGroup filterButtonGroup = new ButtonGroup();
            macFilesButton = new JButton(macFilesIcon);
            macFilesButton.setMargin(shrinkwrap);
            macFilesButton.setAlignmentX(JComponent.LEFT_ALIGNMENT);
            macFilesButton.setAlignmentY(JComponent.CENTER_ALIGNMENT);
            macFilesButton.addActionListener(new filterBtnAction(1));
            topButtonPanel.add(macFilesButton);
            filterButtonGroup.add(macFilesButton);

            intFilesButton = new JButton(intFilesIcon);
            intFilesButton.setMargin(shrinkwrap);
            intFilesButton.addActionListener(new filterBtnAction(2));
            topButtonPanel.add(intFilesButton);
            filterButtonGroup.add(intFilesButton);

            basFilesButton = new JButton(basFilesIcon);
            basFilesButton.setMargin(shrinkwrap);
            basFilesButton.addActionListener(new filterBtnAction(3));
            topButtonPanel.add(basFilesButton);
            filterButtonGroup.add(basFilesButton);

            clsFilesButton = new JButton(clsFilesIcon);
            clsFilesButton.setMargin(shrinkwrap);
            clsFilesButton.addActionListener(new filterBtnAction(4));
            topButtonPanel.add(clsFilesButton);
            filterButtonGroup.add(clsFilesButton);

            cspFilesButton = new JButton(cspFilesIcon);
            cspFilesButton.setMargin(shrinkwrap);
            cspFilesButton.addActionListener(new filterBtnAction(5));
            topButtonPanel.add(cspFilesButton);
            filterButtonGroup.add(cspFilesButton);

            mvbFilesButton = new JButton(mvbFilesIcon);
            mvbFilesButton.setMargin(shrinkwrap);
            mvbFilesButton.addActionListener(new filterBtnAction(6));
            topButtonPanel.add(mvbFilesButton);
            filterButtonGroup.add(mvbFilesButton);

            // To-Do: not supported yet
            cspFilesButton.setEnabled(false);
            mvbFilesButton.setEnabled(false);

        }
    }

    private Handler getHandler() {
        if (handler == null) {
            handler = new Handler();
        }
        return handler;
    }

    @Override
    protected MouseListener createDoubleClickListener(JFileChooser fc, JList list) {
        return new Handler(list);
    }

    private class Handler implements MouseListener, ListSelectionListener {

        JList list;

        Handler() {
        }

        Handler(JList list) {
            this.list = list;
        }

        @Override
        public void mouseClicked(MouseEvent evt) {
            // Note: we can't depend on evt.getSource() because of backward
            // compatability
            if (list != null
                    && SwingUtilities.isLeftMouseButton(evt)
                    && (evt.getClickCount() % 2 == 0)) {

                int index = SwingUtilities2.loc2IndexFileList(list, evt.getPoint());
                if (index >= 0) {
                    CacheRootFile f = (CacheRootFile) list.getModel().getElementAt(index);
//                    try {
//                        // Strip trailing ".."
//                        f = ShellFolder.getNormalizedFile(f);
//                    } catch (IOException ex) {
//                        // That's ok, we'll use f as is
//                    }
                    if (f.getName().toLowerCase().endsWith(".prj")) {
                        getFileChooser().setSelectedFile(f);
                        getFileChooser().approveSelection();
                    } else if (getFileChooser().isTraversable(f)) {
                        list.clearSelection();
                        changeDirectory(f);
                    } else {
                        getFileChooser().approveSelection();
                    }
                }
            }
        }

        @Override
        public void mouseEntered(MouseEvent evt) {
            if (list != null) {
                TransferHandler th1 = getFileChooser().getTransferHandler();
                TransferHandler th2 = list.getTransferHandler();
                if (th1 != th2) {
                    list.setTransferHandler(th1);
                }
                if (getFileChooser().getDragEnabled() != list.getDragEnabled()) {
                    list.setDragEnabled(getFileChooser().getDragEnabled());
                }
            }
        }

        @Override
        public void mouseExited(MouseEvent evt) {
        }

        @Override
        public void mousePressed(MouseEvent evt) {
        }

        @Override
        public void mouseReleased(MouseEvent evt) {
        }

        @Override
        public void valueChanged(ListSelectionEvent evt) {
            if (!evt.getValueIsAdjusting()) {
                JFileChooser chooser = getFileChooser();
                FileSystemView fsv = chooser.getFileSystemView();
                JList list = (JList) evt.getSource();

                int fsm = chooser.getFileSelectionMode();
                boolean useSetDirectory = usesSingleFilePane
                        && (fsm == JFileChooser.FILES_ONLY);

                if (chooser.isMultiSelectionEnabled()) {
                    File[] files = null;
                    Object[] objects = list.getSelectedValues();
                    if (objects != null) {
                        if (objects.length == 1
                                && ((CacheRootFile) objects[0]).isDirectory()
                                && chooser.isTraversable(((CacheRootFile) objects[0]))
                                && (useSetDirectory || !fsv.isFileSystem(((CacheRootFile) objects[0])))) {
                            setDirectorySelected(true);
                            setDirectory(((CacheRootFile) objects[0]));
                        } else {
                            ArrayList<CacheRootFile> fList = new ArrayList<>(objects.length);
                            for (Object object : objects) {
                                CacheRootFile f = (CacheRootFile) object;
                                boolean isDir = f.isDirectory();
                                if ((chooser.isFileSelectionEnabled() && !isDir)
                                        || (chooser.isDirectorySelectionEnabled()
                                        && fsv.isFileSystem(f)
                                        && isDir)) {
                                    fList.add(f);
                                }
                            }
                            if (fList.size() > 0) {
                                files = fList.toArray(new File[fList.size()]);
                            }
                            setDirectorySelected(false);
                        }
                    }
                    chooser.setSelectedFiles(files);
                } else {
                    CacheRootFile file = (CacheRootFile) list.getSelectedValue();
                    if (file != null
                            && file.isDirectory()
                            && chooser.isTraversable(file)
                            && (useSetDirectory || !fsv.isFileSystem(file))) {

                        setDirectorySelected(true);
                        setDirectory(file);
                        if (usesSingleFilePane) {
                            chooser.setSelectedFile(null);
                        }
                    } else {
                        setDirectorySelected(false);
                        if (file != null) {
                            chooser.setSelectedFile(file);
                        }
                    }
                }
            }
        }
    }

    @Override
    protected void installDefaults(JFileChooser fc) {
        super.installDefaults(fc);
        usesSingleFilePane = UIManager.getBoolean("FileChooser.usesSingleFilePane");
    }

    private void changeDirectory(File dir) {
        JFileChooser fc = getFileChooser();
        // Traverse shortcuts on Windows
        if (null != dir && FilePane.usesShellFolder(fc)) {
            try {
                ShellFolder shellFolder = ShellFolder.getShellFolder(dir);

                if (shellFolder.isLink()) {
                    File linkedTo = shellFolder.getLinkLocation();

                    // If linkedTo is null we try to use dir
                    if (linkedTo != null) {
                        if (fc.isTraversable(linkedTo)) {
                            dir = linkedTo;
                        } else {
                            return;
                        }
                    } else {
                        dir = shellFolder;
                    }
                }
            } catch (FileNotFoundException ex) {
                return;
            }
        }
        fc.setCurrentDirectory(dir);
        if (fc.getFileSelectionMode() == JFileChooser.FILES_AND_DIRECTORIES
                && fc.getFileSystemView().isFileSystem(dir)) {

            setFileName(dir.getAbsolutePath());
        }
    }

    protected class filterBtnAction extends AbstractAction {

        private final int type;
        private final String extFile;
        private final CacheFileNameExtensionFilter fileFilter;

        protected filterBtnAction(int type) {
            super("filterBtnAction");
            this.type = type;
            switch (type) {
                case 1:
                    this.extFile = "mac";
                    break;
                case 2:
                    this.extFile = "int";
                    break;
                case 3:
                    this.extFile = "bas";
                    break;
                case 4:
                    this.extFile = "cls";
                    break;
                case 5:
                    this.extFile = "csp";
                    break;
                case 6:
                    this.extFile = "mvb";
                    break;
                default:
                    this.extFile = null;
                    break;
            }
            FileFilter filter = null;
            if (extFile != null) {
                CacheFileChooser fileChooser = (CacheFileChooser) getFileChooser();
                FileFilter[] filters = fileChooser.getChoosableFileFilters();
                for (FileFilter fileFilter : filters) {
                    if (fileFilter instanceof CacheFileNameExtensionFilter) {
                        String[] extensions = ((CacheFileNameExtensionFilter) fileFilter).getExtensions();
                        if (Arrays.asList(extensions).contains(extFile)) {
                            filter = fileFilter;
                        }
                    }
                }
            }
            if (filter != null) {
                fileFilter = (CacheFileNameExtensionFilter) filter;
            } else {
                fileFilter = null;
            }
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            CacheFileChooser fileChooser = (CacheFileChooser) getFileChooser();
            if (fileFilter != null) {
                fileChooser.setFileFilter(fileFilter);
            }
        }
    }

    public void setReadOnlyFlag(boolean readonlyFlag) {
        this.readonlyFlag = readonlyFlag;
    }

    public boolean getReadOnlyFlag() {
        return readonlyFlag;
    }

    @Override
    public Action getApproveSelectionAction() {
        return approveSelectionAction;
    }

    /**
     * Responds to an Open or Save request
     */
    protected class ApproveSelectionAction extends AbstractAction {

        protected ApproveSelectionAction() {
            super(FilePane.ACTION_APPROVE_SELECTION);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            CacheFileChooser chooser = getFileChooser();
            if (isDirectorySelected()) {
                File dir = getDirectory();
                if (dir != null) {
                    if (dir.getName().matches(".*\\.prj$")) {
                        chooser.setSelectedFile(dir);
                        chooser.approveSelection();
                    } else {
                        try {
                            // Strip trailing ".."
                            dir = ShellFolder.getNormalizedFile(dir);
                        } catch (IOException ex) {
                            // Ok, use f as is
                        }
                        changeDirectory(dir);
                    }
                    return;
                }
            }
            String filename = getFileName();
            CacheFileSystemView fs = (CacheFileSystemView) chooser.getFileSystemView();
            CacheRootFile dir = (CacheRootFile) chooser.getCurrentDirectory();
            if (filename
                    != null) {
                // Remove whitespaces from end of filename
                int i = filename.length() - 1;

                while (i >= 0 && filename.charAt(i) <= ' ') {
                    i--;
                }

                filename = filename.substring(0, i + 1);
            }
            if (filename
                    == null || filename.length()
                    == 0) {
                // no file selected, multiple selection off, therefore cancel the approve action
                resetGlobFilter();
                return;
            }
            CacheRootFile selectedFile = null;
            CacheRootFile[] selectedFiles = null;
            // Unix: Resolve '~' to user's home directory
            if (File.separatorChar
                    == '/') {
                if (filename.startsWith("~/")) {
                    filename = System.getProperty("user.home") + filename.substring(1);
                } else if (filename.equals("~")) {
                    filename = System.getProperty("user.home");
                }
            }

            if (chooser.isMultiSelectionEnabled()
                    && filename.length() > 1
                    && filename.charAt(0) == '"' && filename.charAt(filename.length() - 1) == '"') {
                List<CacheRootFile> fList = new ArrayList<>();

                String[] files = filename.substring(1, filename.length() - 1).split("\" \"");
                // Optimize searching files by names in "children" array
                Arrays.sort(files);

                File[] children = null;
                int childIndex = 0;

                for (String str : files) {
                    File file = fs.createFileObject(str);
                    if (!file.isAbsolute()) {
                        if (children == null) {
                            children = fs.getFiles(dir, false);
                            Arrays.sort(children);
                        }
                        for (int k = 0; k < children.length; k++) {
                            int l = (childIndex + k) % children.length;
                            if (children[l].getName().equals(str)) {
                                file = children[l];
                                childIndex = l + 1;
                                break;
                            }
                        }
                    }
                    fList.add((CacheRootFile) file);
                }

                if (!fList.isEmpty()) {
                    selectedFiles = fList.toArray(new CacheRootFile[fList.size()]);
                }
                resetGlobFilter();
            } else {
                selectedFile = fs.createFileObject(dir, filename);
                if (!selectedFile.isAbsolute()) {
                    selectedFile = (CacheRootFile) fs.getChild(dir, filename);
                }
                // check for wildcard pattern
                FileFilter currentFilter = chooser.getFileFilter();
//                if (!selectedFile.exists() && isGlobPattern(filename)) {
//                    changeDirectory(selectedFile.getParentFile());
//                    if (globFilter == null) {
//                        globFilter = new BasicFileChooserUI.GlobFilter();
//                    }
//                    try {
//                        globFilter.setPattern(selectedFile.getName());
//                        if (!(currentFilter instanceof BasicFileChooserUI.GlobFilter)) {
//                            actualFileFilter = currentFilter;
//                        }
//                        chooser.setFileFilter(null);
//                        chooser.setFileFilter(globFilter);
//                        return;
//                    } catch (PatternSyntaxException pse) {
//                        // Not a valid glob pattern. Abandon filter.
//                    }
//                }

                resetGlobFilter();

                // Check for directory change action
                boolean isDir = (selectedFile != null && selectedFile.isDirectory());
                boolean isTrav = (selectedFile != null && chooser.isTraversable(selectedFile));
                boolean isDirSelEnabled = chooser.isDirectorySelectionEnabled();
                boolean isFileSelEnabled = chooser.isFileSelectionEnabled();
                boolean isCtrl = (e != null && (e.getModifiers()
                        & Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()) != 0);

                if (isDir && isTrav && (isCtrl || !isDirSelEnabled)) {
                    changeDirectory(selectedFile);
                    return;
                } else if ((isDir || !isFileSelEnabled)
                        && (!isDir || !isDirSelEnabled)
                        && (!isDirSelEnabled || selectedFile.exists())) {
                    selectedFile = null;
                }
            }
            if (selectedFiles != null || selectedFile
                    != null) {
                if (selectedFiles != null || chooser.isMultiSelectionEnabled()) {
                    if (selectedFiles == null) {
                        selectedFiles = new CacheRootFile[]{selectedFile};
                    }
                    chooser.setSelectedFiles(selectedFiles);
                    // Do it again. This is a fix for bug 4949273 to force the
                    // selected value in case the ListSelectionModel clears it
                    // for non-existing file names.
                    chooser.setSelectedFiles(selectedFiles);
                } else {
                    chooser.setSelectedFile(selectedFile);
                }
                chooser.approveSelection();
            } else {
                if (chooser.isMultiSelectionEnabled()) {
                    chooser.setSelectedFiles(null);
                } else {
                    chooser.setSelectedFile(null);
                }
                chooser.cancelSelection();
            }
        }
    }

    private void resetGlobFilter() {
//        if (actualFileFilter != null) {
//            JFileChooser chooser = getFileChooser();
//            FileFilter currentFilter = chooser.getFileFilter();
//            if (currentFilter != null && currentFilter.equals(globFilter)) {
//                chooser.setFileFilter(actualFileFilter);
//                chooser.removeChoosableFileFilter(globFilter);
//            }
//            actualFileFilter = null;
//        }
    }
}
