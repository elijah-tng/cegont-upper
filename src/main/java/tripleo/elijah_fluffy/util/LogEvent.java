/*
 * Elijjah compiler, copyright Tripleo <oluoluolu+elijah@gmail.com>
 *
 * The contents of this library are released under the LGPL licence v3,
 * the GNU Lesser General Public License text was downloaded from
 * http://www.gnu.org/licenses/lgpl.html from `Version 3, 29 June 2007'
 *
 */
package tripleo.elijah_fluffy.util;

/**
 * Created 8/15/20 3:52 PM
 */
public class LogEvent {
    public static void logEvent(final int number, final String message) {
        SimplePrintLoggerToRemoveSoon.println_err2(number + " " + message);
    }
}

//
//
//
