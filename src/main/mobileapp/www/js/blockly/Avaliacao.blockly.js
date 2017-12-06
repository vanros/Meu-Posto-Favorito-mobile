window.blockly = window.blockly || {};
window.blockly.js = window.blockly.js || {};
window.blockly.js.blockly = window.blockly.js.blockly || {};
window.blockly.js.blockly.Avaliacao = window.blockly.js.blockly.Avaliacao || {};

/**
 * Avaliacao
 */
window.blockly.js.blockly.Avaliacao.sumeter_avaliacao = function() {
	this.cronapi.util.callServerBlocklyNoReturn(
			'blockly.Avaliacao:insere_avaliacao', this.cronapi.screen
					.getValueOfField("vars.nota"), this.cronapi.screen
					.getValueOfField("vars.comentario"), this.cronapi.screen
					.getParam('abastecimento'));
	this.cronapi.screen
			.notify('success', 'Abastecimento Avaliado com Sucesso!');
	this.cronapi.screen.changeValueOfField("vars.comentario", '0');
	this.cronapi.screen.changeValueOfField("vars.nota", '0');
}
