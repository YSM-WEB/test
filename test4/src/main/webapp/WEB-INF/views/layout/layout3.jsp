<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>


<!DOCTYPE html>
<html lang="ko">
  <head>
  	<link href="${cp}/static/images/icon2.PNG" type="image/x-icon" rel="shortcut icon">
    <meta charset="UTF-8">
    <title>SUNG MIN</title>
    <!--<meta name="viewport" content="width=device-width, initial-scale=1.0">-->
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <style>
  a{
    	text-decoration: none;
    	color:#646464;
    }
    a:link{
    	color:#646464;
    }
    a:visited{
    	color:#646464;
    }
   
    *{
    	padding: 0;
    	margin: 0;
    }
    html,body{
	width:100%;
	height: 100%;
}
    .bodyWrap{
    	width:100%;
	height:100%;
		
	

    }
    </style>
  </head>
   <body>
   <div class="bodyWrap">
   	 	
      <tiles:insertAttribute name="body"/> 

   </div>

  </body>
</html>
