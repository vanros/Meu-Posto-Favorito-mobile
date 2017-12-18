package blockly;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.concurrent.Callable;

@CronapiMetaData(type = "blockly")
@CronappSecurity(post = "Public", get = "Public", execute = "Public", delete = "Public", put = "Public")
public class TelaCadastro {

	public static final int TIMEOUT = 300;

	/**
	 *
	 * @return Var
	 */
	// TelaCadastro
	public static Var mudar() throws Exception {
		return new Callable<Var>() {

			public Var call() throws Exception {
				cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.changeView"),
						Var.valueOf("#/app/cadastro"));
				return Var.VAR_NULL;
			}
		}.call();
	}

}
