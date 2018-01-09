package blockly;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.concurrent.Callable;

@CronapiMetaData(type = "blockly")
@CronappSecurity
public class Localizacao {

	public static final int TIMEOUT = 300;

	/**
	 *
	 * @param coordenadas
	 * @return Var
	 */
	// localizacao
	public static Var Executar(Var coordenadas) throws Exception {
		return new Callable<Var>() {

			private Var url = Var.VAR_NULL;
			private Var consultaEnd = Var.VAR_NULL;

			public Var call() throws Exception {
				System.out.println(Var.valueOf("chamou o bloco").getObjectAsString());
				url = Var.valueOf(Var.valueOf("http://maps.googleapis.com/maps/api/geocode/json?").toString()
						+ coordenadas.toString());
				System.out.println(url.getObjectAsString());
				consultaEnd = cronapi.json.Operations.toJson(cronapi.util.Operations.getURLFromOthers(
						Var.valueOf("GET"), Var.valueOf("application/json"), url, Var.VAR_NULL, Var.VAR_NULL));
				System.out.println(Var.valueOf("chamou a api").getObjectAsString());
				System.out.println(consultaEnd.getObjectAsString());
				cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.changeValueOfField"),
						Var.valueOf("coordenadas"),
						cronapi.json.Operations.getJsonOrMapField(consultaEnd, Var.valueOf("formatted_address")));
				System.out.println(cronapi.json.Operations
						.getJsonOrMapField(consultaEnd, Var.valueOf("formatted_address")).getObjectAsString());
				return Var.VAR_NULL;
			}
		}.call();
	}

}
