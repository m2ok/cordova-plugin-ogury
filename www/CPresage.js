var CPresage = {
	adToServe: function (onAdEvent, onAdNotFound) {
		cordova.exec(onAdEvent, onAdNotFound, 'CPresage', 'adToServe', [{}]);
	},
	launchWithEula: function (onAdEvent, onAdNotFound) {
		cordova.exec(onAdEvent, onAdNotFound, 'CPresage', 'launchWithEula', [{}]);
	},
	loadInterstitial: function (onAdEvent, onAdNotFound) {
		cordova.exec(onAdEvent, onAdNotFound, 'CPresage', 'loadInterstitial', [{}]);
	},
	showInterstitial: function (onAdEvent, onAdNotFound) {
		cordova.exec(onAdEvent, onAdNotFound, 'CPresage', 'showInterstitial', [{}]);
	}
};
module.exports = CPresage;