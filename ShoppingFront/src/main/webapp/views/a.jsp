<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Index</title>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <style>
  .carousel-inner > .item > img,
  .carousel-inner > .item > a > img {
      width: 70%;
      margin: auto;
  }
  </style>
</head>
<body>


  
  <div class="container">
		<div class="row">
			<div class="col-sm-4">
				<h2>Fastrack Smart Watches</h2>
				<div class="embed-responsive embed-responsive-4by3">
					<iframe class="embed-responsive-item"
						src="//www.youtube.com/embed/GNsBFwK1J_g"></iframe>
				</div>
			</div>
			<div class="col-sm-4">
				<h2>Sonata Smart Watches</h2>
				<div class="embed-responsive embed-responsive-4by3">
					<iframe class="embed-responsive-item"
						src="//www.youtube.com/embed/Kd_o0eWKVdc"></iframe>
				</div>
			</div>
			<div class="col-sm-4">
				<h2>Titan Smart Watches</h2>
				<div class="embed-responsive embed-responsive-4by3">
					<iframe class="embed-responsive-item"
						src="//www.youtube.com/embed/QFOkEuaLFTA"></iframe>
				</div>
			</div>
		</div>
	</div>
	<div class="container">
  <br>
  <div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
      <li data-target="#myCarousel" data-slide-to="2"></li>
      <li data-target="#myCarousel" data-slide-to="3"></li>
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner" role="listbox">
      <div class="item active">
        <img src="resources/images/fast1.png" alt="Fastrack" width="460" height="345">
      </div>

      <div class="item">
        <img src="resources/images/fast2.png" alt="Titan" width="460" height="345">
      </div>
    
      <div class="item">
        <img src="resources/images/fast3.png" alt="Flower" width="460" height="345">
      </div>

      <div class="item">
        <img src="resources/images/fast4.png" alt="Flower" width="460" height="345">
      </div>
    </div>

    <!-- Left and right controls -->
    <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
      <span class="sr-only">Next</span>
    </a>
  </div>
</div>
<footer>
  <p align="center">Contact information:</p>
  <p align="center"><a href="www.facebook.com">Visit Our Facebook Page</a>.</p>
</footer>


</body>
</html>