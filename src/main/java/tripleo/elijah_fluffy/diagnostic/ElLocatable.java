/*
 * Elijjah compiler, copyright Tripleo <oluoluolu+elijah@gmail.com>
 *
 * The contents of this library are released under the LGPL licence v3,
 * the GNU Lesser General Public License text was downloaded from
 * http://www.gnu.org/licenses/lgpl.html from `Version 3, 29 June 2007'
 *
 */

package tripleo.elijah_fluffy.diagnostic;

import java.io.*;

/**
 * Locate a Token or Token range<br><br>
 * <p>
 * All methods return 0 or null for artificial Tokens<br><br>
 * <p>
 * Created 12/26/20 5:32 AM
 */
public interface ElLocatable {
	int getLine();

	int getColumn();

	int getLineEnd();

	int getColumnEnd();

	File getFile();

	enum LocatableKind {
		QuerySearchEzFiles {
			@Override
			public boolean isQuery() {
				return true;
			}

			@Override
			public boolean isSpan() {
				return false;
			}
		}, TextSpan {
			@Override
			public boolean isQuery() {
				return false;
			}

			@Override
			public boolean isSpan() {
				return true;
			}
		};

		public abstract boolean isQuery();

		public abstract boolean isSpan();
	}
}

//
//
//
