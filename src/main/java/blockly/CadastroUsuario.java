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
	 * @return Var
	 */
	// CadastroUsuario
	public static Var inserir_dados() throws Exception {
		return new Callable<Var>() {

			public Var call() throws Exception {
				if (Var.valueOf(cronapi.screen.Operations.getValueOfField(Var.valueOf("senha"))
						.equals(cronapi.screen.Operations.getValueOfField(Var.valueOf("senha_confere"))))
						.getObjectAsBoolean()) {
					cronapi.database.Operations.insert(Var.valueOf("app.entity.User"),
							Var.valueOf("password", cronapi.screen.Operations.getValueOfField(Var.valueOf("senha"))),
							Var.valueOf("name", cronapi.screen.Operations.getValueOfField(Var.valueOf("email"))),
							Var.valueOf("login", cronapi.screen.Operations.getValueOfField(Var.valueOf("login"))),
							Var.valueOf("email", cronapi.screen.Operations.getValueOfField(Var.valueOf("email"))));
					cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.notify"),
							Var.valueOf("success"), Var.valueOf("Cadastro realizado com sucesso!"));
					cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.changeView"),
							Var.valueOf("#/app/login"));
				} else {
					cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.notify"),
							Var.valueOf("error"), Var.valueOf("As senhas não conferem!"));
				}
				return Var.VAR_NULL;
			}
		}.call();
	}

}
