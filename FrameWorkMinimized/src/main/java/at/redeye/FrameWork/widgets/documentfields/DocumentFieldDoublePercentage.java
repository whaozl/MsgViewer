/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package at.redeye.FrameWork.widgets.documentfields;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;
import org.apache.log4j.Logger;

/**
 *
 * @author martin
 */
public class DocumentFieldDoublePercentage extends PlainDocument {        
            

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    protected static Logger logger = Logger.getLogger(DocumentFieldDoublePercentage.class.getName());

	@Override
    public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {                
        
        if( str != null )           
        {
            if( str.matches("[0-9,\\.\\-\\+]+"))
            {
                String all = getText(0, getLength()) + str;
                
                if( all.length() > 0 )
                {
                    try {
                        Double num = Double.parseDouble(all);

                        if (num > 0 && num <= 100.0) {
                            super.insertString(offs, str, a);
                        }
                    } catch (RuntimeException ex) {
                        logger.error("Error parsing: " + all + "\n" + ex);
                    }
                }
            }
        }
    }
        
}
