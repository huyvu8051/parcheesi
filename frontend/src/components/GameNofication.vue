<template>
  <v-snackbar
    v-model="snackbar"
    :timeout="timeout"
    :color="'success'"
    :top="true"
    :multi-line="true"
  >
    <v-layout align-center pr-4>
      <v-icon class="pr-3" dark large>check_circle</v-icon>
      <v-layout column>
        <div>
          <strong>{{text}}</strong>
        </div>
      </v-layout>
    </v-layout>
    <template v-slot:action="{ attrs }">
      <v-btn color="white" text v-bind="attrs" @click="snackbar = false">Close</v-btn>
    </template>
  </v-snackbar>
</template>

<script>
export default {
  data() {
    return {
      snackbar: false,
      text: "",
      timeout: 5000
    };
  },
  created() {
    this.$eventBus.$on("nofication", data => {
      this.text = "Nofication: " + data;
      this.snackbar = true;
    });
  }
};
</script>

<style>
</style>