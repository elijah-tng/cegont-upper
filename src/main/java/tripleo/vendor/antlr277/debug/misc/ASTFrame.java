package tripleo.vendor.antlr277.debug.misc;

/* ANTLR Translator Generator
 * Project led by Terence Parr at http://www.cs.usfca.edu
 * Software rights: http://www.tripleo.vendor.antlr277.org/license.html
 *
 * $Id: //depot/code/org.antlr/release/antlr-2.7.7/antlr/debug/misc/ASTFrame.java#2 $
 */

import tripleo.vendor.antlr277.ASTFactory;
import tripleo.vendor.antlr277.CommonAST;
import tripleo.vendor.antlr277.collections.AST;

import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.TreePath;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ASTFrame extends JFrame {
    // The initial width and height of the frame
    static final int WIDTH = 200;
    static final int HEIGHT = 300;

    public ASTFrame(String lab, AST r) {
        super(lab);

        // Create the TreeSelectionListener
        TreeSelectionListener listener = new MyTreeSelectionListener();
        JTreeASTPanel tp = new JTreeASTPanel(new JTreeASTModel(r), null);
        Container content = getContentPane();
        content.add(tp, BorderLayout.CENTER);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                Frame f = (Frame) e.getSource();
                f.setVisible(false);
                f.dispose();
                // System.exit(0);
            }
        });
        setSize(WIDTH, HEIGHT);
    }

    public static void main(String args[]) {
        // Create the tree nodes
        ASTFactory factory = new ASTFactory();
        CommonAST  r       = (CommonAST) factory.create(0, "ROOT");
        r.addChild((CommonAST) factory.create(0, "C1"));
        r.addChild((CommonAST) factory.create(0, "C2"));
        r.addChild((CommonAST) factory.create(0, "C3"));

        ASTFrame frame = new ASTFrame("AST JTree Example", r);
        frame.setVisible(true);
    }

    class MyTreeSelectionListener implements TreeSelectionListener {
        public void valueChanged(TreeSelectionEvent event) {
            TreePath path = event.getPath();
            System.out.println("Selected: " + path.getLastPathComponent());
            Object elements[] = path.getPath();
            for (int i = 0; i < elements.length; i++) {
                System.out.print("->" + elements[i]);
            }
            System.out.println();
        }
    }
}
