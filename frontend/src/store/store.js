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
		signature: null,
		email: null,
		roles: null,
		isUserLoggedIn: false
	},
	mutations: {
		setToken(state, token) {
			state.token = token
			state.isUserLoggedIn = state.signature = !!(token)
		},
		setEmail(state, email) {
			state.email = email
		},
		setRoles(state, roles) {
			state.roles = roles
		},
		setSignature(state, signature) {
			state.signature = signature
		}
	},
	actions: {
		setToken({ commit }, token) {
			commit('setToken', token)
		},
		setEmail({ commit }, email) {
			commit('setEmail', email)
		},
		setRoles({ commit }, roles) {
			commit('setRoles', roles)
		},
		setSignature({ commit }, signature) {
			commit('setSignature', signature)
		}
	}
})