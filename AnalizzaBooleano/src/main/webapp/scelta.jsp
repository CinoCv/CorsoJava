<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Scegli momento</title>
</head>
<body>

	<form action="Giornata">
		Seleziona il momento della giornata che preferisci:<br>
        <input type="radio" name="risposta" value="mattina" checked> Mattina<br>
		<input type="radio" name="risposta" value="giorno"> Giorno<br>
		<input type="radio" name="risposta" value="sera"> Sera<br>
	<br>
		Seleziona quante checkbox ti piacciono:<br>
        <input type="checkbox" name="primo" value="1"> Primo<br>
		<input type="checkbox" name="secondo" value="1"> Secondo<br>
		<input type="checkbox" name="terzo" value="1"> Terzo<br>
	<br>
		Scegli le parole da stampare:<br>
        <input type="checkbox" name="risp" value="Ciao "> Ciao<br>
		<input type="checkbox" name="risp" value="sono "> sono<br>
		<input type="checkbox" name="risp" value="Davide"> Davide<br>
		<input type="submit" value="Invia">
	</form>

</body>
</html>