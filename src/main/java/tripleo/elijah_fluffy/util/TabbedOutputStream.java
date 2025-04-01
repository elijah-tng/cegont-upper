/*
 * Elijjah compiler, copyright Tripleo <oluoluolu+elijah@gmail.com>
 *
 * The contents of this library are released under the LGPL licence v3,
 * the GNU Lesser General Public License text was downloaded from
 * http://www.gnu.org/licenses/lgpl.html from `Version 3, 29 June 2007'
 *
 */
package tripleo.elijah_fluffy.util;

import org.jetbrains.annotations.*;

import java.io.*;

public class TabbedOutputStream {

	int tabwidth;
	@Nullable Writer  myStream;
	private boolean dont_close = false;
	private   boolean do_tabs = false;

	public TabbedOutputStream(final OutputStream os) {
		tabwidth = 0;
		if (os == System.out) dont_close = true;
		myStream = new BufferedWriter(new OutputStreamWriter(os));
	}

	public TabbedOutputStream(final Writer w, final boolean buffer_it) {
		tabwidth = 0;
		//if (os == System.out) dont_close = true;
		if (buffer_it)
			myStream = new BufferedWriter(w);//new BufferedWriter(new OutputStreamWriter(os));
		else
			myStream = w;
	}

	public static void main(final String[] args) {
		final TabbedOutputStream tos = new TabbedOutputStream(System.out);
//		int i = 0;
//		int j = 0;
		try {
//			for (; i < 10; i++) {
//				tos.put_string_ln((Integer.valueOf(i)).toString());
//				tos.incr_tabs();
//			}

			{
				tos.put_string_ln("class Class {");
				tos.incr_tabs();

				tos.put_string_ln("public void main() {");
//				put_function_def((FunctionDef)item, tos);
				tos.put_string_ln("}");

				tos.dec_tabs();
				tos.put_string_ln("}");

			}

			tos.close();
		} catch (final IOException ex) {
			SimplePrintLoggerToRemoveSoon.println2("error");
		}
	}

	public void put_string_ln(final String s) throws IOException {
		if (!is_connected())
			throw new IllegalStateException("is_connected assertion failed");

		if (do_tabs)
			doIndent();
		myStream.write(s);
		myStream.write('\n');
//		doIndent();
		do_tabs = true;
	}

	public void incr_tabs() {
		tabwidth++;
	}

	public void dec_tabs() {
		tabwidth--;
	}

	public void close() throws IOException {
		if (!is_connected())
			throw new IllegalStateException("is_connected assertion failed; closing twice");

		if (!dont_close)
			myStream.close();
		myStream = null;
	}

	public boolean is_connected() {
		return myStream != null;
	}

	void doIndent() throws IOException {
		for (int i = 0; i < tabwidth; i++)
		     myStream.write('\t');
	}

	public void put_string_ln_no_tabs(final String s) throws IOException {
		if (!is_connected())
			throw new IllegalStateException("is_connected assertion failed");

		myStream.write(s);
		myStream.write('\n');
//		do_tabs = true;
	}

	public void put_string(final String s) throws IOException {
		if (!is_connected())
			throw new IllegalStateException("is_connected assertion failed");

//		if (do_tabs)
//			doIndent();
		myStream.write(s);
//		do_tabs = false;
	}

	public void put_newline() throws IOException {
		doIndent();
	}

	public int t() {
		return tabwidth;
	}

	public void quote_string(final @NotNull String s) throws IOException {
		if (!is_connected())
			throw new IllegalStateException("is_connected assertion failed");

		myStream.write(34);
		myStream.write(s);
		myStream.write(34);
	}

	public void flush() throws IOException {
		myStream.flush();
	}

	public Writer getStream() {
		return myStream;
	}
}

//
//
//
