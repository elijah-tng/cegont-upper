package tripleo.vendor.antlr277.collections.impl;

/* ANTLR Translator Generator
 * Project led by Terence Parr at http://www.cs.usfca.edu
 * Software rights: http://www.tripleo.vendor.antlr277.org/license.html
 *
 * $Id: //depot/code/org.antlr/release/antlr-2.7.7/antlr/collections/impl/VectorEnumerator.java#2 $
 */

import java.util.*;

// based on java.lang.Vector; returns any null indices between non-null ones.

class VectorEnumerator implements Enumeration {
    Vector vector;
    int i;

    VectorEnumerator(Vector v) {
        vector = v;
        i = 0;
    }

    public boolean hasMoreElements() {
        synchronized (vector) {
            return i <= vector.lastElement;
        }
    }

    public Object nextElement() {
        synchronized (vector) {
            if (i <= vector.lastElement) {
                return vector.data[i++];
            }
            throw new NoSuchElementException("VectorEnumerator");
        }
    }
}
