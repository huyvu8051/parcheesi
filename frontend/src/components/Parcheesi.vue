<template>
  <v-container fluid fill-height>
    <v-layout align-center justify-center>
      <v-flex xs12 sm12 md8>
        <Dice :isDiced="this.isDiced" :iDiced="this.iDiced" :oCurrentPlayer="this.oCurrentPlayer" />
        <div id="table" />
      </v-flex>
    </v-layout>
  </v-container>
</template>

<script>
import Dice from "./Dice";

import PlayerService from "@/services/Game";
export default {
  name: "App",
  components: {
    Dice: Dice
  },
  data: () => ({
    aGameFields: [
      {
        x: 150,
        y: 50,
        color: "RED",
        radius: 40,
        homepoint: 3
      },
      {
        x: 950,
        y: 50,
        color: "BLUE",
        radius: 40,
        homepoint: 1
      },
      {
        x: 50,
        y: 150,
        color: "RED",
        radius: 40,
        homepoint: 1
      },
      {
        x: 150,
        y: 150,
        color: "RED",
        radius: 40,
        homepoint: 2
      },
      {
        x: 450,
        y: 150,
        color: "WHITE",
        radius: 40,
        waypoint: 30
      },
      {
        x: 550,
        y: 150,
        color: "WHITE",
        radius: 40,
        waypoint: 31
      },
      {
        x: 650,
        y: 150,
        color: "WHITE",
        radius: 40,
        waypoint: 0
      },
      {
        x: 950,
        y: 150,
        color: "BLUE",
        radius: 40,
        homepoint: 2
      },
      {
        x: 1050,
        y: 150,
        color: "BLUE",
        radius: 40,
        homepoint: 3
      },
      {
        x: 450,
        y: 250,
        color: "WHITE",
        radius: 40,
        waypoint: 29
      },
      {
        x: 550,
        y: 250,
        color: "BLUE",
        radius: 40,
        finishpoint: 1
      },
      {
        x: 650,
        y: 250,
        color: "WHITE",
        radius: 40,
        waypoint: 1
      },
      {
        x: 450,
        y: 350,
        color: "WHITE",
        radius: 40,
        waypoint: 28
      },
      {
        x: 550,
        y: 350,
        color: "BLUE",
        radius: 40,
        finishpoint: 2
      },
      {
        x: 650,
        y: 350,
        color: "WHITE",
        radius: 40,
        waypoint: 2
      },
      {
        x: 150,
        y: 450,
        color: "WHITE",
        radius: 40,
        waypoint: 24
      },
      {
        x: 250,
        y: 450,
        color: "WHITE",
        radius: 40,
        waypoint: 25
      },
      {
        x: 350,
        y: 450,
        color: "WHITE",
        radius: 40,
        waypoint: 26
      },
      {
        x: 450,
        y: 450,
        color: "WHITE",
        radius: 40,
        waypoint: 27
      },
      {
        x: 550,
        y: 450,
        color: "BLUE",
        radius: 40,
        finishpoint: 3
      },
      {
        x: 650,
        y: 450,
        color: "WHITE",
        radius: 40,
        waypoint: 3
      },
      {
        x: 750,
        y: 450,
        color: "WHITE",
        radius: 40,
        waypoint: 4
      },
      {
        x: 850,
        y: 450,
        color: "WHITE",
        radius: 40,
        waypoint: 5
      },
      {
        x: 950,
        y: 450,
        color: "WHITE",
        radius: 40,
        waypoint: 6
      },
      {
        x: 150,
        y: 550,
        color: "WHITE",
        radius: 40,
        waypoint: 23
      },
      {
        x: 250,
        y: 550,
        color: "RED",
        radius: 40,
        finishpoint: 1
      },
      {
        x: 350,
        y: 550,
        color: "RED",
        radius: 40,
        finishpoint: 2
      },
      {
        x: 450,
        y: 550,
        color: "RED",
        radius: 40,
        finishpoint: 3
      },
      {
        x: 650,
        y: 550,
        color: "GREEN",
        radius: 40,
        finishpoint: 3
      },
      {
        x: 750,
        y: 550,
        color: "GREEN",
        radius: 40,
        finishpoint: 2
      },
      {
        x: 850,
        y: 550,
        color: "GREEN",
        radius: 40,
        finishpoint: 1
      },
      {
        x: 950,
        y: 550,
        color: "WHITE",
        radius: 40,
        waypoint: 7
      },
      {
        x: 150,
        y: 650,
        color: "WHITE",
        radius: 40,
        waypoint: 22
      },
      {
        x: 250,
        y: 650,
        color: "WHITE",
        radius: 40,
        waypoint: 21
      },
      {
        x: 350,
        y: 650,
        color: "WHITE",
        radius: 40,
        waypoint: 20
      },
      {
        x: 450,
        y: 650,
        color: "WHITE",
        radius: 40,
        waypoint: 19
      },
      {
        x: 550,
        y: 650,
        color: "YELLOW",
        radius: 40,
        finishpoint: 3
      },
      {
        x: 650,
        y: 650,
        color: "WHITE",
        radius: 40,
        waypoint: 11
      },
      {
        x: 750,
        y: 650,
        color: "WHITE",
        radius: 40,
        waypoint: 10
      },
      {
        x: 850,
        y: 650,
        color: "WHITE",
        radius: 40,
        waypoint: 9
      },
      {
        x: 950,
        y: 650,
        color: "WHITE",
        radius: 40,
        waypoint: 8
      },
      {
        x: 450,
        y: 750,
        color: "WHITE",
        radius: 40,
        waypoint: 18
      },
      {
        x: 550,
        y: 750,
        color: "YELLOW",
        radius: 40,
        finishpoint: 2
      },
      {
        x: 650,
        y: 750,
        color: "WHITE",
        radius: 40,
        waypoint: 12
      },
      {
        x: 450,
        y: 850,
        color: "WHITE",
        radius: 40,
        waypoint: 17
      },
      {
        x: 550,
        y: 850,
        color: "YELLOW",
        radius: 40,
        finishpoint: 1
      },
      {
        x: 650,
        y: 850,
        color: "WHITE",
        radius: 40,
        waypoint: 13
      },
      {
        x: 50,
        y: 950,
        color: "YELLOW",
        radius: 40,
        homepoint: 3
      },
      {
        x: 150,
        y: 950,
        color: "YELLOW",
        radius: 40,
        homepoint: 2
      },
      {
        x: 450,
        y: 950,
        color: "WHITE",
        radius: 40,
        waypoint: 16
      },
      {
        x: 550,
        y: 950,
        color: "WHITE",
        radius: 40,
        waypoint: 15
      },
      {
        x: 650,
        y: 950,
        color: "WHITE",
        radius: 40,
        waypoint: 14
      },
      {
        x: 950,
        y: 950,
        color: "GREEN",
        radius: 40,
        homepoint: 2
      },
      {
        x: 1050,
        y: 950,
        color: "GREEN",
        radius: 40,
        homepoint: 1
      },
      {
        x: 150,
        y: 1050,
        color: "YELLOW",
        radius: 40,
        homepoint: 1
      },
      {
        x: 950,
        y: 1050,
        color: "GREEN",
        radius: 40,
        homepoint: 3
      }
    ],
    aTokenData: [],

    oPlayers: {},
    oCurrentPlayer: {},
    iDiced: 0,
    isGameEnd: false,
    isDiced: false
  }),
  // end data
  async created() {
    this.$eventBus.$on("tempAlert", data => {
      this.tempAlert(data.msg, data.color, data.background);
    });
  },
  async mounted() {
    this.start();
  },

  methods: {
    async start() {
      await this.loadGame();
      await this.create();
      this.connectToSocketIo();
    },
    connectToSocketIo() {
      var socket = io.connect(
        "http://localhost:8082?gameId=" + this.$route.query.gameId
      );
      var that = this;
      socket.on("action", function(data) {
        that.reloadAllToken(data);

        console.log("data from socket" + data);
      });
      socket.on("dice", function(data) {
        that.iDiced = data.diceValue;
        that.$eventBus.$emit("dice", data.diceValue);
        that.reloadAllToken(data);
      });
    },
    reloadAllToken(data){
      var that = this;

      data.tokens.forEach(e=>{
        that.jump(e);
      });
    },
    async loadGame() {
      try {
        // console.log(this.$route.params.game);
        console.log(this.$route.query.gameId);

        var response = await PlayerService.loadGame({
          id: this.$route.query.gameId
        });

        this.aTokenData = response.data.tokens;
        console.log(response);
      } catch (e) {
        console.log(e);
      }
    },
    async action(oToken) {
      try {
        var response = await PlayerService.action({
          id: oToken.id
        });

        console.log(response);
      } catch (e) {
        console.log(e);
      }
    },

    // oToken must have id
    // oDestination must have color, fieldtype and fieldnumber
    jump(oToken) {
      var gamefield = this.getGameField(
        oToken.color,
        oToken.fieldtype,
        oToken.fieldnumber
      );

      oToken.x = gamefield.x;
      oToken.y = gamefield.y;

      d3.select(".id" + oToken.id)
        .transition()
        .ease("back")
        .duration(500)
        .attr("transform", function(d) {
          return "translate(" + oToken.x + "," + oToken.y + ")";
        });
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
        .text("BLUE");
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
          return d.color + " token" + " id" + d.id;
        })
        .attr("transform", function(d) {
          var gamefield = that.getGameField(
            d.color,
            d.fieldtype,
            d.fieldnumber
          );
          console.log(gamefield);
          return "translate(" + gamefield.x + "," + gamefield.y + ")";
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
          return d.identifier;
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
    },
    getGameField(color, fieldtype, fieldnumber) {
      var gamefield = null;

      this.aGameFields.forEach(e => {
        if (
          e[fieldtype.toLowerCase()] !== undefined &&
          e.color === color &&
          e[fieldtype.toLowerCase()] === fieldnumber
        ) {
          gamefield = e;
          return;
        }
      });
      return gamefield;
    }
  }
};
</script>

<style>
</style>