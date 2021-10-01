<template>
  <v-container>
    <v-form v-model="valid">
      <v-container>
        <v-row>
          <v-col cols="12" md="4">
            <v-text-field v-model="username" label="First name" required></v-text-field>
          </v-col>

          <v-col cols="12" md="4">
            <v-text-field v-model="password" label="Last name" required></v-text-field>
          </v-col>
          <v-col cols="12" md="4">
            <v-btn :disabled="!valid" color="success" class="mr-4" @click="login">Login</v-btn>
          </v-col>
          <v-col cols="12" md="4">
            <v-btn :disabled="!valid" color="success" class="mr-4" @click="logout">Logout</v-btn>
          </v-col>
          <v-col cols="12" md="4">
            <v-btn
              :disabled="!this.$store.state.isUserLoggedIn"
              color="success"
              class="mr-4"
              @click="createGame"
            >Create game</v-btn>
          </v-col>
        </v-row>
      </v-container>
    </v-form>
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
    logout() {
      this.$store.dispatch("setToken", null);
      this.$store.dispatch("setEmail", null);
      // this.$router.push({
      //   name: "login"
      // });
    },
    async login() {
      try {
        const response = await AuthenticationService.login({
          username: this.username,
          password: this.password
        });
        console.log('response==========', response)
        this.$store.dispatch("setToken", "Bearer " + response.data.token);
        this.$store.dispatch("setEmail", response.data.usename);
        this.$store.dispatch("setRoles", response.data.roles);

        console.log(this.$store.state.token);
        
        // console.log(this.$store.state.isUserLoggedIn);
        // this.$router.push({
        //   name: "home"
        // });
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