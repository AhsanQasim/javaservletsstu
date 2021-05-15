<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="insert" method="post">
<dev id="buttons">
<button type="submit" formaction="first" method="post">first</button>
<button type="submit"formaction="next" method="post">Next</button>
<button type="submit" formaction="last" method="post">Last</button>
<input type="submit" name="insert" value="Insert">
<button type="submit" formaction="clear" method="post">Clear</button>
<button type="submit" formaction="update" method="post">Update</button>
</dev>
<br><br>
<dev id="name">
<label for="tlname"> Last Name:</label>
<input type="text" id="tlname" name="tlname">
<label for="tfname"> First Name: </label>
<input type="text" id="tfname" name="tfname">
<label for="tmi"> mi: </label>
<input type="text" id="tmi" name="tmi" value="">
</dev>
<br><br>
<dev id="stuid">
<label for="lstu"> Student ID: </label>
<input type="text" id="tstuid" name="tstuid">
</dev>
<br><br>
<dev id="year">
<label for="year"> Year:</label>
<input type="text" id="tyear" name="tyear">
<label for="country"> country: </label>
<input type="text" id="tcountry" name="tcountry">
</dev>
<br><br>
<dev id="em">
<label for="lemail"> Email: </label>
<input type="text" id="temail" name="temail">
</dev>
<label for="lnotification"> </label>
</form>
<script>
var bool = "<%= request.getAttribute("bool") %>";
if (bool=="first") {
	var mir = '<%= request.getAttribute("mii") %>';
  	document.getElementById("tmi").value = mir;
  	document.getElementById("tfname").value = '<%= request.getAttribute("firsti") %>';
  	document.getElementById("tlname").value = '<%= request.getAttribute("lasti") %>';
  	document.getElementById("tstuid").value = '<%= request.getAttribute("stuidi") %>';
  	document.getElementById("tyear").value = '<%= request.getAttribute("yeari") %>';
  	document.getElementById("tcountry").value = '<%= request.getAttribute("countryi") %>';
  	document.getElementById("temail").value = '<%= request.getAttribute("emaili") %>';
	}
else if (bool=="last") {
	var mir = '<%= request.getAttribute("miii") %>';
  	document.getElementById("tmi").value = mir;
  	document.getElementById("tfname").value = '<%= request.getAttribute("firstii") %>';
  	document.getElementById("tlname").value = '<%= request.getAttribute("lastii") %>';
  	document.getElementById("tstuid").value = '<%= request.getAttribute("stuidii") %>';
  	document.getElementById("tyear").value = '<%= request.getAttribute("yearii") %>';
  	document.getElementById("tcountry").value = '<%= request.getAttribute("countryii") %>';
  	document.getElementById("temail").value = '<%= request.getAttribute("emailii") %>';
	}
else if (bool=="next") {
	var mir = '<%= request.getAttribute("miii") %>';
  	document.getElementById("tmi").value = mir;
  	document.getElementById("tfname").value = '<%= request.getAttribute("firstii") %>';
  	document.getElementById("tlname").value = '<%= request.getAttribute("lastii") %>';
  	document.getElementById("tstuid").value = '<%= request.getAttribute("stuidii") %>';
  	document.getElementById("tyear").value = '<%= request.getAttribute("yearii") %>';
  	document.getElementById("tcountry").value = '<%= request.getAttribute("countryii") %>';
  	document.getElementById("temail").value = '<%= request.getAttribute("emailii") %>';
  	document.getElementById("lnotification").value = '<%= request.getAttribute("limiti") %>';
  	
  	
	}
else if (bool=="update") {
  	document.getElementById("tmi").value = '';
  	document.getElementById("tfname").value = '';
  	document.getElementById("tlname").value = '';
  	document.getElementById("tstuid").value = '';
  	document.getElementById("tyear").value = '';
  	document.getElementById("tcountry").value = '';
  	document.getElementById("temail").value = '';
  	document.getElementById("lnotification").value = '<%= request.getAttribute("limiti") %>';
	}
else if (bool=="clear") {
  	document.getElementById("tmi").value = '';
  	document.getElementById("tfname").value = '';
  	document.getElementById("tlname").value = '';
  	document.getElementById("tstuid").value = '';
  	document.getElementById("tyear").value = '';
  	document.getElementById("tcountry").value = '';
  	document.getElementById("temail").value = '';
	}


</script>
</body>
</html>