package blockly;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.concurrent.Callable;

@CronapiMetaData(type = "blockly")
@CronappSecurity
public class Avaliacao {

	public static final int TIMEOUT = 300;

	/**
	 *
	 * @param nota
	 * @param comentario
	 * @param id_abastecimento
	 * @return Var
	 */
	// Avaliacao
	public static Var insere_avaliacao(Var nota, Var comentario, Var id_abastecimento) throws Exception {
		return new Callable<Var>() {

			public Var call() throws Exception {
				cronapi.database.Operations.insert(Var.valueOf("app.entity.Avaliacao"),
						Var.valueOf("texto", comentario), Var.valueOf("nota", nota),
						Var.valueOf("abastecimento", cronapi.database.Operations.newEntity(
								Var.valueOf("app.entity.Abastecimento"), Var.valueOf("id", id_abastecimento))));
				return Var.VAR_NULL;
			}
		}.call();
	}

}
