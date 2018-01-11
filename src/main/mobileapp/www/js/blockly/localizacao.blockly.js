window.blockly = window.blockly || {};
window.blockly.js = window.blockly.js || {};
window.blockly.js.blockly = window.blockly.js.blockly || {};
window.blockly.js.blockly.Localizacao = window.blockly.js.blockly.Localizacao
		|| {};

var item, param, coordenadas, cord;

/**
 * localizacao
 */
window.blockly.js.blockly.Localizacao.obter_coordenadas = function() {
	window.alert('entrou no bloco');
	this.cronapi.cordova.geolocation.getCurrentPosition(function(sender_item) {
		item = sender_item;
		coordenadas = ['latlng=',
				this.cronapi.object.getProperty(item, 'coords.latitude'), ',',
				this.cronapi.object.getProperty(item, 'coords.longitude')]
				.join('');
	}.bind(this), function(sender_item) {
		item = sender_item;
	}.bind(this));
	param = String(coordenadas);
	this.cronapi.util.callServerBlocklyNoReturn(
			'blockly.Localizacao:obter_endereco', param);
}
