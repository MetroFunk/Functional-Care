// Generated from /home/jordan/IdeaProjects/FunctionalCare/FunctionalCare.g4 by ANTLR 4.5.1
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link FunctionalCareParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface FunctionalCareVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link FunctionalCareParser#func}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunc(FunctionalCareParser.FuncContext ctx);
	/**
	 * Visit a parse tree produced by {@link FunctionalCareParser#mainFunc}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMainFunc(FunctionalCareParser.MainFuncContext ctx);
	/**
	 * Visit a parse tree produced by {@link FunctionalCareParser#call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCall(FunctionalCareParser.CallContext ctx);
	/**
	 * Visit a parse tree produced by {@link FunctionalCareParser#cons}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCons(FunctionalCareParser.ConsContext ctx);
	/**
	 * Visit a parse tree produced by {@link FunctionalCareParser#def}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDef(FunctionalCareParser.DefContext ctx);
	/**
	 * Visit a parse tree produced by {@link FunctionalCareParser#nombreFuncion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNombreFuncion(FunctionalCareParser.NombreFuncionContext ctx);
	/**
	 * Visit a parse tree produced by {@link FunctionalCareParser#params}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParams(FunctionalCareParser.ParamsContext ctx);
	/**
	 * Visit a parse tree produced by {@link FunctionalCareParser#param}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParam(FunctionalCareParser.ParamContext ctx);
	/**
	 * Visit a parse tree produced by {@link FunctionalCareParser#args}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgs(FunctionalCareParser.ArgsContext ctx);
	/**
	 * Visit a parse tree produced by {@link FunctionalCareParser#returnFunct}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnFunct(FunctionalCareParser.ReturnFunctContext ctx);
	/**
	 * Visit a parse tree produced by {@link FunctionalCareParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(FunctionalCareParser.ExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link FunctionalCareParser#funcionUsuario}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncionUsuario(FunctionalCareParser.FuncionUsuarioContext ctx);
	/**
	 * Visit a parse tree produced by {@link FunctionalCareParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtom(FunctionalCareParser.AtomContext ctx);
	/**
	 * Visit a parse tree produced by {@link FunctionalCareParser#atomnum}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtomnum(FunctionalCareParser.AtomnumContext ctx);
	/**
	 * Visit a parse tree produced by {@link FunctionalCareParser#atomid}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtomid(FunctionalCareParser.AtomidContext ctx);
	/**
	 * Visit a parse tree produced by {@link FunctionalCareParser#atombool}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtombool(FunctionalCareParser.AtomboolContext ctx);
	/**
	 * Visit a parse tree produced by {@link FunctionalCareParser#atomnull}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtomnull(FunctionalCareParser.AtomnullContext ctx);
	/**
	 * Visit a parse tree produced by {@link FunctionalCareParser#parfuntions1}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParfuntions1(FunctionalCareParser.Parfuntions1Context ctx);
	/**
	 * Visit a parse tree produced by {@link FunctionalCareParser#parfuntions2}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParfuntions2(FunctionalCareParser.Parfuntions2Context ctx);
	/**
	 * Visit a parse tree produced by {@link FunctionalCareParser#datatypes}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDatatypes(FunctionalCareParser.DatatypesContext ctx);
	/**
	 * Visit a parse tree produced by {@link FunctionalCareParser#operatorsdos}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOperatorsdos(FunctionalCareParser.OperatorsdosContext ctx);
	/**
	 * Visit a parse tree produced by {@link FunctionalCareParser#operatorsuno}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOperatorsuno(FunctionalCareParser.OperatorsunoContext ctx);
	/**
	 * Visit a parse tree produced by {@link FunctionalCareParser#operatorstres}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOperatorstres(FunctionalCareParser.OperatorstresContext ctx);
	/**
	 * Visit a parse tree produced by {@link FunctionalCareParser#intop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntop(FunctionalCareParser.IntopContext ctx);
	/**
	 * Visit a parse tree produced by {@link FunctionalCareParser#relationalop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelationalop(FunctionalCareParser.RelationalopContext ctx);
	/**
	 * Visit a parse tree produced by {@link FunctionalCareParser#logicoparity2}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicoparity2(FunctionalCareParser.Logicoparity2Context ctx);
	/**
	 * Visit a parse tree produced by {@link FunctionalCareParser#logicoparity1}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicoparity1(FunctionalCareParser.Logicoparity1Context ctx);
	/**
	 * Visit a parse tree produced by {@link FunctionalCareParser#logicoparity3}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicoparity3(FunctionalCareParser.Logicoparity3Context ctx);
	/**
	 * Visit a parse tree produced by {@link FunctionalCareParser#parintfunc2}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParintfunc2(FunctionalCareParser.Parintfunc2Context ctx);
	/**
	 * Visit a parse tree produced by {@link FunctionalCareParser#parintfunc1}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParintfunc1(FunctionalCareParser.Parintfunc1Context ctx);
	/**
	 * Visit a parse tree produced by {@link FunctionalCareParser#parboolfunc2}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParboolfunc2(FunctionalCareParser.Parboolfunc2Context ctx);
	/**
	 * Visit a parse tree produced by {@link FunctionalCareParser#parboolfunc1}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParboolfunc1(FunctionalCareParser.Parboolfunc1Context ctx);
}