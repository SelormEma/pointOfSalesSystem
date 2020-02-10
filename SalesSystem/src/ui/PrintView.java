package ui;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import java.sql.*;
import java.awt.print.*;
import javax.swing.plaf.basic.*;
import javax.swing.*;
import javax.swing.text.*;
import javax.swing.event.*;
import javax.swing.border.*;
import javax.swing.text.rtf.*;
import javax.swing.undo.*;


public class PrintView extends BoxView {
	
	protected int m_firstOnPage = 0;
    protected int m_lastOnPage = 0;
    protected int m_pageIndex = 0;
     
    public PrintView(Element elem, View root, int w, int h) {
        super(elem, Y_AXIS);
        setParent(root);
        setSize(w, h);
        layout(w, h);
    }
     
    public boolean paintPage(Graphics g, int hPage,
    int pageIndex) {
        if (pageIndex > m_pageIndex) {
            m_firstOnPage = m_lastOnPage + 1;
            if (m_firstOnPage >= getViewCount())
                return false;
            m_pageIndex = pageIndex;
        }
        int yMin = getOffset(Y_AXIS, m_firstOnPage);
        int yMax = yMin + hPage;
        Rectangle rc = new Rectangle();
         
        for (int k = m_firstOnPage; k < getViewCount(); k++) {
            rc.x = getOffset(X_AXIS, k);
            rc.y = getOffset(Y_AXIS, k);
            rc.width = getSpan(X_AXIS, k);
            rc.height = getSpan(Y_AXIS, k);
            if (rc.y+rc.height > yMax)
                break;
            m_lastOnPage = k;
            rc.y -= yMin;
            paintChild(g, rc, k);
        }
        return true;
    }


}
