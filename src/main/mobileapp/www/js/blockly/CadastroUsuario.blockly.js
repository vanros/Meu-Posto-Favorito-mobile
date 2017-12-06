window.blockly = window.blockly || {};
window.blockly.js = window.blockly.js || {};
window.blockly.js.blockly = window.blockly.js.blockly || {};
window.blockly.js.blockly.CadastroUsuario = window.blockly.js.blockly.CadastroUsuario
		|| {};

/**
 * CadastroUsuario
 */
window.blockly.js.blockly.CadastroUsuario.inserir_dados = function() {
	if (this.cronapi.screen.getValueOfField("senha") == this.cronapi.screen
			.getValueOfField("confere_senha")) {
		this.cronapi.util.callServerBlocklyNoReturn(
				'blockly.CadastroUsuario:inserir_dados', this.cronapi.screen
						.getValueOfField("email"), this.cronapi.screen
						.getValueOfField("login"), this.cronapi.screen
						.getValueOfField("senha"));
		this.cronapi.screen
				.notify('success', 'Cadastro Realizado com Sucesso!');
		this.cronapi.screen.changeValueOfField("email", '0');
		this.cronapi.screen.changeValueOfField("login", '0');
		this.cronapi.screen.changeValueOfField("senha", '0');
	} else {
		this.cronapi.screen.notify('error',
				'As senhas digitadas são diferentes!');
	}
}
