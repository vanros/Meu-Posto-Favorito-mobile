package blockly;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.concurrent.Callable;

@CronapiMetaData(type = "blockly")
@CronappSecurity
public class Usuarios {

	public static final int TIMEOUT = 300;

	/**
	 *
	 * @return Var
	 */
	// Usuarios
	public static Var Obter() throws Exception {
		return new Callable<Var>() {

			private Var retorno = Var.VAR_NULL;

			public Var call() throws Exception {
				retorno = cronapi.util.Operations.getURLFromOthers(Var.valueOf("POST"), Var.valueOf("application/json"),
						Var.VAR_NULL, Var.VAR_NULL, Var.VAR_NULL);
				System.out.println(retorno.getObjectAsString());
				return retorno;
			}
		}.call();
	}

	/**
	 */
	// Descreva esta função...
	public static void inserir() throws Exception {
		new Callable<Var>() {

			private Var users = Var.VAR_NULL;

			public Var call() throws Exception {
				users = cronapi.json.Operations.toJson(cronapi.database.Operations.newEntity(
						Var.valueOf("app.entity.User"),
						Var.valueOf("email",
								cronapi.screen.Operations.getValueOfField(Var.valueOf("User.active.email"))),
						Var.valueOf("name", cronapi.screen.Operations.getValueOfField(Var.valueOf("User.active.name"))),
						Var.valueOf("login",
								cronapi.screen.Operations.getValueOfField(Var.valueOf("User.active.login"))),
						Var.valueOf("password",
								cronapi.screen.Operations.getValueOfField(Var.valueOf("User.active.password")))));
				System.out.println(users.getObjectAsString());
				return Var.VAR_NULL;
			}
		}.call();
	}

}
