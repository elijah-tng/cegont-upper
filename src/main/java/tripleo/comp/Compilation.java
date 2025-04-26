// /*
//  * Elijjah compiler, copyright Tripleo <oluoluolu+elijah@gmail.com>
//  *
//  * The contents of this library are released under the LGPL licence v3,
//  * the GNU Lesser General Public License text was downloaded from
//  * http://www.gnu.org/licenses/lgpl.html from `Version 3, 29 June 2007'
//  *
//  */
// package tripleo.comp;
//
// import org.jetbrains.annotations.NotNull;
// import tripleo.elijah.ci.CompilerInstructions;
// import tripleo.elijah.comp.i.CompilerController;
// import tripleo.elijah.comp.i.ErrSink;
// import tripleo.elijah.comp.i.ICompilationAccess;
// import tripleo.elijah.lang.ClassStatement;
// import tripleo.elijah.lang.OS_Module;
// import tripleo.elijah.lang.OS_Package;
// import tripleo.elijah.lang.Qualident;
// import tripleo.elijah.nextgen.outputtree.EOT_OutputTree;
// import tripleo.elijah.stages.deduce.DeducePhase;
// import tripleo.elijah.stages.deduce.FunctionMapHook;
// import tripleo.elijah.stages.deduce.fluffy.i.FluffyComp;
// import tripleo.elijah.stages.gen_fn.GeneratedNode;
// import tripleo.elijah.stages.logging.ElLog;
// import tripleo.elijah.testing.comp.IFunctionMapHook;
// import tripleo.elijah.world.i.LivingRepo;
// import tripleo.elijah_fluffy.comp.CM_Prelude;
// import tripleo.elijah_fluffy.comp.CM_Preludes;
// import tripleo.elijah_fluffy.util.Eventual;
// import tripleo.elijah_fluffy.util.Operation;
// import tripleo.elijah_fluffy.util.Operation2;
// import tripleo.elijah_remnant.comp.*;
// import tripleo.elijah_remnant.comp_signals.CSS2_Signal;
// import tripleo.elijah_remnant.startup.ProlificStartup2;
// import tripleo.elijah_remnant.value.ElValue;
//
// import java.io.File;
// import java.util.List;
//
// public interface Compilation {
//
//     static ElLog.Verbosity gitlabCIVerbosity() {
//         final boolean gitlab_ci = isGitlab_ci();
//         return gitlab_ci ? ElLog.Verbosity.SILENT : ElLog.Verbosity.VERBOSE;
//     }
//
//     static boolean isGitlab_ci() {
//         return System.getenv("GITLAB_CI") != null;
//     }
//
//     void testMapHooks(List<IFunctionMapHook> aMapHooks);
//
//     void feedCmdLine(@NotNull List<String> args);
//
//     void feedCmdLine(@NotNull List<String> args1, CompilerController ctl);
//
//     String getProjectName();
//
// 	IO getIO();
//
// 	ErrSink getErrSink();
//
// 	int errorCount();
//
// 	void addModule(OS_Module module, String fn);
//
// 	OS_Module fileNameToModule(String fileName);
//
//     CM_Module realParseElijjahFile(String f, @NotNull File file, boolean do_out);
//
// 	void use(@NotNull CompilerInstructions compilerInstructions, boolean do_out) throws Exception;
//
//     void pushItem(CompilerInstructions aci);
//
//     List<ClassStatement> findClass(String string);
//
//     boolean getSilence();
//
//     Operation2<OS_Module> findPrelude(String prelude_name);
//
//     void addFunctionMapHook(FunctionMapHook aFunctionMapHook);
//
// 	int compilationNumber();
//
// 	String getCompilationNumberString();
//
//     @NotNull
//     DeducePhase getDeducePhase();
//
//     int nextClassCode();
//
//     int nextFunctionCode();
//
//     OS_Package getPackage(@NotNull Qualident pkg_name);
//
//     OS_Package makePackage(Qualident pkg_name);
//
//     @Deprecated
//     int modules_size();
//
//     @NotNull
//     EOT_OutputTree getOutputTree();
//
//     @NotNull
//     FluffyComp getFluffy();
//
//     ProlificStartup2 getStartup();
//
//     ElValue<EDR_CompilationBus> get_cb();
//
//     @NotNull
//     List<GeneratedNode> getLGC();
//
//     boolean isPackage(String aPackageName);
//
//     Pipeline getPipelines();
//
//     ModuleBuilder moduleBuilder();
//
//     Finally reports();
//
//     void signal(@NotNull CSS2_Signal signal, Object payload);
//
//     Operation<CM_Prelude> findPrelude2(@NotNull CM_Preludes aPreludeTag);
//
//     Eventual<File> comp_dir_promise();
//
//     ICompilationAccess _compilationAccess();
//
//     @SuppressWarnings("UnusedReturnValue")
//     List<ElLog> getElLogs();
//
//     CompilationConfig getCfg();
//
//     LivingRepo getLivingRepo();
//
// 	EDR_CIS get_cis();
//
//     EDR_MOD getMod();
//
//     PipelineLogic getPipelineLogic();
//
//     void setPipelineLogic(PipelineLogic aPipelineLogic);
//
//     CompilerInstructionsResult.EDR_CompilationRunner getCompilationRunner();
//
// 	void writeLogs(final @NotNull List<ElLog> aLogs);
//
// 	// not slick
// 	CompilerInstructionsObserver get_cio();
//
// 	// get slick
// 	default void register1(Object obj){
// 		final EDR_Compilation edrCompilation = (EDR_Compilation) this;
// 		if (obj instanceof CompilerInstructionsObserver cio) {
// 			edrCompilation.set_cio(cio);
// 		}
// 	}
// }
//
// //
// //
// //
