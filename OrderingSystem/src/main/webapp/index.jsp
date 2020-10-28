<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>REST Example</title>
</head>
<body>
	<form action= "http://localhost:8080/resteasy/restful-services/sampleservice/CreateUser" method="GET">
        
        
        <input type="submit" value="Create User">
    </form>
    <form action= "http://localhost:8080/resteasy/restful-services/sampleservice/AddToOrder" method="GET">
        
        
        <input type="submit" value="Create Your Order">
    </form>
    
    <form action= "http://localhost:8080/resteasy/restful-services/sampleservice/ViewOrder" method="GET">
        
        
        <input type="submit" value="View Order">
    </form>
	
	  
	
</body>
</html>