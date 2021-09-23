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
	}
}