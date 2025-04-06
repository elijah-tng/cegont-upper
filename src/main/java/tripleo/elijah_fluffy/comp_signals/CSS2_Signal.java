// package tripleo.elijah_fluffy.comp_signals;
//
// import tripleo.elijah.comp.*;
//
// /**
//  * Intent
//  * <p>
//  * Encapsulate (actual) logic, passing in Compilation
//  * Maybe should pass in ICompilationAccess
//  * Meant to operate non-serially (as opposed to Comp.Bus)
//  */
// public interface CSS2_Signal {
// 	void doTrigger(Compilation compilation, Object payload);
//
// 	default void trigger(Compilation compilation, Object payload) {
// 		try {
// 			doTrigger(compilation, payload);
// 		} catch (Throwable t) {
// 			compilation.getErrSink().exception(t);
// 		}
// 	}
// }
