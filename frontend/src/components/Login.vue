<template>
  <v-container fluid fill-height>
    <v-layout align-center justify-center>
      <v-flex xs12 sm8 md4>
        <v-card class="elevation-12">
          <v-toolbar dark color="primary">
            <v-toolbar-title>Login form</v-toolbar-title>
          </v-toolbar>
          <v-card-text>
            <v-form>
              <v-text-field
                prepend-icon="person"
                name="login"
                label="Login"
                type="text"
                v-model="username"
                required
                v-on:keyup.enter.exact="login"
              ></v-text-field>
              <v-text-field
                id="password"
                prepend-icon="lock"
                name="password"
                label="Password"
                type="password"
                v-model="password"
                required
                v-on:keyup.enter.exact="login"
              ></v-text-field>
            </v-form>
          </v-card-text>
          <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn color="primary" @click="login">Login</v-btn>
          </v-card-actions>
        </v-card>
      </v-flex>
    </v-layout>
  </v-container>
</template>
<script>
import AuthenticationService from "@/services/AuthenticationService";

export default {
  data: () => ({
    valid: false,
    username: "",
    password: ""
  }),
  methods: {
    async login() {
      try {
        const response = await AuthenticationService.login({
          username: this.username,
          password: this.password
        });
        console.log("response==========", response);
        this.$store.dispatch("setToken", "Bearer " + response.data.token);
        this.$store.dispatch("setUsername", response.data.username);
        this.$store.dispatch("setRoles", response.data.roles);

        console.log(this.$store.state.token);
        console.log(this.$store.state.isUserLoggedIn);
        console.log(this.$store.state.username);

        this.$router.push({
          name: "game"
        });
      } catch (error) {
        this.error = error;
      }
    },
    async createGame() {
      try {
        this.$router.push({
          name: "parcheesi"
        });
      } catch (error) {
        console.log(error);
      }
    }
  }
};
</script>