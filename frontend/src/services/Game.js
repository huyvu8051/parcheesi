import Api from '@/services/Api';

export default {
	getIDiced() {
		return Api().get('dice');
	},
	save(credentials) {
		if (credentials.id == null) {
			return Api().post('admin/category', credentials);
		}
		return Api().put('admin/category', credentials);
	},
	createGame(credentials) {
		return Api().post("game",credentials);
	},
	action(credentials) {
		return Api().post("action",credentials);
	},
	loadGame(credentials) {
		return Api().post("parcheesi", credentials);
	}
}