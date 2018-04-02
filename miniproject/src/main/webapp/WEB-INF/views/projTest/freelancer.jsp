<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- bootstrap start -->
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<title></title>
<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
<script src="<c:url value="/resources/js/jquery-3.3.1.js" /> "></script>
<script src="<c:url value="/resources/js/bootstrap.min.js" /> "></script>
<!-- Bootstrap core CSS -->
<link href="<c:url value="/resources/vendor/bootstrap/css/bootstrap.min.css" />" rel="stylesheet">

<!-- Custom fonts for this template -->
<link href="<c:url value="/resources/vendor/font-awesome/css/font-awesome.min.css" />" rel="stylesheet" type="text/css">
<link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css">
<link href="https://fonts.googleapis.com/css?family=Lato:400,700,400italic,700italic" rel="stylesheet" type="text/css">

<!-- Plugin CSS -->
<link href="<c:url value="/resources/vendor/magnific-popup/magnific-popup.css" />" rel="stylesheet" type="text/css">

<!-- Custom styles for this template -->
<link href="<c:url value="/resources/css/freelancer.min.css" />" rel="stylesheet">
<link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">

<!------ Include the above in your HEAD tag ---------->
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<script src="<c:url value="/resources/js/chatTheme.js" /> "></script>
<link href="<c:url value="/resources/css/chatTheme.css" /> " rel="stylesheet">

<script src="<c:url value="/resources/js/watson.js" /> "></script>
<style>
	
</style>
</head>

