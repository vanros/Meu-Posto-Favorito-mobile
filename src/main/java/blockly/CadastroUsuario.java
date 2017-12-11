package blockly;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.concurrent.Callable;

@CronapiMetaData(type = "blockly")
@CronappSecurity(post = "Public", get = "Public", execute = "Public", delete = "Public", put = "Public")
public class CadastroUsuario {

	public static final int TIMEOUT = 300;

	/**
	 *
	 * @param email
	 * @param login
	 * @param senha
	 * @return Var
	 */
	// CadastroUsuario
	public static Var inserir_dados(Var email, Var login, Var senha) throws Exception {
		return new Callable<Var>() {

			public Var call() throws Exception {
				cronapi.database.Operations.insert(Var.valueOf("app.entity.User"), Var.valueOf("password", senha),
						Var.valueOf("name", email), Var.valueOf("id", cronapi.util.Operations.generateUUID()),
						Var.valueOf("login", login), Var.valueOf("email", email));
				return Var.VAR_NULL;
			}
		}.call();
	}

}
