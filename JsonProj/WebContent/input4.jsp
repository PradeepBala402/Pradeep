
<html>
<body>
	<h2>Json string from js array</h2>
	<p id="demo"></p>
	<script type="text/javascript">
		var arr = [ "pradeep", "rahul", "nithin" ];
		var myJson = JSON.stringify(arr);
		document.getElementById("demo").innerHTML = myJson;
	</script>
</body>
</html>