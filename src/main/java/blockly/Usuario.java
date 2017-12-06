package blockly;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.concurrent.Callable;

@CronapiMetaData(type = "blockly")
@CronappSecurity
public class Usuario {

	public static final int TIMEOUT = 300;

	/**
	 *
	 * @param Dados
	 * @return Var
	 */
	// Usuario
	public static Var obter_usuario(Var Dados) throws Exception {
		return new Callable<Var>() {

			public Var call() throws Exception {
				return cronapi.util.Operations.getCurrentUserName();
			}
		}.call();
	}

}
