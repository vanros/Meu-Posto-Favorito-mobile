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

			private Var usuario = Var.VAR_NULL;

			public Var call() throws Exception {
				usuario = cronapi.database.Operations.query(Var.valueOf("app.entity.User"),
						Var.valueOf("select u.id from User u where u.login = :login"),
						Var.valueOf("login", cronapi.util.Operations.getCurrentUserName()));
				return cronapi.database.Operations.newEntity(Var.valueOf("app.entity.User"),
						Var.valueOf("id", cronapi.database.Operations.getField(usuario, Var.valueOf("this[0]"))));
			}
		}.call();
	}

}
