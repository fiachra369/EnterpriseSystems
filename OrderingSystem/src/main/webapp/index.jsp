<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Food Ordering System</title>
</head>
<body>
	
    <form action= "http://localhost:8080/resteasy/restful-services/sampleservice/AddToOrder" method="GET">
        
        
        <input type="submit" value="Order Food">
    </form>
    
    <form action= "http://localhost:8080/resteasy/restful-services/sampleservice/DeliveryInfo" method="GET">
        
        
        <input type="submit" value="Delivery Information">
    </form>
    
    <form action= "http://localhost:8080/resteasy/restful-services/sampleservice/MarketingInfo" method="GET">
        
        
        <input type="submit" value="Marketing Information">
    </form>
	
	  
	
</body>
</html>