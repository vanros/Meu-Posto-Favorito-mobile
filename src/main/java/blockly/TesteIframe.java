package blockly;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.concurrent.Callable;

@CronapiMetaData(type = "blockly")
@CronappSecurity
public class TesteIframe {

	public static final int TIMEOUT = 300;

	/**
	 *
	 * @return Var
	 */
	// teste_iframe
	public static Var Executar() throws Exception {
		return new Callable<Var>() {

			public Var call() throws Exception {
				cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.changeAttrValue"),
						Var.valueOf("mapa"), Var.valueOf("src"),
						Var.valueOf(Var.valueOf("https://www.google.com/maps/embed/v1/place?key=").toString()
								+ Var.valueOf("AIzaSyDOrc1IXPtUXbqAEv6zCfZN7545wg4Bn3o").toString()
								+ Var.valueOf("&q=Av. Padre Antônio Tomás+299+Aldeota+Fortaleza+Brazil").toString()));
				return Var.VAR_NULL;
			}
		}.call();
	}

}
