<template>
  <div>
    <button id="roll-button" v-on:click="rollDice">ROLL DICE</button>
    <div class="dice">
      <ol class="die-list even-roll" data-roll="1" id="die-1">
        <li class="die-item" data-side="1">
          <span class="dot"></span>
        </li>
        <li class="die-item" data-side="2">
          <span class="dot"></span>
          <span class="dot"></span>
        </li>
        <li class="die-item" data-side="3">
          <span class="dot"></span>
          <span class="dot"></span>
          <span class="dot"></span>
        </li>
        <li class="die-item" data-side="4">
          <span class="dot"></span>
          <span class="dot"></span>
          <span class="dot"></span>
          <span class="dot"></span>
        </li>
        <li class="die-item" data-side="5">
          <span class="dot"></span>
          <span class="dot"></span>
          <span class="dot"></span>
          <span class="dot"></span>
          <span class="dot"></span>
        </li>
        <li class="die-item" data-side="6">
          <span class="dot"></span>
          <span class="dot"></span>
          <span class="dot"></span>
          <span class="dot"></span>
          <span class="dot"></span>
          <span class="dot"></span>
        </li>
      </ol>
    </div>
  </div>
</template>

<script>
import playerService from "@/services/Player/Player";
export default {
  pros: {
    iDiced: Number,
    isDiced: Boolean,
    oCurrentPlayer: Object
  },
  data() {
    return {
      msg: "Welcome to Your Vue.js App"
    };
  },
  created: function() {
    console.log("con cu hay cung xin chao ca nha");
  },
  methods: {
    async rollDice() {
      if (this.$attrs.isDiced === true) {
        this.$eventBus.$emit("tempAlert", {
          msg: "NOT turn to dice!!!",
          color: "black",
          background: "red"
        });
        return;
      }

      var diceValue = 1;
      const dice = [...document.querySelectorAll(".die-list")];

      var response = await playerService.getIDiced();
      this.$eventBus.$emit("setIsDiced", true);
      dice.forEach(die => {
        this.toggleClasses(die);
        // die.dataset.roll = diceValue = this.getRandomNumber(1, 6);
        die.dataset.roll = diceValue = response.data;
      });

      var self = this;
      setTimeout(function() {
        self.$eventBus.$emit("tempAlert", {
          msg: self.$attrs.oCurrentPlayer.color + " diced a " + diceValue,
          color: self.$attrs.oCurrentPlayer.color
        });
        self.$eventBus.$emit("setIDiced", diceValue);

        self.$eventBus.$emit("isAbleToTakeTurn");
      }, 500);
    },

    toggleClasses(die) {
      die.classList.toggle("odd-roll");
      die.classList.toggle("even-roll");
    },

    getRandomNumber(min, max) {
      min = Math.ceil(min);
      max = Math.floor(max);
      return Math.floor(Math.random() * (max - min + 1)) + min;
    }
  }
};
</script>

<style>
@import url("../assets/css/dice.css");
</style>