<body id="page-top">

    <!-- Navigation -->
    <nav class="navbar navbar-expand-lg bg-secondary fixed-top text-uppercase" id="mainNav">
      <div class="container">
        <a class="navbar-brand js-scroll-trigger" href="#page-top">OECD 검색기</a>
        <button class="navbar-toggler navbar-toggler-right text-uppercase bg-primary text-white rounded" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
          Menu
          <i class="fa fa-bars"></i>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
          <ul class="navbar-nav ml-auto">
            <li class="nav-item mx-0 mx-lg-1">
              <a class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger" href="#portfolio">챗봇 도우미</a>
            </li>
            <li class="nav-item mx-0 mx-lg-1">
              <a class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger" href="#search">검색</a>
            </li>
            <li class="nav-item mx-0 mx-lg-1">
              <a class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger" href="#about">About</a>
            </li>
            <li class="nav-item mx-0 mx-lg-1">
              <a class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger" href="#contact">Contact</a>
            </li>
          </ul>
        </div>
      </div>
    </nav>

    <!-- Header -->
    <header class="masthead bg-primary text-white text-center">
      <div class="container">
        <img class="img-fluid mb-5 d-block mx-auto" src="<c:url value="/resources/img/earth.gif" />" alt="">
        <h1 class="text-uppercase mb-0">OECD 간편 검색기</h1>
        <hr class="star-light">
        <h3 class="font-weight-light mb-0">OECD자료를 검색하세요. 도움이 필요하면 아래의 로봇 이미지를 클릭하세요</h3>
      </div>
    </header>

    <!-- Portfolio Grid Section -->
    <section class="portfolio" id="portfolio" style="padding-bottom:100px">
      <div class="container">
        <h2 class="text-center text-uppercase text-secondary mb-0">챗봇 도우미</h2>
        <hr class="star-dark mb-5">
        <div class="row">
          <div class="col-md-6 col-lg-4" style="display:hidden">
            
              <div class="portfolio-item-caption d-flex position-absolute h-100 w-100">
                <div class="portfolio-item-caption-content my-auto w-100 text-center text-white">
                  <!-- <i class="fa fa-search-plus fa-3x"></i> -->
                </div>
              </div>
          </div>
          <div class="col-md-6 col-lg-4">
            <a class="portfolio-item d-block mx-auto" href="#portfolio-modal-1">
              <div class="portfolio-item-caption d-flex position-absolute h-100 w-100">
                <div class="portfolio-item-caption-content my-auto w-100 text-center text-white">
                  <i class="fa fa-search-plus fa-3x"></i>
                </div>
              </div>
              <img class="img-fluid" src="<c:url value="/resources/img/portfolio/chat.png" />" alt=""
               style="margin:auto">
            </a>
          </div>
          
          <div class="col-md-6 col-lg-4" style="display:hidden">
            
              <div class="portfolio-item-caption d-flex position-absolute h-100 w-100">
                <div class="portfolio-item-caption-content my-auto w-100 text-center text-white">
                  <!-- <i class="fa fa-search-plus fa-3x"></i> -->
                </div>
              </div>
          </div>
          <div class="col-md-6 col-lg-4" style="display:hidden">
              <div class="portfolio-item-caption d-flex position-absolute h-100 w-100">
                <div class="portfolio-item-caption-content my-auto w-100 text-center text-white">
                  <!-- <i class="fa fa-search-plus fa-3x"></i> -->
                </div>
              </div>
          </div>
          <div class="col-md-6 col-lg-4" style="display:hidden">
            
              <div class="portfolio-item-caption d-flex position-absolute h-100 w-100">
                <div class="portfolio-item-caption-content my-auto w-100 text-center text-white">
                  <!-- <i class="fa fa-search-plus fa-3x"></i> -->
                </div>
              </div>
          </div>
          <div class="col-md-6 col-lg-4" style="display:hidden">
            
              <div class="portfolio-item-caption d-flex position-absolute h-100 w-100">
                <div class="portfolio-item-caption-content my-auto w-100 text-center text-white">
                  <!-- <i class="fa fa-search-plus fa-3x"></i> -->
                </div>
              </div>
          </div>
        </div>
      </div>
    </section>
    
    
    <!-- search section  -->
    <section class="bg-primary text-white mb-0" id="search" style="text-align:center">
    	<div class="test">
			<h2>원하는 데이터 셋을 선택해 주십시오.</h2>
			<select id="all_set" name="availables" style="color:black; width:20em !important; min-width: 20em; max-width: 30em;">
				<option>원하는 데이터의 주제를 선택해 주십시오.</option>
				<c:forEach items="${all_Data_Sets}" var="avails">
					<option value="${avails[0] }" style="width:20em">${avails[1] }</option>
				</c:forEach>
			</select>
		</div>
		<div id="specific">
			<h2>원하는 상세 분류 내용을 선택해 주십시오.</h2>
				<select id="specific_set" style="color:black; width:20em !important;">
				</select>
		</div>
		<div id="grouping">
			<h2>원하는 상세 목록들을 선택해 주십시오.</h2>
			<select id="detail_list" onchange="save_values()" style="color:black; width:20em !important;">
			</select>
		</div>
		<div>
			<h2>추가된 분류 기준</h2>
				<select multiple class="form-control" id="sel2" style="color:black; width:20em !important; margin:auto">
    			</select>
    			<div style="padding:15px"></div>
    			<button onclick="makeQuery()">완료</button><br/>
    			<div style="padding:10px"></div>
     			<a id="getData" href="javascript:;" onclick="getData()" style="font-weight:bold; color:gray">데이터 다운로드</a>
     			<div style="visibility:hidden" id="img">
   					
     				<a id="getImg" href="javascript:;" onclick="getImg()" style="font-weight:bold; color:gray">이미지 다운로드</a>
     			</div>

    		
		</div>
		<div style="display:hidden">
			<input type="hidden" id="queryTest"></input>
    		<input type="hidden" id="startTime" ></input>
    		<input type="hidden" id="endTime"></input>
		</div>
    	
    </section>

    <!-- About Section -->
    <section id="about">
      <div class="container">
        <h2 class="text-center text-uppercase text-secondary mb-0">About</h2>
        <hr class="star-light mb-5">
        <div class="row">
          <div class="col-lg-4 ml-auto">
            <p class="lead">본 웹 페이지는 bootstrap의 freelancer 테마로 작성되었습니다.</p>
          </div>
          <div class="col-lg-4 mr-auto">
            <p class="lead">관련 자료는 <a href="https://startbootstrap.com/template-overviews/freelancer/">여기</a>서 찾아보실 수 있습니다.</p>
          </div>
        </div>
        <div class="text-center mt-4">
          <a href="#">
            <i class="fa fa-download mr-2"></i>
            Download Now!
          </a>
        </div>
      </div>
    </section>

    <!-- Contact Section -->
    <section  class="bg-primary text-white mb-0" id="contact">
      <div class="container">
        <h2 class="text-center text-uppercase text-white">Contact Me</h2>
        <hr class="star-dark mb-5">
        <div class="row">
          <div class="col-lg-8 mx-auto">
            <!-- To configure the contact form email address, go to mail/contact_me.php and update the email address in the PHP file on line 19. -->
            <!-- The form should work on most web servers, but if the form is not working you may need to configure your web server differently. -->
            <form name="sentMessage" id="contactForm" novalidate="novalidate">
              <div class="control-group">
                <div class="form-group floating-label-form-group controls mb-0 pb-2">
                  <label>Name</label>
                  <input class="form-control" id="name" type="text" placeholder="Name" required="required" data-validation-required-message="Please enter your name.">
                  <p class="help-block text-danger"></p>
                </div>
              </div>
              <div class="control-group">
                <div class="form-group floating-label-form-group controls mb-0 pb-2">
                  <label>Email Address</label>
                  <input class="form-control" id="email" type="email" placeholder="Email Address" required="required" data-validation-required-message="Please enter your email address.">
                  <p class="help-block text-danger"></p>
                </div>
              </div>
              <div class="control-group">
                <div class="form-group floating-label-form-group controls mb-0 pb-2">
                  <label>Phone Number</label>
                  <input class="form-control" id="phone" type="tel" placeholder="Phone Number" required="required" data-validation-required-message="Please enter your phone number.">
                  <p class="help-block text-danger"></p>
                </div>
              </div>
              <div class="control-group">
                <div class="form-group floating-label-form-group controls mb-0 pb-2">
                  <label>Message</label>
                  <textarea class="form-control" id="message" rows="5" placeholder="Message" required="required" data-validation-required-message="Please enter a message."></textarea>
                  <p class="help-block text-danger"></p>
                </div>
              </div>
              <br>
              <div id="success"></div>
              <div class="form-group">
                <button type="submit" class="btn btn-primary btn-xl" id="sendMessageButton">Send</button>
              </div>
            </form>
          </div>
        </div>
      </div>
    </section>

    <!-- Footer -->
    <footer class="footer text-center">
      <div class="container">
        <div class="row">
          <div class="col-md-4 mb-5 mb-lg-0">
            <h4 class="text-uppercase mb-4">Location</h4>
            <p class="lead mb-0">2215 John Daniel Drive
              <br>Clark, MO 65243</p>
          </div>
          <div class="col-md-4 mb-5 mb-lg-0">
            <h4 class="text-uppercase mb-4">Around the Web</h4>
            <ul class="list-inline mb-0">
              <li class="list-inline-item">
                <a class="btn btn-outline-light btn-social text-center rounded-circle" href="#">
                  <i class="fa fa-fw fa-facebook"></i>
                </a>
              </li>
              <li class="list-inline-item">
                <a class="btn btn-outline-light btn-social text-center rounded-circle" href="#">
                  <i class="fa fa-fw fa-google-plus"></i>
                </a>
              </li>
              <li class="list-inline-item">
                <a class="btn btn-outline-light btn-social text-center rounded-circle" href="#">
                  <i class="fa fa-fw fa-twitter"></i>
                </a>
              </li>
              <li class="list-inline-item">
                <a class="btn btn-outline-light btn-social text-center rounded-circle" href="#">
                  <i class="fa fa-fw fa-linkedin"></i>
                </a>
              </li>
              <li class="list-inline-item">
                <a class="btn btn-outline-light btn-social text-center rounded-circle" href="#">
                  <i class="fa fa-fw fa-dribbble"></i>
                </a>
              </li>
            </ul>
          </div>
          <div class="col-md-4">
            <h4 class="text-uppercase mb-4">About Freelancer</h4>
            <p class="lead mb-0">Freelance is a free to use, open source Bootstrap theme created by
              <a href="http://startbootstrap.com">Start Bootstrap</a>.</p>
          </div>
        </div>
      </div>
    </footer>

    <div class="copyright py-4 text-center text-white">
      <div class="container">
        <small>Copyright &copy; Your Website 2018</small>
      </div>
    </div>

    <!-- Scroll to Top Button (Only visible on small and extra-small screen sizes) -->
    <div class="scroll-to-top d-lg-none position-fixed ">
      <a class="js-scroll-trigger d-block text-center text-white rounded" href="#page-top">
        <i class="fa fa-chevron-up"></i>
      </a>
    </div>

    <!-- Portfolio Modals -->

    <!-- Portfolio Modal 1 -->
    <div class="portfolio-modal mfp-hide" id="portfolio-modal-1">
      <div class="portfolio-modal-dialog bg-white">
        <a class="close-button d-none d-md-block portfolio-modal-dismiss" href="#">
          <i class="fa fa-3x fa-times"></i>
        </a>
        <div class="container text-center">
          <div class="row">
           <div class="chat_window">
			<div class="top_menu">
				<div class="buttons">
					<div class="button close"></div>
					<div class="button minimize"></div>
					<div class="button maximize"></div>
				</div>
				<div class="title">Chat</div>
			</div>
				<ul class="messages"></ul>
				<div class="bottom_wrapper clearfix">
					<div class="message_input_wrapper">
						<input class="message_input" placeholder="Type your message here..." />
					</div>
					<div class="send_message">
						<div class="icon">
						</div>
						<div class="text">
						Send
						</div>
					</div>
				</div>
			</div>
			<div class="message_template">
				<li class="message">
					<img src="<c:url value="/resources/img/oecd.jpg" />" width="100" height="100" class="avatar">
					<div class="text_wrapper">
						<div class="text">
						</div>
					</div>
				</li>
			</div>
          </div>
          <a class="btn btn-primary btn-lg rounded-pill portfolio-modal-dismiss" href="#">
                <i class="fa fa-close"></i>
                돌아가기</a>
        </div>
        
      </div>
    </div>
    <!-- Bootstrap core JavaScript -->
    <script src="<c:url value="/resources/vendor/jquery/jquery.min.js" />"></script>
    <script src="<c:url value="/resources/vendor/bootstrap/js/bootstrap.bundle.min.js" />"></script>

    <!-- Plugin JavaScript -->
    <script src="<c:url value="/resources/vendor/jquery-easing/jquery.easing.min.js" />" ></script>
    <script src="<c:url value="/resources/vendor/magnific-popup/jquery.magnific-popup.min.js" />"></script>

    <!-- Contact Form JavaScript -->
    <script src="<c:url value="/resources/js/jqBootstrapValidation.js" /> "></script>
    <script src="<c:url value="/resources/js/contact_me.js" />" ></script>

    <!-- Custom scripts for this template -->
    <script src="<c:url value="/resources/js/freelancer.min.js" />" ></script>

</body>
</html>