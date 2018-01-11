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
	public static Var obter_endereco(Var coordenadas) throws Exception {
		return new Callable<Var>() {

			private Var endereco = Var.VAR_NULL;
			private Var url = Var.VAR_NULL;
			private Var consultaEnd = Var.VAR_NULL;
			private Var Results = Var.VAR_NULL;
			private Var retorno = Var.VAR_NULL;

			public Var call() throws Exception {
				System.out.println(Var.valueOf("chamou o bloco").getObjectAsString());
				url = Var.valueOf(Var.valueOf("https://maps.googleapis.com/maps/api/geocode/json?").toString()
						+ coordenadas.toString()
						+ Var.valueOf(
								"&location_type=ROOFTOP&result_type=street_address&key=AIzaSyDOrc1IXPtUXbqAEv6zCfZN7545wg4Bn3o")
								.toString());
				System.out.println(url.getObjectAsString());
				consultaEnd = cronapi.json.Operations.toJson(cronapi.util.Operations.getURLFromOthers(
						Var.valueOf("GET"), Var.valueOf("application/json"), url, Var.VAR_NULL, Var.VAR_NULL));
				System.out.println(Var.valueOf("chamou a api").getObjectAsString());
				System.out.println(consultaEnd.getObjectAsString());
				System.out.println(Var.valueOf("Results!!!!!").getObjectAsString());
				Results = cronapi.json.Operations.getJsonOrMapField(consultaEnd, Var.valueOf("results[0]"));
				System.out.println(Results.getObjectAsString());
				endereco = cronapi.json.Operations.getJsonOrMapField(Results, Var.valueOf("formatted_address"));
				System.out.println(Var.valueOf("Endereco!!!!!!").getObjectAsString());
				System.out.println(endereco.getObjectAsString());
				retorno = blockly.Localizacao.setar_endereco(endereco);
				return Var.VAR_NULL;
			}
		}.call();
	}

	/**
	 *
	 * @param endereco
	 * @return Var
	 */
	// localizacao
	public static Var setar_endereco(Var endereco) throws Exception {
		return new Callable<Var>() {

			private Var posVirg = Var.VAR_NULL;
			private Var posIfen = Var.VAR_NULL;
			private Var logradouro = Var.VAR_NULL;
			private Var numero = Var.VAR_NULL;
			private Var textoAux = Var.VAR_NULL;
			private Var posVirg2 = Var.VAR_NULL;
			private Var bairro = Var.VAR_NULL;
			private Var textoAux2 = Var.VAR_NULL;
			private Var posIfen2 = Var.VAR_NULL;
			private Var cidade = Var.VAR_NULL;
			private Var textoAux3 = Var.VAR_NULL;
			private Var posVirg3 = Var.VAR_NULL;
			private Var UF = Var.VAR_NULL;
			private Var posVirg4 = Var.VAR_NULL;
			private Var cep = Var.VAR_NULL;
			private Var pais = Var.VAR_NULL;

			public Var call() throws Exception {
				posVirg = Var.valueOf(endereco.getObjectAsString().indexOf(Var.valueOf(",").getObjectAsString()) + 1);
				posIfen = Var.valueOf(endereco.getObjectAsString().indexOf(Var.valueOf("-").getObjectAsString()) + 1);
				logradouro = cronapi.text.Operations.getLettersFromFirstToFromStart(endereco,
						(cronapi.math.Operations.subtract(posVirg, Var.valueOf(1))));
				numero = cronapi.text.Operations.getLettersFromStartToFromStart(endereco,
						(cronapi.math.Operations.sum(posVirg, Var.valueOf(1))),
						(cronapi.math.Operations.subtract(posIfen, Var.valueOf(1))));
				textoAux = cronapi.text.Operations.getLettersFromStartToLast(endereco,
						(cronapi.math.Operations.sum(posIfen, Var.valueOf(1))));
				posVirg2 = Var.valueOf(textoAux.getObjectAsString().indexOf(Var.valueOf(",").getObjectAsString()) + 1);
				bairro = cronapi.text.Operations.getLettersFromFirstToFromStart(textoAux,
						(cronapi.math.Operations.subtract(posVirg2, Var.valueOf(1))));
				textoAux2 = cronapi.text.Operations.getLettersFromStartToLast(textoAux,
						(cronapi.math.Operations.sum(posVirg2, Var.valueOf(1))));
				posIfen2 = Var.valueOf(textoAux2.getObjectAsString().indexOf(Var.valueOf("-").getObjectAsString()) + 1);
				cidade = cronapi.text.Operations.getLettersFromFirstToFromStart(textoAux2,
						(cronapi.math.Operations.subtract(posIfen2, Var.valueOf(1))));
				textoAux3 = cronapi.text.Operations.getLettersFromStartToLast(textoAux2,
						(cronapi.math.Operations.sum(posIfen2, Var.valueOf(1))));
				posVirg3 = Var.valueOf(textoAux3.getObjectAsString().indexOf(Var.valueOf(",").getObjectAsString()) + 1);
				UF = cronapi.text.Operations.getLettersFromFirstToFromStart(textoAux3,
						(cronapi.math.Operations.subtract(posVirg3, Var.valueOf(1))));
				posVirg4 = Var
						.valueOf(textoAux3.getObjectAsString().lastIndexOf(Var.valueOf(",").getObjectAsString()) + 1);
				cep = cronapi.text.Operations.getLettersFromStartToFromStart(textoAux3,
						(cronapi.math.Operations.sum(posVirg3, Var.valueOf(1))),
						(cronapi.math.Operations.subtract(posVirg4, Var.valueOf(1))));
				pais = cronapi.text.Operations.getLettersFromStartToLast(textoAux3,
						(cronapi.math.Operations.sum(posVirg4, Var.valueOf(1))));
				System.out.println(logradouro.getObjectAsString());
				System.out.println(numero.getObjectAsString());
				System.out.println(bairro.getObjectAsString());
				System.out.println(cidade.getObjectAsString());
				System.out.println(UF.getObjectAsString());
				System.out.println(cep.getObjectAsString());
				System.out.println(pais.getObjectAsString());
				cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.changeAttrValue"),
						Var.valueOf("mapa"), Var.valueOf("src"),
						Var.valueOf(Var.valueOf("https://www.google.com/maps/embed/v1/place?key=").toString()
								+ Var.valueOf("AIzaSyDOrc1IXPtUXbqAEv6zCfZN7545wg4Bn3o").toString()
								+ Var.valueOf("&q=").toString() + logradouro.toString() + Var.valueOf("+").toString()
								+ numero.toString() + Var.valueOf("+").toString() + bairro.toString()
								+ Var.valueOf("+").toString() + cidade.toString() + Var.valueOf("+").toString()
								+ pais.toString()));
				cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.changeValueOfField"),
						Var.valueOf("Posto.active.cep"), cep);
				cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.changeValueOfField"),
						Var.valueOf("Posto.active.logradouro"), logradouro);
				cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.changeValueOfField"),
						Var.valueOf("Posto.active.numero"), numero);
				cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.changeValueOfField"),
						Var.valueOf("Posto.active.bairro"), bairro);
				cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.changeValueOfField"),
						Var.valueOf("Posto.active.cidade"), cidade);
				cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.changeValueOfField"),
						Var.valueOf("Posto.active.uf"), UF);
				return Var.valueOf(0);
			}
		}.call();
	}

}
