/*
 * MibbleBrowser.java
 *
 * This work is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published
 * by the Free Software Foundation; either version 2 of the License,
 * or (at your option) any later version.
 *
 * This work is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307
 * USA
 *
 * As a special exception, the copyright holders of this library give
 * you permission to link this library with independent modules to
 * produce an executable, regardless of the license terms of these
 * independent modules, and to copy and distribute the resulting
 * executable under terms of your choice, provided that you also meet,
 * for each linked independent module, the terms and conditions of the
 * license of that module. An independent module is a module which is
 * not derived from or based on this library. If you modify this
 * library, you may extend this exception to your version of the
 * library, but you are not obligated to do so. If you do not wish to
 * do so, delete this exception statement from your version.
 *
 * Copyright (c) 2003 Watsh Rajneesh. All rights reserved.
 */

package net.percederberg.mibble;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.tree.DefaultTreeModel;

import net.percederberg.mibble.browser.AboutDialog;
import net.percederberg.mibble.browser.MibTreeBuilder;
import net.percederberg.mibble.browser.SnmpOperation;
import net.percederberg.mibble.browser.TreeListener;

/**
 * A program for browsing a MIB file in a GUI.
 *
 * @author   Watsh Rajneesh
 * @version  2.3
 * @since    2.3
 */
public class MibbleBrowser extends JFrame {

    /**
     * The application main entry point.
     *
     * @param args           the command-line parameters
     */
    public static void main(String args[]) {
        new MibbleBrowser().show();
    }

