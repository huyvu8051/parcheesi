<template>
  <div id="table"></div>
</template>

<script>
export default {
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
    iDiced: 0
  }),
  // end data
  created() {
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
    createTable() {
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
        .select("body")
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

      header
        .append("button")
        .attr("onclick", "parcheesi.iDiced = 1")
        .text("set iDiced = 1");
      header
        .append("button")
        .attr("onclick", "parcheesi.iDiced = parcheesi.iDiced + 1")
        .text("set iDiced += 1");
      header
        .append("button")
        .attr("onclick", "parcheesi.iDiced = parcheesi.iDiced + 2")
        .text("set iDiced += 2");
      header
        .append("button")
        .attr("onclick", "parcheesi.iDiced = parcheesi.iDiced + 3")
        .text("set iDiced += 3");
      header
        .append("button")
        .attr("onclick", "parcheesi.iDiced = parcheesi.iDiced + 5")
        .text("set iDiced += 5");
      header
        .append("button")
        .attr("onclick", "parcheesi.iDiced = parcheesi.iDiced + 10")
        .text("set iDiced += 10");
      header
        .append("button")
        .attr("onclick", "parcheesi.iDiced = parcheesi.iDiced + 20")
        .text("set iDiced += 20");
      header
        .append("button")
        .attr("onclick", "parcheesi.iDiced = 31")
        .text("set iDiced = 31");
      var svg = d3
        .select("body")
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
        .data(aGameFields)
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
    }
  }
};
</script>

<style>
</style>