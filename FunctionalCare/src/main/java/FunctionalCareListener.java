// Generated from /home/jordan/IdeaProjects/FunctionalCare/FunctionalCare.g4 by ANTLR 4.5.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link FunctionalCareParser}.
 */
public interface FunctionalCareListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link FunctionalCareParser#func}.
	 * @param ctx the parse tree
	 */
	void enterFunc(FunctionalCareParser.FuncContext ctx);
	/**
	 * Exit a parse tree produced by {@link FunctionalCareParser#func}.
	 * @param ctx the parse tree
	 */
	void exitFunc(FunctionalCareParser.FuncContext ctx);
	/**
	 * Enter a parse tree produced by {@link FunctionalCareParser#mainFunc}.
	 * @param ctx the parse tree
	 */
	void enterMainFunc(FunctionalCareParser.MainFuncContext ctx);
	/**
	 * Exit a parse tree produced by {@link FunctionalCareParser#mainFunc}.
	 * @param ctx the parse tree
	 */
	void exitMainFunc(FunctionalCareParser.MainFuncContext ctx);
	/**
	 * Enter a parse tree produced by {@link FunctionalCareParser#call}.
	 * @param ctx the parse tree
	 */
	void enterCall(FunctionalCareParser.CallContext ctx);
	/**
	 * Exit a parse tree produced by {@link FunctionalCareParser#call}.
	 * @param ctx the parse tree
	 */
	void exitCall(FunctionalCareParser.CallContext ctx);
	/**
	 * Enter a parse tree produced by {@link FunctionalCareParser#cons}.
	 * @param ctx the parse tree
	 */
	void enterCons(FunctionalCareParser.ConsContext ctx);
	/**
	 * Exit a parse tree produced by {@link FunctionalCareParser#cons}.
	 * @param ctx the parse tree
	 */
	void exitCons(FunctionalCareParser.ConsContext ctx);
	/**
	 * Enter a parse tree produced by {@link FunctionalCareParser#def}.
	 * @param ctx the parse tree
	 */
	void enterDef(FunctionalCareParser.DefContext ctx);
	/**
	 * Exit a parse tree produced by {@link FunctionalCareParser#def}.
	 * @param ctx the parse tree
	 */
	void exitDef(FunctionalCareParser.DefContext ctx);
	/**
	 * Enter a parse tree produced by {@link FunctionalCareParser#nombreFuncion}.
	 * @param ctx the parse tree
	 */
	void enterNombreFuncion(FunctionalCareParser.NombreFuncionContext ctx);
	/**
	 * Exit a parse tree produced by {@link FunctionalCareParser#nombreFuncion}.
	 * @param ctx the parse tree
	 */
	void exitNombreFuncion(FunctionalCareParser.NombreFuncionContext ctx);
	/**
	 * Enter a parse tree produced by {@link FunctionalCareParser#params}.
	 * @param ctx the parse tree
	 */
	void enterParams(FunctionalCareParser.ParamsContext ctx);
	/**
	 * Exit a parse tree produced by {@link FunctionalCareParser#params}.
	 * @param ctx the parse tree
	 */
	void exitParams(FunctionalCareParser.ParamsContext ctx);
	/**
	 * Enter a parse tree produced by {@link FunctionalCareParser#param}.
	 * @param ctx the parse tree
	 */
	void enterParam(FunctionalCareParser.ParamContext ctx);
	/**
	 * Exit a parse tree produced by {@link FunctionalCareParser#param}.
	 * @param ctx the parse tree
	 */
	void exitParam(FunctionalCareParser.ParamContext ctx);
	/**
	 * Enter a parse tree produced by {@link FunctionalCareParser#args}.
	 * @param ctx the parse tree
	 */
	void enterArgs(FunctionalCareParser.ArgsContext ctx);
	/**
	 * Exit a parse tree produced by {@link FunctionalCareParser#args}.
	 * @param ctx the parse tree
	 */
	void exitArgs(FunctionalCareParser.ArgsContext ctx);
	/**
	 * Enter a parse tree produced by {@link FunctionalCareParser#returnFunct}.
	 * @param ctx the parse tree
	 */
	void enterReturnFunct(FunctionalCareParser.ReturnFunctContext ctx);
	/**
	 * Exit a parse tree produced by {@link FunctionalCareParser#returnFunct}.
	 * @param ctx the parse tree
	 */
	void exitReturnFunct(FunctionalCareParser.ReturnFunctContext ctx);
	/**
	 * Enter a parse tree produced by {@link FunctionalCareParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(FunctionalCareParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link FunctionalCareParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(FunctionalCareParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link FunctionalCareParser#funcionUsuario}.
	 * @param ctx the parse tree
	 */
	void enterFuncionUsuario(FunctionalCareParser.FuncionUsuarioContext ctx);
	/**
	 * Exit a parse tree produced by {@link FunctionalCareParser#funcionUsuario}.
	 * @param ctx the parse tree
	 */
	void exitFuncionUsuario(FunctionalCareParser.FuncionUsuarioContext ctx);
	/**
	 * Enter a parse tree produced by {@link FunctionalCareParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterAtom(FunctionalCareParser.AtomContext ctx);
	/**
	 * Exit a parse tree produced by {@link FunctionalCareParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitAtom(FunctionalCareParser.AtomContext ctx);
	/**
	 * Enter a parse tree produced by {@link FunctionalCareParser#atomnum}.
	 * @param ctx the parse tree
	 */
	void enterAtomnum(FunctionalCareParser.AtomnumContext ctx);
	/**
	 * Exit a parse tree produced by {@link FunctionalCareParser#atomnum}.
	 * @param ctx the parse tree
	 */
	void exitAtomnum(FunctionalCareParser.AtomnumContext ctx);
	/**
	 * Enter a parse tree produced by {@link FunctionalCareParser#atomid}.
	 * @param ctx the parse tree
	 */
	void enterAtomid(FunctionalCareParser.AtomidContext ctx);
	/**
	 * Exit a parse tree produced by {@link FunctionalCareParser#atomid}.
	 * @param ctx the parse tree
	 */
	void exitAtomid(FunctionalCareParser.AtomidContext ctx);
	/**
	 * Enter a parse tree produced by {@link FunctionalCareParser#atombool}.
	 * @param ctx the parse tree
	 */
	void enterAtombool(FunctionalCareParser.AtomboolContext ctx);
	/**
	 * Exit a parse tree produced by {@link FunctionalCareParser#atombool}.
	 * @param ctx the parse tree
	 */
	void exitAtombool(FunctionalCareParser.AtomboolContext ctx);
	/**
	 * Enter a parse tree produced by {@link FunctionalCareParser#atomnull}.
	 * @param ctx the parse tree
	 */
	void enterAtomnull(FunctionalCareParser.AtomnullContext ctx);
	/**
	 * Exit a parse tree produced by {@link FunctionalCareParser#atomnull}.
	 * @param ctx the parse tree
	 */
	void exitAtomnull(FunctionalCareParser.AtomnullContext ctx);
	/**
	 * Enter a parse tree produced by {@link FunctionalCareParser#parfuntions1}.
	 * @param ctx the parse tree
	 */
	void enterParfuntions1(FunctionalCareParser.Parfuntions1Context ctx);
	/**
	 * Exit a parse tree produced by {@link FunctionalCareParser#parfuntions1}.
	 * @param ctx the parse tree
	 */
	void exitParfuntions1(FunctionalCareParser.Parfuntions1Context ctx);
	/**
	 * Enter a parse tree produced by {@link FunctionalCareParser#parfuntions2}.
	 * @param ctx the parse tree
	 */
	void enterParfuntions2(FunctionalCareParser.Parfuntions2Context ctx);
	/**
	 * Exit a parse tree produced by {@link FunctionalCareParser#parfuntions2}.
	 * @param ctx the parse tree
	 */
	void exitParfuntions2(FunctionalCareParser.Parfuntions2Context ctx);
	/**
	 * Enter a parse tree produced by {@link FunctionalCareParser#datatypes}.
	 * @param ctx the parse tree
	 */
	void enterDatatypes(FunctionalCareParser.DatatypesContext ctx);
	/**
	 * Exit a parse tree produced by {@link FunctionalCareParser#datatypes}.
	 * @param ctx the parse tree
	 */
	void exitDatatypes(FunctionalCareParser.DatatypesContext ctx);
	/**
	 * Enter a parse tree produced by {@link FunctionalCareParser#operatorsdos}.
	 * @param ctx the parse tree
	 */
	void enterOperatorsdos(FunctionalCareParser.OperatorsdosContext ctx);
	/**
	 * Exit a parse tree produced by {@link FunctionalCareParser#operatorsdos}.
	 * @param ctx the parse tree
	 */
	void exitOperatorsdos(FunctionalCareParser.OperatorsdosContext ctx);
	/**
	 * Enter a parse tree produced by {@link FunctionalCareParser#operatorsuno}.
	 * @param ctx the parse tree
	 */
	void enterOperatorsuno(FunctionalCareParser.OperatorsunoContext ctx);
	/**
	 * Exit a parse tree produced by {@link FunctionalCareParser#operatorsuno}.
	 * @param ctx the parse tree
	 */
	void exitOperatorsuno(FunctionalCareParser.OperatorsunoContext ctx);
	/**
	 * Enter a parse tree produced by {@link FunctionalCareParser#operatorstres}.
	 * @param ctx the parse tree
	 */
	void enterOperatorstres(FunctionalCareParser.OperatorstresContext ctx);
	/**
	 * Exit a parse tree produced by {@link FunctionalCareParser#operatorstres}.
	 * @param ctx the parse tree
	 */
	void exitOperatorstres(FunctionalCareParser.OperatorstresContext ctx);
	/**
	 * Enter a parse tree produced by {@link FunctionalCareParser#intop}.
	 * @param ctx the parse tree
	 */
	void enterIntop(FunctionalCareParser.IntopContext ctx);
	/**
	 * Exit a parse tree produced by {@link FunctionalCareParser#intop}.
	 * @param ctx the parse tree
	 */
	void exitIntop(FunctionalCareParser.IntopContext ctx);
	/**
	 * Enter a parse tree produced by {@link FunctionalCareParser#relationalop}.
	 * @param ctx the parse tree
	 */
	void enterRelationalop(FunctionalCareParser.RelationalopContext ctx);
	/**
	 * Exit a parse tree produced by {@link FunctionalCareParser#relationalop}.
	 * @param ctx the parse tree
	 */
	void exitRelationalop(FunctionalCareParser.RelationalopContext ctx);
	/**
	 * Enter a parse tree produced by {@link FunctionalCareParser#logicoparity2}.
	 * @param ctx the parse tree
	 */
	void enterLogicoparity2(FunctionalCareParser.Logicoparity2Context ctx);
	/**
	 * Exit a parse tree produced by {@link FunctionalCareParser#logicoparity2}.
	 * @param ctx the parse tree
	 */
	void exitLogicoparity2(FunctionalCareParser.Logicoparity2Context ctx);
	/**
	 * Enter a parse tree produced by {@link FunctionalCareParser#logicoparity1}.
	 * @param ctx the parse tree
	 */
	void enterLogicoparity1(FunctionalCareParser.Logicoparity1Context ctx);
	/**
	 * Exit a parse tree produced by {@link FunctionalCareParser#logicoparity1}.
	 * @param ctx the parse tree
	 */
	void exitLogicoparity1(FunctionalCareParser.Logicoparity1Context ctx);
	/**
	 * Enter a parse tree produced by {@link FunctionalCareParser#logicoparity3}.
	 * @param ctx the parse tree
	 */
	void enterLogicoparity3(FunctionalCareParser.Logicoparity3Context ctx);
	/**
	 * Exit a parse tree produced by {@link FunctionalCareParser#logicoparity3}.
	 * @param ctx the parse tree
	 */
	void exitLogicoparity3(FunctionalCareParser.Logicoparity3Context ctx);
	/**
	 * Enter a parse tree produced by {@link FunctionalCareParser#parintfunc2}.
	 * @param ctx the parse tree
	 */
	void enterParintfunc2(FunctionalCareParser.Parintfunc2Context ctx);
	/**
	 * Exit a parse tree produced by {@link FunctionalCareParser#parintfunc2}.
	 * @param ctx the parse tree
	 */
	void exitParintfunc2(FunctionalCareParser.Parintfunc2Context ctx);
	/**
	 * Enter a parse tree produced by {@link FunctionalCareParser#parintfunc1}.
	 * @param ctx the parse tree
	 */
	void enterParintfunc1(FunctionalCareParser.Parintfunc1Context ctx);
	/**
	 * Exit a parse tree produced by {@link FunctionalCareParser#parintfunc1}.
	 * @param ctx the parse tree
	 */
	void exitParintfunc1(FunctionalCareParser.Parintfunc1Context ctx);
	/**
	 * Enter a parse tree produced by {@link FunctionalCareParser#parboolfunc2}.
	 * @param ctx the parse tree
	 */
	void enterParboolfunc2(FunctionalCareParser.Parboolfunc2Context ctx);
	/**
	 * Exit a parse tree produced by {@link FunctionalCareParser#parboolfunc2}.
	 * @param ctx the parse tree
	 */
	void exitParboolfunc2(FunctionalCareParser.Parboolfunc2Context ctx);
	/**
	 * Enter a parse tree produced by {@link FunctionalCareParser#parboolfunc1}.
	 * @param ctx the parse tree
	 */
	void enterParboolfunc1(FunctionalCareParser.Parboolfunc1Context ctx);
	/**
	 * Exit a parse tree produced by {@link FunctionalCareParser#parboolfunc1}.
	 * @param ctx the parse tree
	 */
	void exitParboolfunc1(FunctionalCareParser.Parboolfunc1Context ctx);
}