package blockly;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.concurrent.Callable;

@CronapiMetaData(type = "blockly")
@CronappSecurity
public class Abastecimento {

	public static final int TIMEOUT = 300;

	/**
	 *
	 * @param Entidade
	 * @return Var
	 */
	// Abastecimento
	public static Var obter_data_atual(Var Entidade) throws Exception {
		return new Callable<Var>() {

			public Var call() throws Exception {
				return cronapi.dateTime.Operations.getNow();
			}
		}.call();
	}

}
