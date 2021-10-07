<template>
  <v-app-bar app flat dark>
    <v-toolbar-title class="text-uppercase grey--text">
      <span>Pacheesi</span>
    </v-toolbar-title>
    <v-spacer></v-spacer>
	<v-btn text color="grey" v-if="$store.state.isUserLoggedIn">
      <span>{{$store.state.username}}</span>
      <v-icon right>account_circle</v-icon>
    </v-btn>
    <v-btn text color="grey" v-if="$store.state.isUserLoggedIn" @click="logout">
      <span>Sign out</span>
      <v-icon right>logout</v-icon>
    </v-btn>
  </v-app-bar>
</template>

<script>
export default {
  data: () => ({
    icons: ["mdi-facebook", "mdi-twitter", "mdi-linkedin", "mdi-instagram"]
  }),
  methods: {
    logout() {
      this.$store.dispatch("setToken", null);
      this.$store.dispatch("setUsername", null);
      this.$router.push({
        name: "login"
      });
    }
  }
};
</script>

<style>
</style>