    /** Creates new form MibbleBrowser */
    public MibbleBrowser() {
        initComponents();
        loadedMibsCache = new ArrayList();
        this.setJMenuBar(menuBar);
        mainSplitPane.setOneTouchExpandable(true);
        mainSplitPane.setDividerLocation(300);

        // Set frame size
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setSize((int) (screenSize.width * 0.90), 
                (int) (screenSize.height * 0.75));

        // Center the frame
        Rectangle frameDim = getBounds();
        setLocation((screenSize.width - frameDim.width) / 2,
                    (screenSize.height - frameDim.height) / 2);

        // Set up the tree view
        MibTreeBuilder mb = MibTreeBuilder.getInstance();
        lhsNavigationScrollPane.setViewportView(mb.mibTree);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    private void initComponents() {//GEN-BEGIN:initComponents
        java.awt.GridBagConstraints gridBagConstraints;

        fileChooser = new javax.swing.JFileChooser();
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        loadMibMenuItem = new javax.swing.JMenuItem();
        unloadMibMenuItem = new javax.swing.JMenuItem();
        exitMenuItem = new javax.swing.JMenuItem();
        helpMenu = new javax.swing.JMenu();
        aboutMenuItem = new javax.swing.JMenuItem();
        mainSplitPane = new javax.swing.JSplitPane();
        lhsNavigationScrollPane = new javax.swing.JScrollPane();
        rhsPanel = new javax.swing.JPanel();
        mibDescriptionPanel = new javax.swing.JPanel();
        mibDescriptionScrollPane = new javax.swing.JScrollPane();
        mibDescriptionTextArea = new javax.swing.JTextArea();
        resultPanel = new javax.swing.JPanel();
        resultScrollPane = new javax.swing.JScrollPane();
        resultTextArea = new javax.swing.JTextArea();
        configPanel = new javax.swing.JPanel();
        hostLabel = new javax.swing.JLabel();
        portTextField = new javax.swing.JTextField();
        portLabel = new javax.swing.JLabel();
        setLabel = new javax.swing.JLabel();
        oidLabel = new javax.swing.JLabel();
        setButton = new javax.swing.JButton();
        setTextField = new javax.swing.JTextField();
        hostTextField = new javax.swing.JTextField();
        oidTextField = new javax.swing.JTextField();
        readCommLabel = new javax.swing.JLabel();
        writeCommLabel = new javax.swing.JLabel();
        getButton = new javax.swing.JButton();
        readCommPasswordField = new javax.swing.JPasswordField();
        writeCommPasswordField = new javax.swing.JPasswordField();
        getNextButton = new javax.swing.JButton();
        clearButton = new javax.swing.JButton();
        snmpWalkButton = new javax.swing.JButton();
        statusPanel = new javax.swing.JPanel();
        statusLabel = new javax.swing.JLabel("Ready");

        fileMenu.setText("File");
        loadMibMenuItem.setText("Load MIB...");
        loadMibMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadMibMenuItemActionPerformed(evt);
            }
        });

        fileMenu.add(loadMibMenuItem);

        unloadMibMenuItem.setText("Unload MIB");
        unloadMibMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                unloadMibMenuItemActionPerformed(evt);
            }
        });

        fileMenu.add(unloadMibMenuItem);

        exitMenuItem.setText("Exit");
        exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuItemActionPerformed(evt);
            }
        });

        fileMenu.add(exitMenuItem);

        menuBar.add(fileMenu);

        helpMenu.setText("Help");
        aboutMenuItem.setText("About");
        aboutMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutMenuItemActionPerformed(evt);
            }
        });

        helpMenu.add(aboutMenuItem);

        menuBar.add(helpMenu);

        setTitle("Mibble Browser");
        setBackground(new java.awt.Color(255, 255, 204));
        setForeground(java.awt.Color.black);
        setName("mbAppFrame");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                exitForm(evt);
            }
        });

        lhsNavigationScrollPane.setToolTipText("MIB Tree Navigation");
        mainSplitPane.setLeftComponent(lhsNavigationScrollPane);

        rhsPanel.setLayout(new java.awt.BorderLayout());

        mibDescriptionPanel.setLayout(new java.awt.BorderLayout());

        mibDescriptionScrollPane.setMinimumSize(new java.awt.Dimension(100, 300));
        mibDescriptionScrollPane.setPreferredSize(new java.awt.Dimension(100, 300));
        mibDescriptionScrollPane.setViewportView(mibDescriptionTextArea);

        mibDescriptionPanel.add(mibDescriptionScrollPane, java.awt.BorderLayout.CENTER);

        rhsPanel.add(mibDescriptionPanel, java.awt.BorderLayout.SOUTH);

        resultPanel.setLayout(new java.awt.BorderLayout());

        resultTextArea.setEditable(false);
        resultTextArea.setLineWrap(true);
        resultTextArea.setWrapStyleWord(true);
        resultScrollPane.setViewportView(resultTextArea);

        resultPanel.add(resultScrollPane, java.awt.BorderLayout.CENTER);

        rhsPanel.add(resultPanel, java.awt.BorderLayout.CENTER);

        configPanel.setLayout(new java.awt.GridBagLayout());

        configPanel.setToolTipText("Enter set value");
        hostLabel.setText("Host IP Address");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 7);
        configPanel.add(hostLabel, gridBagConstraints);

        portTextField.setColumns(15);
        portTextField.setText("161");
        portTextField.setToolTipText("Enter ip address");
        portTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                portTextFieldActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 7);
        configPanel.add(portTextField, gridBagConstraints);

        portLabel.setText("Port Number");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 7);
        configPanel.add(portLabel, gridBagConstraints);

        setLabel.setText("Set Value");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 7);
        configPanel.add(setLabel, gridBagConstraints);

        oidLabel.setText("OID");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 7);
        configPanel.add(oidLabel, gridBagConstraints);

        setButton.setText("Set");
        setButton.setToolTipText("Perform SNMP Set");
        setButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setButtonActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 7);
        configPanel.add(setButton, gridBagConstraints);

        setTextField.setColumns(30);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 7);
        configPanel.add(setTextField, gridBagConstraints);

        hostTextField.setColumns(15);
        hostTextField.setText("127.0.0.1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 7);
        configPanel.add(hostTextField, gridBagConstraints);

        oidTextField.setColumns(30);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 7);
        configPanel.add(oidTextField, gridBagConstraints);

        readCommLabel.setText("Read Community");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 7);
        configPanel.add(readCommLabel, gridBagConstraints);

        writeCommLabel.setText("Write Community");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 7);
        configPanel.add(writeCommLabel, gridBagConstraints);

        getButton.setText("Get");
        getButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                getButtonActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 7);
        configPanel.add(getButton, gridBagConstraints);

        readCommPasswordField.setColumns(8);
        readCommPasswordField.setText("public");
        readCommPasswordField.setToolTipText("Enter Read Community Name");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        configPanel.add(readCommPasswordField, gridBagConstraints);

        writeCommPasswordField.setColumns(8);
        writeCommPasswordField.setText("public");
        writeCommPasswordField.setToolTipText("Enter Write Community Name");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        configPanel.add(writeCommPasswordField, gridBagConstraints);

        getNextButton.setText("Get Next");
        getNextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                getNextButtonActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 7);
        configPanel.add(getNextButton, gridBagConstraints);

        clearButton.setText("Clear Result");
        clearButton.setToolTipText("Clear Result Area Text");
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 7);
        configPanel.add(clearButton, gridBagConstraints);

        snmpWalkButton.setText("Walk");
        snmpWalkButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                snmpWalkButtonActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 7);
        configPanel.add(snmpWalkButton, gridBagConstraints);

        rhsPanel.add(configPanel, java.awt.BorderLayout.NORTH);

        mainSplitPane.setRightComponent(rhsPanel);

        getContentPane().add(mainSplitPane, java.awt.BorderLayout.CENTER);

        statusPanel.add(statusLabel);

        getContentPane().add(statusPanel, java.awt.BorderLayout.SOUTH);

        pack();
    }//GEN-END:initComponents

    void unloadMibMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_unloadMibMenuItemActionPerformed
        String selectedMibName = mibDescriptionTextArea.getText();

        // Check if it is a valid MIB name
        for (int i = 0; i < loadedMibsCache.size(); i++) {
            if (selectedMibName.equals(loadedMibsCache.get(i))) {
                if (MibTreeBuilder.getInstance().unloadMib(selectedMibName)) {
                    // Update the cache
                    loadedMibsCache.remove(i);
                }
                return;
            }
        }
    }//GEN-LAST:event_unloadMibMenuItemActionPerformed

    void snmpWalkButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_snmpWalkButtonActionPerformed
        SnmpOperation  operation = createSnmpOperation(true);
        String         oidToWalk = oidTextField.getText();

        resultTextArea.append("\nGetNext: " + 
                              operation.snmpWalk(oidToWalk, resultTextArea));
    }//GEN-LAST:event_snmpWalkButtonActionPerformed

    void getNextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_getNextButtonActionPerformed
        SnmpOperation  operation = createSnmpOperation(true);
        String         oidToGet = oidTextField.getText();

        resultTextArea.append("\nGetNext: " + 
                              operation.sendGetNextRequest(oidToGet));
    }//GEN-LAST:event_getNextButtonActionPerformed

    void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtonActionPerformed
        resultTextArea.setText("");
    }//GEN-LAST:event_clearButtonActionPerformed

    void getButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_getButtonActionPerformed
        SnmpOperation  operation = createSnmpOperation(true);
        String         oidToGet = this.oidTextField.getText();

        resultTextArea.append("\nGet: " + 
                              operation.sendGetRequest(oidToGet));
    }//GEN-LAST:event_getButtonActionPerformed

    void setButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_setButtonActionPerformed
        SnmpOperation  operation = createSnmpOperation(false);
        String         oidToSet = this.oidTextField.getText();
        String         setValue = this.setTextField.getText();

        operation.sendSetRequest(oidToSet, setValue);
    }//GEN-LAST:event_setButtonActionPerformed

    void aboutMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutMenuItemActionPerformed
        JDialog  dialog = new AboutDialog(this, true);

        dialog.show();
    }//GEN-LAST:event_aboutMenuItemActionPerformed

    void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitMenuItemActionPerformed

    /**
     * Load MIB Action Event Handler.
     */
    void loadMibMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadMibMenuItemActionPerformed
        this.statusLabel.setText("Loading MIB...");
        this.fileChooser.setMultiSelectionEnabled(true);
        this.fileChooser.showOpenDialog(this);
        
        java.io.File[] selFiles = this.fileChooser.getSelectedFiles();
        Mib mib = null;
        MibTreeBuilder mb = MibTreeBuilder.getInstance();
        StringBuffer namesOfMibsLoaded = new StringBuffer();
        boolean alreadyLoaded = false;
        
        // Try loading all chosen files.
        for (int i = 0; i < selFiles.length; i++) {
            try {
                mib = mb.loadMib(selFiles[i]);
            } catch (MibLoaderException e) {
                e.getLog().printTo(System.err);
                resultTextArea.append(e.getMessage());
                continue;
            } catch (FileNotFoundException e) {
                System.err.println(e.getMessage());
                resultTextArea.append(e.getMessage());
                continue;
            }
            // Check if MIB is not already loaded
            for (int j = 0; j < loadedMibsCache.size(); j++) {
                if (mib.getName().equals((String)loadedMibsCache.get(j))) {
                    // MIB already loaded.
                    this.statusLabel.setText(mib.getName() + " Already Loaded.");
                    alreadyLoaded = true;
                    break;
                }
            }
            // If mib already loaded, then skip tree creation.
            if (alreadyLoaded) {
                alreadyLoaded = false;
                continue;
            }
            
            // Create MIB Sub Tree.
            mb.addMib(mib);
            mb.mibTree.addTreeSelectionListener( 
                                new TreeListener(mb.mibTree, 
                                                 oidTextField, 
                                                 mibDescriptionTextArea)
                                            );           
            loadedMibsCache.add(mib.getName());
            namesOfMibsLoaded.append(mib.getName() + ", ");
        }
        this.statusLabel.setText(namesOfMibsLoaded.toString() + " Loaded."); 
        ((DefaultTreeModel) mb.mibTree.getModel()).reload();
        mb.mibTree.repaint();
    }//GEN-LAST:event_loadMibMenuItemActionPerformed

    void portTextFieldActionPerformed(ActionEvent evt) {//GEN-FIRST:event_portTextFieldActionPerformed
    }//GEN-LAST:event_portTextFieldActionPerformed

    /**
     * Exit the Application
     */
    void exitForm(WindowEvent evt) {//GEN-FIRST:event_exitForm
        System.exit(0);
    }//GEN-LAST:event_exitForm

    /**
     * Creates a new SNMP operation object. The values in the host, 
     * port and community fields will be used.
     * 
     * @param read           the read flag (set to use read community)
     *
     * @return the SNMP operation object, or
     *         null if none could be created 
     */
    private SnmpOperation createSnmpOperation(boolean read) {
        String  host = hostTextField.getText();
        int     port = 0;
        String  community;
        String  message;

        // Validate port number
        try {
            port = Integer.parseInt(portTextField.getText());
        } catch (NumberFormatException nfe) {
            nfe.printStackTrace();
            message = "Error: Provide valid (numeric) port number in " +
                      "the range [0..65536].";
            JOptionPane.showMessageDialog(this, message);
            return null;
        }
        if (port < 0 || port > 65536) {
            message = "Error: Provide valid (numeric) port number in " +
                      "the range [0..65536].";
            JOptionPane.showMessageDialog(this, message);
            return null;
        }

        if (read) {
            community = new String(readCommPasswordField.getPassword());
        } else {
            community = new String(writeCommPasswordField.getPassword());
        }

        // Create SNMP operation
        return new SnmpOperation(host, port, community);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem aboutMenuItem;
    private javax.swing.JButton clearButton;
    private javax.swing.JPanel configPanel;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JFileChooser fileChooser;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JButton getButton;
    private javax.swing.JButton getNextButton;
    private javax.swing.JMenu helpMenu;
    private javax.swing.JLabel hostLabel;
    private javax.swing.JTextField hostTextField;
    private javax.swing.JScrollPane lhsNavigationScrollPane;
    private javax.swing.JMenuItem loadMibMenuItem;
    private javax.swing.JSplitPane mainSplitPane;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JPanel mibDescriptionPanel;
    private javax.swing.JScrollPane mibDescriptionScrollPane;
    private javax.swing.JTextArea mibDescriptionTextArea;
    private javax.swing.JLabel oidLabel;
    private javax.swing.JTextField oidTextField;
    private javax.swing.JLabel portLabel;
    private javax.swing.JTextField portTextField;
    private javax.swing.JLabel readCommLabel;
    private javax.swing.JPasswordField readCommPasswordField;
    private javax.swing.JPanel resultPanel;
    private javax.swing.JScrollPane resultScrollPane;
    private javax.swing.JTextArea resultTextArea;
    private javax.swing.JPanel rhsPanel;
    private javax.swing.JButton setButton;
    private javax.swing.JLabel setLabel;
    private javax.swing.JTextField setTextField;
    private javax.swing.JButton snmpWalkButton;
    private javax.swing.JLabel statusLabel;
    private javax.swing.JPanel statusPanel;
    private javax.swing.JMenuItem unloadMibMenuItem;
    private javax.swing.JLabel writeCommLabel;
    private javax.swing.JPasswordField writeCommPasswordField;
    // End of variables declaration//GEN-END:variables
    private ArrayList loadedMibsCache;
}
