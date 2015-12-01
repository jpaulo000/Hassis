<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css"
	href="../resources/css/style_chord.css">
	<link rel="stylesheet" type="text/css"
	href="../resources/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="../resources/css/bootstrap-responsive.min.css">
<title>Chord Diagram</title>
</head>
<body>
 <ul class="breadcrumb">

        <li><a href="/hassis">Página Inicial</a></li>
        <li><a href="/hassis/infograficos">Infográficos</a></li>
         <li><a href="/hassis/infograficos/internacao">Internação Compulsória</a></li>

        <li class="active">Chord</li>

    </ul>
<style>

 
#circle circle {
fill: none;
pointer-events: all;
}
 
.group path {
fill-opacity: .5;
}
 
path.chord {
stroke: #000;
stroke-width: .25px;
}
 
#circle:hover path.fade {
display: none;
}
 
</style>
 
 
<h2>HASSIS - Relação cidades &lt;-> drogas</h2>
 
 
<p>Constru&iacute;do com <a href="http://d3js.org/">d3.js</a>.</aside>
 
<script src="http://d3js.org/d3.v2.min.js?2.8.1"></script>
<!--script type="text/javascript" src="js/d3.js"></script-->
<script>
 
var width = 500,
height = 500,
outerRadius = Math.min(width, height) / 2 - 10,//raio externo
innerRadius = outerRadius - 27;//raio interno do circulo
 
var formatPercent = d3.format(".1%");
var arc = d3.svg.arc()
.innerRadius(innerRadius)
.outerRadius(outerRadius);
 
var layout = d3.layout.chord()
.padding(.04)
.sortSubgroups(d3.descending)
.sortChords(d3.ascending);
 
var path = d3.svg.chord()
.radius(innerRadius);
 
var svg = d3.select("body").append("svg")
.attr("width", width)
.attr("height", height)
.append("g")
.attr("id", "circle")
.attr("transform", "translate(" + width / 2 + "," + height / 2 + ")");
 
svg.append("circle")
.attr("r", outerRadius);
 
d3.csv("../resources/csv/mycsv.csv", function(cities) {
d3.json("../resources/json/myjson.json", function(matrix) {
// Compute the chord layout.
layout.matrix(matrix);
 
// Add a group per neighborhood.
var group = svg.selectAll(".group")
.data(layout.groups)
.enter().append("g")
.attr("class", "group")
.on("mouseover", mouseover);
 
// Add a mouseover title.
// group.append("title").text(function(d, i) {
// return cities[i].name + ": " + formatPercent(d.value) + " of origins";
// });

// Add the group arc.
var groupPath = group.append("path")
.attr("id", function(d, i) { return "group" + i; })
.attr("d", arc)
.style("fill", function(d, i) { return cities[i].color; });
 
// Add a text label.
var groupText = group.append("text")
.attr("x", 6)
.attr("dy", 15);
 
groupText.append("textPath")
.attr("xlink:href", function(d, i) { return "#group" + i; })
.text(function(d, i) { return cities[i].name; });
 
// Remove the labels that don't fit. :(
groupText.filter(function(d, i) { return groupPath[0][i].getTotalLength() / 2 - 16 < this.getComputedTextLength(); })
.remove();
 
// Add the chords.
var chord = svg.selectAll(".chord")
.data(layout.chords)
.enter().append("path")
.attr("class", "chord")
.style("fill", function(d) { return cities[d.source.index].color; })
.attr("d", path);
 
// Add an elaborate mouseover title for each chord.
 chord.append("title").text(function(d) {
 return cities[d.source.index].name
 + " → " + cities[d.target.index].name
 + ": " + formatPercent(d.source.value)
 + "\n" + cities[d.target.index].name
 + " → " + cities[d.source.index].name
 + ": " + formatPercent(d.target.value);
 });
 
function mouseover(d, i) {
chord.classed("fade", function(p) {
return p.source.index != i
&& p.target.index != i;
});
}
});
});
 
</script>
</body>
</html>