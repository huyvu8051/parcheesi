<template>
  <v-app>
    <Header />
    <Navigation />
    <v-main>
      <v-container fluid fill-height rounded-lg>
        <router-view></router-view>
      </v-container>
    </v-main>
  </v-app>
</template>

<script>
import Footer from "@/components/Footer";
import Header from "@/components/Header";
import Navigation from "@/components/Navigation";
export default {
  name: "App",
  components: {
    Footer: Footer,
    Header: Header,
    Navigation: Navigation
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
