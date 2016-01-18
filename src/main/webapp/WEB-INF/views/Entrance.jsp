<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Entrance</title>
<link href="resources\css\screen.css" rel="stylesheet">
</head>
<body>
	<form action="entrance" method="post" id="usrform">
     <table border="0">
       <tr>
          <td><label>Please fill in car license</label><input type="text" id="licence" name="licence"> </td>
          <td><input type="submit" class="btn btn-primary" value="Send"></td>
      </tr>
      </table>
    </form>
</body>
</html>