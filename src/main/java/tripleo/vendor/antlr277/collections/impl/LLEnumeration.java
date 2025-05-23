package tripleo.vendor.antlr277.collections.impl;

/* ANTLR Translator Generator
 * Project led by Terence Parr at http://www.cs.usfca.edu
 * Software rights: http://www.tripleo.vendor.antlr277.org/license.html
 *
 * $Id: //depot/code/org.antlr/release/antlr-2.7.7/antlr/collections/impl/LLEnumeration.java#2 $
 */

import java.util.*;

/**An enumeration of a LList.  Maintains a cursor through the list.
 * bad things would happen if the list changed via another thread
 * while we were walking this list.
 */
final class LLEnumeration implements Enumeration {
    LLCell cursor;
    LList list;

    /**Create an enumeration attached to a LList*/
    public LLEnumeration(LList l) {
        list = l;
        cursor = list.head;
    }

    /** Return true/false depending on whether there are more
     * elements to enumerate.
     */
    public boolean hasMoreElements() {
        if (cursor != null) return true;
        else return false;
    }

    /**Get the next element in the enumeration.  Destructive in that
     * the returned element is removed from the enumeration.  This
     * does not affect the list itself.
     * @return the next object in the enumeration.
     */
    public Object nextElement() {
        if (!hasMoreElements()) throw new NoSuchElementException();
        LLCell p = cursor;
        cursor = cursor.next;
        return p.data;
    }
}
