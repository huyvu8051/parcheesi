<template>
  <div>
    <Dice :isDiced="this.isDiced" :iDiced="this.iDiced" :oCurrentPlayer="this.oCurrentPlayer" />
    <div id="table">chung ta cua hien tai</div>
  </div>
</template>

<script>
import Dice from "./Dice";
export default {
  components: {
    Dice: Dice
  },
  data: () => ({
    aGameFields: [
      {
        x: 150,
        y: 50,
        color: "red",
        radius: 40,
        homepoint: 3
      },
      {
        x: 950,
        y: 50,
        color: "blue",
        radius: 40,
        homepoint: 1
      },
      {
        x: 50,
        y: 150,
        color: "red",
        radius: 40,
        homepoint: 1
      },
      {
        x: 150,
        y: 150,
        color: "red",
        radius: 40,
        homepoint: 2
      },
      {
        x: 450,
        y: 150,
        color: "white",
        radius: 40,
        waypoint: 30
      },
      {
        x: 550,
        y: 150,
        color: "white",
        radius: 40,
        waypoint: 31
      },
      {
        x: 650,
        y: 150,
        color: "lightblue",
        radius: 40,
        waypoint: 0
      },
      {
        x: 950,
        y: 150,
        color: "blue",
        radius: 40,
        homepoint: 2
      },
      {
        x: 1050,
        y: 150,
        color: "blue",
        radius: 40,
        homepoint: 3
      },
      {
        x: 450,
        y: 250,
        color: "white",
        radius: 40,
        waypoint: 29
      },
      {
        x: 550,
        y: 250,
        color: "blue",
        radius: 40,
        finishpoint: 1
      },
      {
        x: 650,
        y: 250,
        color: "white",
        radius: 40,
        waypoint: 1
      },
      {
        x: 450,
        y: 350,
        color: "white",
        radius: 40,
        waypoint: 28
      },
      {
        x: 550,
        y: 350,
        color: "blue",
        radius: 40,
        finishpoint: 2
      },
      {
        x: 650,
        y: 350,
        color: "white",
        radius: 40,
        waypoint: 2
      },
      {
        x: 150,
        y: 450,
        color: "salmon",
        radius: 40,
        waypoint: 24
      },
      {
        x: 250,
        y: 450,
        color: "white",
        radius: 40,
        waypoint: 25
      },
      {
        x: 350,
        y: 450,
        color: "white",
        radius: 40,
        waypoint: 26
      },
      {
        x: 450,
        y: 450,
        color: "white",
        radius: 40,
        waypoint: 27
      },
      {
        x: 550,
        y: 450,
        color: "blue",
        radius: 40,
        finishpoint: 3
      },
      {
        x: 650,
        y: 450,
        color: "white",
        radius: 40,
        waypoint: 3
      },
      {
        x: 750,
        y: 450,
        color: "white",
        radius: 40,
        waypoint: 4
      },
      {
        x: 850,
        y: 450,
        color: "white",
        radius: 40,
        waypoint: 5
      },
      {
        x: 950,
        y: 450,
        color: "white",
        radius: 40,
        waypoint: 6
      },
      {
        x: 150,
        y: 550,
        color: "white",
        radius: 40,
        waypoint: 23
      },
      {
        x: 250,
        y: 550,
        color: "red",
        radius: 40,
        finishpoint: 1
      },
      {
        x: 350,
        y: 550,
        color: "red",
        radius: 40,
        finishpoint: 2
      },
      {
        x: 450,
        y: 550,
        color: "red",
        radius: 40,
        finishpoint: 3
      },
      {
        x: 650,
        y: 550,
        color: "green",
        radius: 40,
        finishpoint: 3
      },
      {
        x: 750,
        y: 550,
        color: "green",
        radius: 40,
        finishpoint: 2
      },
      {
        x: 850,
        y: 550,
        color: "green",
        radius: 40,
        finishpoint: 1
      },
      {
        x: 950,
        y: 550,
        color: "white",
        radius: 40,
        waypoint: 7
      },
      {
        x: 150,
        y: 650,
        color: "white",
        radius: 40,
        waypoint: 22
      },
      {
        x: 250,
        y: 650,
        color: "white",
        radius: 40,
        waypoint: 21
      },
      {
        x: 350,
        y: 650,
        color: "white",
        radius: 40,
        waypoint: 20
      },
      {
        x: 450,
        y: 650,
        color: "white",
        radius: 40,
        waypoint: 19
      },
      {
        x: 550,
        y: 650,
        color: "yellow",
        radius: 40,
        finishpoint: 3
      },
      {
        x: 650,
        y: 650,
        color: "white",
        radius: 40,
        waypoint: 11
      },
      {
        x: 750,
        y: 650,
        color: "white",
        radius: 40,
        waypoint: 10
      },
      {
        x: 850,
        y: 650,
        color: "white",
        radius: 40,
        waypoint: 9
      },
      {
        x: 950,
        y: 650,
        color: "lightgreen",
        radius: 40,
        waypoint: 8
      },
      {
        x: 450,
        y: 750,
        color: "white",
        radius: 40,
        waypoint: 18
      },
      {
        x: 550,
        y: 750,
        color: "yellow",
        radius: 40,
        finishpoint: 2
      },
      {
        x: 650,
        y: 750,
        color: "white",
        radius: 40,
        waypoint: 12
      },
      {
        x: 450,
        y: 850,
        color: "white",
        radius: 40,
        waypoint: 17
      },
      {
        x: 550,
        y: 850,
        color: "yellow",
        radius: 40,
        finishpoint: 1
      },
      {
        x: 650,
        y: 850,
        color: "white",
        radius: 40,
        waypoint: 13
      },
      {
        x: 50,
        y: 950,
        color: "yellow",
        radius: 40,
        homepoint: 3
      },
      {
        x: 150,
        y: 950,
        color: "yellow",
        radius: 40,
        homepoint: 2
      },
      {
        x: 450,
        y: 950,
        color: "lightyellow",
        radius: 40,
        waypoint: 16
      },
      {
        x: 550,
        y: 950,
        color: "white",
        radius: 40,
        waypoint: 15
      },
      {
        x: 650,
        y: 950,
        color: "white",
        radius: 40,
        waypoint: 14
      },
      {
        x: 950,
        y: 950,
        color: "green",
        radius: 40,
        homepoint: 2
      },
      {
        x: 1050,
        y: 950,
        color: "green",
        radius: 40,
        homepoint: 1
      },
      {
        x: 150,
        y: 1050,
        color: "yellow",
        radius: 40,
        homepoint: 1
      },
      {
        x: 950,
        y: 1050,
        color: "green",
        radius: 40,
        homepoint: 3
      }
    ],
    aTokenData: [
      {
        x: 50,
        y: 150,
        color: "red",
        identifier: "token3",
        radius: 30,
        fieldtype: "homepoint",
        fieldnumber: 3
      },
      {
        x: 150,
        y: 150,
        color: "red",
        identifier: "token2",
        radius: 30,
        fieldtype: "homepoint",
        fieldnumber: 2
      },
      {
        x: 150,
        y: 50,
        color: "red",
        identifier: "token1",
        radius: 30,
        fieldtype: "homepoint",
        fieldnumber: 1
      },
      {
        x: 1050,
        y: 150,
        color: "blue",
        identifier: "token3",
        radius: 30,
        fieldtype: "homepoint",
        fieldnumber: 3
      },
      {
        x: 950,
        y: 50,
        color: "blue",
        identifier: "token1",
        radius: 30,
        fieldtype: "homepoint",
        fieldnumber: 1
      },
      {
        x: 950,
        y: 150,
        color: "blue",
        identifier: "token2",
        radius: 30,
        fieldtype: "homepoint",
        fieldnumber: 2
      },
      {
        x: 50,
        y: 950,
        color: "yellow",
        identifier: "token3",
        radius: 30,
        fieldtype: "homepoint",
        fieldnumber: 3
      },
      {
        x: 150,
        y: 950,
        color: "yellow",
        identifier: "token2",
        radius: 30,
        fieldtype: "homepoint",
        fieldnumber: 2
      },
      {
        x: 150,
        y: 1050,
        color: "yellow",
        identifier: "token1",
        radius: 30,
        fieldtype: "homepoint",
        fieldnumber: 1
      },
      {
        x: 950,
        y: 950,
        color: "green",
        identifier: "token2",
        radius: 30,
        fieldtype: "homepoint",
        fieldnumber: 2
      },
      {
        x: 950,
        y: 1050,
        color: "green",
        identifier: "token3",
        radius: 30,
        fieldtype: "homepoint",
        fieldnumber: 3
      },
      {
        x: 1050,
        y: 950,
        color: "green",
        identifier: "token1",
        radius: 30,
        fieldtype: "homepoint",
        fieldnumber: 1
      }
    ],
    oEntryPoints: {
      red: 24,
      blue: 0,
      yellow: 16,
      green: 8
    },
    oFinishZonePoint: {
      red: 23,
      blue: 31,
      yellow: 15,
      green: 7
    },

    oColors: {
      red: "red",
      blue: "blue",
      green: "green",
      yellow: "yellow"
    },

    oFieldTypes: {
      waypoint: "waypoint",
      homepoint: "homepoint",
      finishpoint: "finishpoint"
    },
    aWaypoints: new Array(32),

    oFinishPoints: {
      red: new Array(3),
      blue: new Array(3),
      green: new Array(3),
      yellow: new Array(3)
    },

    oPlayers: {},
    oCurrentPlayer: {},
    iDiced: 0,
    isGameEnd: false,
    isDiced: false
  }),
  // end data
  created() {
    this.$eventBus.$on("setIDiced", data => {
      this.iDiced = data;
      d3.select(".diced").text(this.iDiced);
    });
    this.$eventBus.$on("tempAlert", data => {
      this.tempAlert(data.msg, data.color, data.background);
    });
    this.$eventBus.$on("setIsDiced", data => {
      this.isDiced = data;
    });
    this.$eventBus.$on("setNextPlayer", () => {
      this.setNextPlayer();
    });
    this.$eventBus.$on("dice", () => {
      this.dice();
    });
    this.$eventBus.$on("isAbleToTakeTurn", () => {
      if (!this.isAbleToTakeTurn()) {
        // check this currentplayer can do a turn, if not -> give turn to next player
        this.$eventBus.$emit("tempAlert", {
          msg:
            this.oCurrentPlayer.color +
            " loses turn, the turn is given to next player!!!",
          color: this.oCurrentPlayer.color
        });
        this.$eventBus.$emit("setNextPlayer");
        this.$eventBus.$emit("dice");
        return;
      }
    });
  },
  mounted() {
    this.init();
    this.create();
  },

  methods: {
    getWaypoint(iWaypoint) {
      return this.aWaypoints[iWaypoint];
    },
    setWaypoint(iWaypoint, oToken) {
      this.aWaypoints[iWaypoint] = oToken;
    },
    clearWaypoint(iWaypoint) {
      this.aWaypoints[iWaypoint] = undefined;
    },
    init() {
      var player = {
        color: "",
        next: {}
      };
      this.oPlayers = {
        blue: Object.create(player),
        red: Object.create(player),
        yellow: Object.create(player),
        green: Object.create(player)
      };
      this.oPlayers.blue.color = this.oColors.blue;
      this.oPlayers.blue.next = this.oPlayers.green;
      this.oPlayers.green.color = this.oColors.green;
      this.oPlayers.green.next = this.oPlayers.yellow;
      this.oPlayers.yellow.color = this.oColors.yellow;
      this.oPlayers.yellow.next = this.oPlayers.red;
      this.oPlayers.red.color = this.oColors.red;
      this.oPlayers.red.next = this.oPlayers.blue;

      this.oCurrentPlayer = this.oPlayers.blue;

      this.dice();
      d3.select(".currentplayer").text(this.oCurrentPlayer.color);

      // console.log("the current player is " + this.oCurrentPlayer.color + ", he diced a " + this.iDiced);
    },
    next() {
      var winner = this.getWinner();
      // check there were a winner?
      if (winner !== null) {
        alert("The winner is " + winner);
        return;
      }
      // is player have a special dice => continue turn
      if (!this.isSpecialDice()) {
        this.setNextPlayer();
      } else {
        this.tempAlert(
          this.oCurrentPlayer.color +
            " player has a special dice, continue turn!!!",
          this.oCurrentPlayer.color
        );
      }

      this.dice();

      // log
      d3.select(".diced").text("?");
    },
    // move token from homepoint to entry point
    entryMove(oToken) {
      var datum = d3
        .select(".gamefield.waypoint.point" + this.oEntryPoints[oToken.color])
        .datum();

      if (this._waypointIsFree(oToken)) {
        this.tempAlert(
          oToken.color + " horse comes out!!!",
          this.oCurrentPlayer.color
        );
        this.jump(oToken, datum);
        return;
      }

      this.tempAlert(
        oToken.color + " horse cann't comes out from home point!!!",
        "black",
        "red"
      );
    },
    isSpecialDice() {
      return this.iDiced === 1 || this.iDiced === 6;
    },
    // if second paramter is not given, the entryfield of the oToken will be checked.
    // if an enemy token sits on the waypoint, it will be striked and the function returns true
    // (obj, number)
    _waypointIsFree(oToken, iField, isTest) {
      var token;
      if (iField != undefined) {
        // getWaypoint from next step OR get waypoint from home to start point

        for (
          var i = oToken.fieldnumber + 1;
          i < oToken.fieldnumber + this.iDiced;
          i++
        ) {
          token = this.getWaypoint(i % 32);
          if (token) {
            // is a token between current point and target point
            this.tempAlert(
              oToken.color +
                " horse has been prevent by " +
                token.color +
                " horse!!!",
              "black",
              "red"
            );
            return false;
          }
        }

        token = this.getWaypoint((oToken.fieldnumber + this.iDiced) % 32);
      } else {
        token = this.getWaypoint(this.oEntryPoints[oToken.color]);
      }
      // check waypoint greater than one round per chess

      if (!token) {
        // the waypoint is empty -> can stand in
        return true;
      }
      if (this._isEnemyStandInTargetPoint(oToken, token)) {
        // the waypoint contain an enemy
        //STRIKE
        if (!isTest) {
          this.tempAlert(
            token.color +
              " horse has been striked by " +
              oToken.color +
              " horse!!!",
            this.oCurrentPlayer.color,
            "white"
          );
          this.strike(token);
        }
        return true;
      }
      // waypoint have an ally
      // this.tempAlert("This " + oToken.color + " horse cann't move!!!"); ==> remove
      return false;
    },
    _isEnemyStandInTargetPoint(oToken, token) {
      return oToken.color !== token.color;
    },
    _isProperPlayer(oToken) {
      return oToken.color === this.oCurrentPlayer.color;
    },
    strike(token) {
      var datum = d3
        .select(
          ".gamefield.homepoint.point" + this._getHomeField(token) + token.color
        )
        .datum();
      this.jump(token, datum);
    },
    _getHomeField(token) {
      return token.identifier.substring(5, 6) + ".";
    },
    // move from waypoint or finishzone
    move(oToken) {
      var target = (oToken.fieldnumber + this.iDiced) % 32;
      if (this._reachesFinishZone(oToken)) {
        // if current position reaches finish zone( c?a chu?ng )

        if (this._isAbleToMoveToFinishArea(oToken)) {
          var datum = d3
            .select(
              ".gamefield.finishpoint.point" +
              this.iDiced +
              "." + // number + "." //this._getFinishField(oToken)
                oToken.color // color
            )
            .datum();
          this.jump(oToken, datum);
        } else {
          this.tempAlert(
            "This " +
              oToken.color +
              " horse cann't go to the finish point " +
              this.iDiced +
              "!!!",
            "black",
            "red"
          );
        }
      } else {
        // cho ?i ti?p
        if (this._isTargetPositionGreaterThanOneRound(oToken)) {
          this.tempAlert(
            "This " + oToken.color + " horse cann't go more than one round!!!",
            "black",
            "red"
          );
          return;
        }

        if (this._waypointIsFree(oToken, target)) {
          var datum = d3.select(".gamefield.waypoint.point" + target).datum();
          this.jump(oToken, datum);
        }
      }
    },
    // the rules said one chess in way cann't go more than one round
    _isTargetPositionGreaterThanOneRound(oToken) {
      var target = oToken.fieldnumber + this.iDiced;
      if (
        oToken.fieldnumber < this.oFinishZonePoint[oToken.color] &&
        target > this.oFinishZonePoint[oToken.color]
      ) {
        return true;
      }

      return false;
    },

    _reachesFinishZone(oToken) {
      //

      if (oToken.fieldnumber == this.oFinishZonePoint[oToken.color]) {
        return true;
      }
      return false;
    },
    _getFinishField(oToken) {
      if (oToken.fieldtype === this.oFieldTypes.waypoint) {
        var wayToGoOutside =
          this.oEntryPoints[oToken.color] - oToken.fieldnumber;
        var wayToGoInside = this.iDiced - wayToGoOutside;
        return wayToGoInside - 1;
      } else {
        // must be a finishpoint
      }
    },
    _isAbleToMoveToFinishArea(oToken) {
      var i = 0,
        stepsInFinishArea = this.iDiced;
      //cant be greater than 4
      if (stepsInFinishArea > 3) {
        return false;
      } else {
        for (i = 0; i <= stepsInFinishArea; i++) {
          if (this.oFinishPoints[oToken.color][i]) {
            return false;
          }
        }
        return true;
      }
    },
    jump(oToken, oDestination) {
      var datum = oDestination;
      if (datum.waypoint !== undefined) {
        this.tempAlert(
          oToken.color +
            " " +
            oToken.fieldtype +
            " " +
            oToken.fieldnumber +
            " horse move to waypoint " +
            oDestination.waypoint,
          this.oCurrentPlayer.color
        );
        d3.select("." + oToken.identifier + "." + oToken.color)
          .transition()
          .ease("bounce")
          .duration(2000)
          .attr("transform", function(d) {
            return "translate(" + datum.x + "," + datum.y + ")";
          });
      } else if (datum.homepoint !== undefined) {
        // is homepoint
        this.tempAlert(
          oToken.color +
            " " +
            oToken.fieldtype +
            " " +
            oToken.fieldnumber +
            " horse move to homepoint " +
            oDestination.homepoint,
          this.oCurrentPlayer.color
        );
        setTimeout(() => {
          d3.select("." + oToken.identifier + "." + oToken.color)
            .transition()
            .ease("elastic")
            .duration(1000)
            .attr("transform", function(d) {
              return "translate(" + datum.x + "," + datum.y + ")";
            });
        }, 700);
      } else {
        // is finishpoint
        this.tempAlert(
          oToken.color +
            " " +
            oToken.fieldtype +
            " " +
            oToken.fieldnumber +
            " horse move to finishpoint " +
            oDestination.finishpoint,
          this.oCurrentPlayer.color
        );

        d3.select("." + oToken.identifier + "." + oToken.color)
          .transition()
          .ease("back")
          .duration(2000)
          .attr("transform", function(d) {
            return "translate(" + datum.x + "," + datum.y + ")";
          });
      }

      oToken.x = datum.x;
      oToken.y = datum.y;
      this._updateData(oToken, datum);
      if (!datum.homepoint)
        // if the jumper is striked, don't set next turn, keep it for the striker jump
        this.next();
    },
    _updateData(oToken, oDatum) {
      if (oDatum.waypoint || oDatum.waypoint === 0) {
        //if oToken will go to a waypoint, doublecheck because 0 is a falsy value, but for us its fine
        this.setWaypoint(oDatum.waypoint, oToken);
        oToken.fieldtype = this.oFieldTypes.waypoint;
        if (oToken.fieldtype === this.oFieldTypes.waypoint) {
          this.clearWaypoint(oToken.fieldnumber);
        }
      } else if (oDatum.finishpoint) {
        //if oToken will go to a finishpoint
        this.clearWaypoint(oToken.fieldnumber);
        oToken.fieldtype = this.oFieldTypes.finishpoint;
        this.oFinishPoints[oDatum.color][oDatum.finishpoint] = oToken;
      } else if (oDatum.homepoint) {
        // oToken just got striked, and will go to a homepoint
        this.clearWaypoint(oToken.fieldnumber);
        oToken.fieldtype = this.oFieldTypes.homepoint;
      }
      oToken.fieldnumber =
        oDatum.waypoint || oDatum.homepoint || oDatum.finishpoint;
      if (oDatum.waypoint === 0) {
        //TODO refactor.. just a workaround around falsy 0
        oToken.fieldnumber = 0;
      }
    },
    action(oToken) {
      if (!this._isProperPlayer(oToken)) {
        // is your turn ?

        this.tempAlert("Not " + oToken.color + " turn!!!", "black", "red");
        return;
      }
      if (!this.isDiced) {
        // is diced ?
        this.tempAlert(
          "Dice first to make a " + oToken.color + " turn!!!",
          "black",
          "red"
        );
        return;
      }

      //decide which action to do
      if (oToken.fieldtype === this.oFieldTypes.homepoint) {
        if (!this.isSpecialDice()) {
          this.tempAlert(
            "This " + oToken.color + " dont have special dice!!!",
            "black",
            "red"
          );
          return;
        }
        this.entryMove(oToken);
        return;
      }

      if (oToken.fieldtype === this.oFieldTypes.waypoint) {
        this.move(oToken);
        return;
      }

      if (oToken.fieldtype === this.oFieldTypes.finishpoint) {
        this.finishMove(oToken);
        return;
      }
    },
    finishMove(oToken) {
      if (this._isAbleToMoveFromFinishArea(oToken)) {
        // do somethink
        var datum = d3
          .select(
            ".gamefield.finishpoint.point" +
            this.iDiced +
            "." + // number + "." //this._getFinishField(oToken)
              oToken.color // color
          )
          .datum();
        debugger;
        this.jump(oToken, datum);
      } else {
        this.tempAlert(
          "This " +
            oToken.color +
            " horse cann't move to finish point " +
            this.iDiced +
            "!!!",
          "black",
          "red"
        );
        return;
      }
    },
    _isAbleToMoveFromFinishArea(oToken) {
      if (oToken.fieldnumber !== 3 && this.iDiced === oToken.fieldnumber + 1)
        return true;

      return false;
    },
    _clickedElementIsOnHomepoint(oGroupSelection) {
      var tokenClass = this._getTokenClass(oGroupSelection);
      var colorClass = this._getColorClass(oGroupSelection);
      //this.oPlayers[colorClass]
    },
    dice() {
      this.isDiced = false;
      return this.iDiced;
    },
    setNextPlayer() {
      this.oCurrentPlayer = this.oCurrentPlayer.next;
      this.$eventBus.$emit("tempAlert", {
        msg: this.oCurrentPlayer.color + " is current player!!!",
        color: this.oCurrentPlayer.color
      });
      // this.oCurrentPlayer = {color: "green"};
      d3.select(".currentplayer").text(this.oCurrentPlayer.color);
      d3.select(".diced").text("?");
      return this.oCurrentPlayer;
    },
    tempAlert(msg, color, background) {
      var today = new Date();
      var time =
        today.getHours() + ":" + today.getMinutes() + ":" + today.getSeconds();

      console.log(
        time + " %c" + msg,
        "color: " + color + ";background:" + background + ";"
      );
    },
    isAbleToTakeTurn() {
      // check that this currentplayer can take a turn in any horse

      var datum;
      for (var i = 0; i < 3; i++) {
        datum = d3
          .select("." + this.oCurrentPlayer.color + ".token.token" + (i + 1))
          .datum();

        if (
          datum.fieldtype === this.oFieldTypes.homepoint &&
          this._waypointIsFree(datum, undefined, true)
        ) {
          // if in homepoint check
          if (!this.isSpecialDice()) {
            // check if not a special dice, cann't jump from homepoint
            continue;
          }
          return true;
        }

        if (datum.fieldtype === this.oFieldTypes.waypoint) {
          if (this._reachesFinishZone(datum)) {
            // if current position reaches finish zone( c?a chu?ng )

            if (this._isAbleToMoveToFinishArea(datum)) {
              return true;
            } else {
              return false;
            }
          } else {
            // cho ?i ti?p
            if (this._isTargetPositionGreaterThanOneRound(datum)) {
              return false;
            }

            if (this._waypointIsFree(datum, this.iDiced, true)) {
              return true;
            }
          }
        }

        if (
          datum.fieldtype === this.oFieldTypes.finishpoint &&
          this._isAbleToMoveFromFinishArea(datum)
        ) {
          return true;
        }
      }

      return false;
    },
    getWinner() {
      var red = 0,
        blue = 0,
        green = 0,
        yellow = 0;

      d3.selectAll(".token").each((d, i) => {
        if (d.fieldtype === this.oFieldTypes.finishpoint) {
          switch (d.color) {
            case this.oColors.red:
              red++;
              break;
            case this.oColors.blue:
              blue++;
              break;
            case this.oColors.green:
              green++;
              break;
            case this.oColors.yellow:
              yellow++;
              break;
            default:
              break;
          }
        }
      });

      if (red === 3) return this.oColors.red;
      if (blue === 3) return this.oColors.blue;
      if (green === 3) return this.oColors.green;
      if (yellow === 3) return this.oColors.yellow;

      return null;
    },
    create() {
      var width = 1100,
        height = 1100;

      var x = d3.scale.identity().domain([0, width]);

      var y = d3.scale.identity().domain([0, height]);

      var xAxis = d3.svg
        .axis()
        .scale(x)
        .orient("top");

      var yAxis = d3.svg
        .axis()
        .scale(y)
        .orient("left");

      var header = d3
        .select("#table")
        .append("div")
        .attr("class", "headertext");
      header
        .append("div")
        .attr("class", "currentplayer")
        .text("blue");
      header
        .append("div")
        .attr("class", "diced")
        .text("?");

      var svg = d3
        .select("#table")
        .append("svg")
        .attr("width", width)
        .attr("height", height);

      var field = svg.append("g").attr("class", "field");

      field
        .append("g")
        .attr("class", "x axis")
        .call(xAxis);

      field
        .append("g")
        .attr("class", "y axis")
        .call(yAxis);

      field
        .append("rect")
        .attr("x", 0)
        .attr("y", 0)
        .attr("width", width)
        .attr("height", height)
        .style("fill", "wheat");

      var oGroupSelection = field
        .selectAll("circle")
        .data(this.aGameFields)
        .enter()
        .append("g")
        .attr("class", function(d) {
          if (d.waypoint || d.waypoint === 0)
            // 0 is falsy so we need to doublecheck
            return "gamefield waypoint point" + d.waypoint;
          if (d.homepoint)
            return "gamefield homepoint point" + d.homepoint + " " + d.color;
          if (d.finishpoint)
            return (
              "gamefield finishpoint point" + d.finishpoint + " " + d.color
            );
        })
        .attr("transform", function(d) {
          return "translate(" + d.x + "," + d.y + ")";
        });

      oGroupSelection
        .append("circle")
        .attr("x", 50)
        .attr("y", 50)
        .attr("r", function(d) {
          return d.radius;
        })
        .style("fill", function(d) {
          return d.color;
        })
        .style("stroke-width", 2)
        .style("stroke", "black");
      oGroupSelection
        .append("text")
        .attr("cx", 50)
        .attr("cy", 50)
        .text(function(d) {
          return d.waypoint || d.homepoint || d.finishpoint || 0;
        })
        .attr("font-family", "sans-serif")
        .attr("font-size", "20px")
        .attr("fill", "black");
      // ============= end create table =================
      var that = this;
      // set space bar keyup is roll dice
      document.body.onkeyup = function(e) {
        if (e.keyCode == 32) {
          document.getElementById("roll-button").click();
        }
      };

      field
        .selectAll("token")
        .data(this.aTokenData)
        .enter()
        .append("g")
        .attr("class", function(d) {
          return d.color + " token " + d.identifier;
        })
        .attr("transform", function(d) {
          return "translate(" + d.x + "," + d.y + ")";
        })
        .on("click", function(d) {
          $.proxy(that.action, that, d)();
        })
        .append("circle")
        .attr("x", 0)
        .attr("y", 0)
        .attr("r", function(d) {
          return d.radius;
        })
        .style("fill", function(d) {
          return d.color;
        })
        .style("stroke-width", 5)
        .style("stroke", "black")
        .select(function() {
          return this.parentNode;
        })
        .append("image")
        .attr("xlink:href", "https://freesvg.org/img/Chess-Knight.png")
        .attr("x", -50)
        .attr("y", -80)
        .attr("width", 100)
        .attr("height", 100);
    }
  }
};
</script>

<style>
</style>