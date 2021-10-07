<template>
  <v-app>
    <Header />
    <v-main>
      <v-container fluid fill-height>
        <router-view></router-view>
      </v-container>
    </v-main>
  </v-app>
</template>

<script>
import Footer from "@/components/Footer";
import Header from "@/components/Header";
export default {
  name: "App",
  components: {
    Footer: Footer,
    Header: Header
  }
};
</script>

<style>
#app {
  font-family: "Avenir", Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
