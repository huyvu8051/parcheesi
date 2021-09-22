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
// import dice from "../assets/js/dice";
// import parcheesi from "../assets/js/parcheesi"
export default {
  data() {
    return {
      msg: "Welcome to Your Vue.js App"
    };
  },
  created: function() {
    console.log("con cu hay cung xin chao ca nha");
  },
  methods: {
    rollDice() {
      /* if (parcheesi.isDiced === true) {
        parcheesi.tempAlert("NOT turn to dice!!!", "black", "red");
        return;
      } */

      var diceValue = 1;
      const dice = [...document.querySelectorAll(".die-list")];
      dice.forEach(die => {
        this.toggleClasses(die);
        die.dataset.roll = diceValue = this.getRandomNumber(1, 6);
      });

      /* parcheesi.tempAlert(
        parcheesi.oCurrentPlayer.color + " diced a " + diceValue,
        parcheesi.oCurrentPlayer.color
      ); */
      /* setTimeout(function() {
        parcheesi.iDiced = diceValue;
        d3.select(".diced").text(parcheesi.iDiced);
        parcheesi.isDiced = true;

        if (!parcheesi.isAbleToTakeTurn()) {
          // check this currentplayer can do a turn, if not -> give turn to next player
          parcheesi.tempAlert(
            parcheesi.oCurrentPlayer.color +
              " loses turn, the turn is given to next player!!!",
            parcheesi.oCurrentPlayer.color
          );
          parcheesi.setNextPlayer();
          parcheesi.dice();
          return;
        }
      }, 500); */
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