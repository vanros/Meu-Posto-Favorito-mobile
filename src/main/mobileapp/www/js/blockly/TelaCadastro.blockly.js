window.blockly = window.blockly || {};
window.blockly.js = window.blockly.js || {};
window.blockly.js.blockly = window.blockly.js.blockly || {};
window.blockly.js.blockly.TelaCadastro = window.blockly.js.blockly.TelaCadastro
		|| {};

/**
 * TelaCadastro
 */
window.blockly.js.blockly.TelaCadastro.cadastro = function() {
	this.cronapi.screen.createDefaultModal('Cadastre-se', '', 'Cancelar',
			'Confirmar', function() {
			}.bind(this), function() {
			}.bind(this), function() {
			}.bind(this));
}
