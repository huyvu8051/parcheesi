import Vue from 'vue'
import Vuex from 'vuex'
import createPersistedState from 'vuex-persistedstate'

Vue.use(Vuex)

export default new Vuex.Store({
	strict: true,
	plugins: [
		createPersistedState()
	],
	state: {
		token: null,
		username: null,
		roles: null,
		isUserLoggedIn: false,
	},
	mutations: {
		setToken(state, token) {
			state.token = token
			state.isUserLoggedIn = state.signature = !!(token)
		},
		setUsername(state, username) {
			state.username = username
		},
		setRoles(state, roles) {
			state.roles = roles
		}
	},
	actions: {
		setToken({ commit }, token) {
			commit('setToken', token)
		},
		setUsername({ commit }, username) {
			commit('setUsername', username)
		},
		setRoles({ commit }, roles) {
			commit('setRoles', roles)
		}
	}
})