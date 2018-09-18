<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html> 
<head>

<jsp:useBean id="date" class="java.util.Date" />

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<title>Index Page</title>
<link rel="shortcut icon" type="image/png" href="resources/images/eliteadmin-logo-dark.png"/>
<!-- Bootstrap Core CSS -->
<link href="resources/bootstrap/dist/css/bootstrap.min.css"	rel="stylesheet">
<link href="resources/bower_components/bootstrap-extension/css/bootstrap-extension.css"	rel="stylesheet">
<!-- Menu CSS -->
<link href="resources/bower_components/sidebar-nav/dist/sidebar-nav.min.css" rel="stylesheet">
<!-- toast CSS -->
<link href="resources/bower_components/toast-master/css/jquery.toast.css" rel="stylesheet">
<!-- morris CSS -->
<link href="resources/bower_components/morrisjs/morris.css" rel="stylesheet">
<!-- animation CSS -->
<link href="resources/css/animate.css" rel="stylesheet">
<!-- Custom CSS -->
<link href="resources/css/style.css" rel="stylesheet">
<!-- color CSS -->
<link href="resources/css/colors/default-dark.css" id="theme" rel="stylesheet">
<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
	    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
	    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
	<![endif]-->
	
	
<!-- jQuery -->
    <script src="resources/bower_components/jquery/dist/jquery.min.js"></script>
    <!-- Bootstrap Core JavaScript -->
    <script src="resources/bootstrap/dist/js/tether.min.js"></script>
    <script src="resources/bootstrap/dist/js/bootstrap.min.js"></script>
    <script src="resources/bower_components/bootstrap-extension/js/bootstrap-extension.min.js"></script>
    <!-- Menu Plugin JavaScript -->
    <script src="resources/bower_components/sidebar-nav/dist/sidebar-nav.min.js"></script>
    <!--slimscroll JavaScript -->
    <script src="resources/js/jquery.slimscroll.js"></script>
    <!--Wave Effects -->
    <script src="resources/js/waves.js"></script>
    <!--Counter js -->
    <script src="resources/bower_components/waypoints/lib/jquery.waypoints.js"></script>
    <script src="resources/bower_components/counterup/jquery.counterup.min.js"></script>
    <!--Morris JavaScript -->
    <script src="resources/bower_components/raphael/raphael-min.js"></script>
    <script src="resources/bower_components/morrisjs/morris.js"></script>
    <!-- Custom Theme JavaScript -->
    <script src="resources/js/custom.min.js"></script>
    <!-- <script src="resources/js/dashboard1.js"></script> -->
    <!-- Sparkline chart JavaScript -->
    <script src="resources/bower_components/jquery-sparkline/jquery.sparkline.min.js"></script>
    <script src="resources/bower_components/jquery-sparkline/jquery.charts-sparkline.js"></script>
    <script src="resources/bower_components/toast-master/js/jquery.toast.js"></script>
    <!-- <script type="text/javascript">
    $(document).ready(function() {
        $.toast({
            heading: 'Welcome to Elite admin',
            text: 'Use the predefined ones, or specify a custom position object.',
            position: 'top-right',
            loaderBg: '#ff6849',
            icon: 'info',
            hideAfter: 3500,
            stack: 6
        })
    });
    </script> display:none -->
    <script type="text/javascript">
    $(document).ready(function () {

        $('#test').on('click', function () {
        	$("#logoBL").toggleClass("logo_BL");
        });

    });
    </script>
    <!--Style Switcher -->
    <script src="resources/bower_components/styleswitcher/jQuery.style.switcher.js"></script>
	
    <!-- Angular Stuff -->
    <script type="text/javascript" src="resources/js/angular.js"></script>
    <link href="resources/css/ng-table.min.css" rel="stylesheet" type="text/css"/>
	<script type="text/javascript" src="resources/js/angular_dependency/ng-table.min.js"></script>
	<script type="text/javascript" src="resources/js/angular_dependency/angular-sanitize.min.js"></script>
	<script type="text/javascript" src="resources/js/angular_dependency/ng-csv.js"></script>
	<script data-require="lodash.js@*" data-semver="3.5.0" src="https://cdnjs.cloudflare.com/ajax/libs/lodash.js/3.5.0/lodash.js"></script>
	<script type="text/javascript" src="resources/js/angular_dependency/angularjs-dropdown-multiselect.js"></script>
	<script type="text/javascript" src="resources/js/app.js/app.js"></script>
    
    
    <style>
    	.logo_BL{
    		display: none;
    	}
    	.disable_text_Color{
    		color: white;
    	}
    </style>
</head>
<body ng-app="myApp">
<!-- Preloader -->
    <div class="preloader">
        <div class="cssload-speeding-wheel"></div>
    </div>
    <div id="wrapper">
        <!-- Navigation -->
        <nav class="navbar navbar-default navbar-static-top m-b-0">
            <div class="navbar-header"> <!-- <img alt="banner" width="800" height="60" src="resources/images/bl-banner.png"/> -->
                <div class="top-left-part">
                	<a class="logo" href="index">
                		<b><!--This is dark logo icon-->
                			<img id="logoBL" style="padding-left: 75%;" src="resources/images/eliteadmin-logo-dark.png" alt="home" class="dark-logo" />
                			<!--This is light logo icon-->
                			<!-- <img src="resources/images/eliteadmin-logo-dark.png" alt="home" class="light-logo" /> -->
                		</b>
                		<span class="hidden-xs"><!--This is dark logo text-->
                			<!-- <img src="resources/images/eliteadmin-text.png" alt="home" class="dark-logo" /> -->
                			<!--This is light logo text-->
                			<!-- <img src="resources/images/eliteadmin-text-dark.png" alt="home" class="light-logo" /> -->
                		</span>
                	</a>
                </div>
                
                <!-- For Search -->
                
                <ul id="test" class="nav navbar-top-links navbar-left hidden-xs">
                    <li style="padding-top: 10%; margin-bottom: -10%;">
                    	<a href="javascript:void(0)" class="open-close hidden-xs waves-effect waves-light">
                    		<i class="icon-arrow-left-circle ti-menu"></i>
                    	</a>
                    </li>
                </ul>
                
                <!-- For Top Left Menu -->
                
                <ul class="nav navbar-top-links navbar-right pull-right">
                    <li class="dropdown""> <a class="dropdown-toggle waves-effect waves-light" data-toggle="dropdown" href="#"><i class=""><%= session.getAttribute("userName") %></i>
          <!-- <div class="notify"><span class="heartbit"></span><span class="point"></span></div> -->
          </a>
                        <ul class="dropdown-menu animated flipInY">
                            <li>
                                <a href="logout">
                                    <div>
                                        <p> <i class="fa fa-power-off"></i> <span class="text-muted">LOGOUT</span> </p>
                                        
                                    </div>
                                </a>
                            </li>
                </ul>
            </div>
        </nav>
        <!-- Left navbar-header -->
        <div class="navbar-default sidebar" role="navigation">
            <div class="sidebar-nav navbar-collapse slimscrollsidebar">
                <ul class="nav" id="side-menu" style="margin-top: 10%;">
                    <li class="sidebar-search hidden-sm hidden-md hidden-lg">
                        <!-- input-group -->
                        <div class="input-group custom-search-form">
                            <input type="text" class="form-control" placeholder="Search..."> <span class="input-group-btn">
            <button class="btn btn-default" type="button"> <i class="fa fa-search"></i> </button>
            </span> </div>
                        <!-- /input-group -->
                    </li>
                    <li class="nav-small-cap m-t-10">--- Main Menu</li>
                    <li> <a href="index" class="waves-effect">
                    		<i class="linea-icon linea-basic fa-fw" data-icon="v"></i> 
                    			<span class="hide-menu"> Pending Request 
                    				<!-- <span class="fa arrow"></span> 
                    				<span class="label label-rouded label-custom pull-right">4</span> -->
                    			</span>
                    	</a>
                        <!-- <ul class="nav nav-second-level">
                            <li> <a href="user">User</a> </li>
                            <li> <a href="index2.html">Demographical</a> </li>
                            <li> <a href="index3.html">Analitical</a> </li>
                            <li> <a href="index4.html">Simpler</a> </li>
                            <li> <a href="index4.html">Simpler</a> </li>
                        </ul> -->
                    </li>
                    <li> <a href="pendingVerifications" class="waves-effect">
                    		<i class="linea-icon linea-basic fa-fw text-danger" data-icon="7"></i> 
                    		<span class="hide-menu text-danger"> Verify Pending
                    			
                    		</span>
                    	</a>
                    </li>
                    <li><a href="updateRequest" class="waves-effect">
                    		<i data-icon=")" class="linea-icon linea-basic fa-fw"></i> 
	                    		<span class="hide-menu">Update Request 
	                    		</span>
                    	</a>
                        <!-- <ul class="nav nav-second-level">
                            <li><a href="chat.html">Chat-message</a></li>
                            <li><a href="javascript:void(0)" class="waves-effect">Inbox<span class="fa arrow"></span></a>
                                <ul class="nav nav-third-level">
                                    <li> <a href="inbox.html">Mail box</a></li>
                                    <li> <a href="inbox-detail.html">Inbox detail</a></li>
                                    <li> <a href="compose.html">Compose mail</a></li>
                                </ul>
                            </li>
                            <li><a href="javascript:void(0)" class="waves-effect">Contacts<span class="fa arrow"></span></a>
                                <ul class="nav nav-third-level">
                                    <li> <a href="contact.html">Contact1</a></li>
                                    <li> <a href="contact2.html">Contact2</a></li>
                                    <li> <a href="contact-detail.html">Contact Detail</a></li>
                                </ul>
                            </li>
                        </ul> -->
                    </li>
                    <li> <a href="uploadPOD" class="waves-effect"><i data-icon="/" class="linea-icon linea-basic fa-fw"></i> 
                    	<span class="hide-menu">Upload POD </span></a>
                    </li>
                    <li> <a href="ibRequest" class="waves-effect"><i data-icon="&#xe00b;" class="linea-icon linea-basic fa-fw"></i> 
                    	<span class="hide-menu">IB Request</span>
                    	</span></a>
                    </li>
                    <!-- <li class="nav-small-cap">--- Proffessional</li> -->
                    <!-- <li> <a href="#" class="waves-effect"><i data-icon="&#xe008;" class="linea-icon linea-basic fa-fw"></i> <span class="hide-menu">Sample Pages<span class="fa arrow"></span><span class="label label-rouded label-purple pull-right">30</span></span></a>
                        <ul class="nav nav-second-level">
                            <li><a href="starter-page.html">Starter Page</a></li>
                            <li><a href="blank.html">Blank Page</a></li>
                            <li><a href="javascript:void(0)" class="waves-effect">Email Templates<span class="fa arrow"></span></a>
                                <ul class="nav nav-third-level">
                                    <li> <a href="../email-templates/basic.html">Basic</a></li>
                                    <li> <a href="../email-templates/alert.html">Alert</a></li>
                                    <li> <a href="../email-templates/billing.html">Billing</a></li>
                                    <li> <a href="../email-templates/password-reset.html">Reset Pwd</a></li>
                                </ul>
                            </li>
                            <li><a href="lightbox.html">Lightbox Popup</a></li>
                            <li><a href="treeview.html">Treeview</a></li>
                            <li><a href="search-result.html">Search Result</a></li>
                            <li><a href="utility-classes.html">Utility Classes</a></li>
                            <li><a href="custom-scroll.html">Custom Scrolls</a></li>
                            <li><a href="login.html">Login Page</a></li>
                            <li><a href="login2.html">Login v2</a></li>
                            <li><a href="animation.html">Animations</a></li>
                            <li><a href="profile.html">Profile</a></li>
                            <li><a href="invoice.html">Invoice</a></li>
                            <li><a href="faq.html">FAQ</a></li>
                            <li><a href="gallery.html">Gallery</a></li>
                            <li><a href="pricing.html">Pricing</a></li>
                            <li><a href="register.html">Register</a></li>
                            <li><a href="register2.html">Register v2</a></li>
                            <li><a href="register3.html">3 Step Registration</a></li>
                            <li><a href="recoverpw.html">Recover Password</a></li>
                            <li><a href="lock-screen.html">Lock Screen</a></li>
                            <li><a href="400.html">Error 400</a></li>
                            <li><a href="403.html">Error 403</a></li>
                            <li><a href="404.html">Error 404</a></li>
                            <li><a href="500.html">Error 500</a></li>
                            <li><a href="503.html">Error 503</a></li>
                        </ul>
                    </li> -->
                    <!-- <li> <a href="#" class="waves-effect"><i data-icon="&#xe006;" class="linea-icon linea-basic fa-fw"></i> <span class="hide-menu">Charts<span class="fa arrow"></span></span></a>
                        <ul class="nav nav-second-level">
                            <li> <a href="flot.html">Flot Charts</a> </li>
                            <li><a href="morris-chart.html">Morris Chart</a></li>
                            <li><a href="chart-js.html">Chart-js</a></li>
                            <li><a href="peity-chart.html">Peity Charts</a></li>
                            <li><a href="knob-chart.html">Knob Charts</a></li>
                            <li><a href="sparkline-chart.html">Sparkline charts</a></li>
                            <li><a href="extra-charts.html">Extra Charts</a></li>
                        </ul>
                    </li> -->
                    <li> <a href="tables.html" class="waves-effect"><i data-icon="O" class="linea-icon linea-software fa-fw"></i> <span class="hide-menu">Reports<span class="fa arrow"></span><span class="label label-rouded label-danger pull-right">3</span></span></a>
                        <ul class="nav nav-second-level">
                            <li><a href="emailAddressReport">Email Address</a></li>
                            <li><a href="podReport">POD Report</a></li>
                            <li><a href="ibReport">IB Report</a></li>
                        </ul>
                    </li>
                    <!-- <li> <a href="widgets.html" class="waves-effect"><i data-icon="P" class="linea-icon linea-basic fa-fw"></i> <span class="hide-menu">Widgets</span></a> </li> -->
                    <!-- <li> <a href="#" class="waves-effect"><i data-icon="7" class="linea-icon linea-basic fa-fw"></i> <span class="hide-menu">Icons<span class="fa arrow"></span></span></a>
                        <ul class="nav nav-second-level">
                            <li> <a href="fontawesome.html">Font awesome</a> </li>
                            <li> <a href="themifyicon.html">Themify Icons</a> </li>
                            <li> <a href="simple-line.html">Simple line Icons</a> </li>
                            <li><a href="linea-icon.html">Linea Icons</a></li>
                            <li><a href="weather.html">Weather Icons</a></li>
                        </ul>
                    </li> -->
                    <!-- <li> <a href="map-google.html" class="waves-effect"><i data-icon="Q" class="linea-icon linea-basic fa-fw"></i><span class="hide-menu" >Google Map</span></a> </li>
                    <li> <a href="map-vector.html" class="waves-effect"><i data-icon="S" class="linea-icon linea-basic fa-fw"></i><span class="hide-menu" >Vector Map</span></a> </li>
                    <li> <a href="calendar.html" class="waves-effect"><i data-icon="A" class="linea-icon linea-elaborate fa-fw"></i> <span class="hide-menu">Calendar</span></a></li> -->
                    <!-- <li> <a href="javascript:void(0)" class="waves-effect"><i data-icon="F" class="linea-icon linea-software fa-fw"></i> <span class="hide-menu">Multi-Level Dropdown<span class="fa arrow"></span></span></a>
                        <ul class="nav nav-second-level">
                            <li> <a href="javascript:void(0)">Second Level Item</a> </li>
                            <li> <a href="javascript:void(0)">Second Level Item</a> </li>
                            <li> <a href="javascript:void(0)" class="waves-effect">Third Level <span class="fa arrow"></span></a>
                                <ul class="nav nav-third-level">
                                    <li> <a href="javascript:void(0)">Third Level Item</a> </li>
                                    <li> <a href="javascript:void(0)">Third Level Item</a> </li>
                                    <li> <a href="javascript:void(0)">Third Level Item</a> </li>
                                    <li> <a href="javascript:void(0)">Third Level Item</a> </li>
                                </ul>
                            </li>
                        </ul>
                    </li> -->
                    <!-- <li><a href="login.html" class="waves-effect"><i class="icon-logout fa-fw"></i> <span class="hide-menu">Log out</span></a></li>
                    <li class="nav-small-cap">--- Support</li>
                    <li><a href="documentation.html" class="waves-effect"><i class="fa fa-circle-o text-danger"></i> <span class="hide-menu">Documentation</span></a></li>
                    <li><a href="gallery.html" class="waves-effect"><i class="fa fa-circle-o text-info"></i> <span class="hide-menu">Gallery</span></a></li>
                    <li><a href="faq.html" class="waves-effect"><i class="fa fa-circle-o text-success"></i> <span class="hide-menu">Faqs</span></a></li> -->
                <!-- </ul> -->
            </div>
        </div>
        <!-- Left navbar-header end -->
        <!-- Page Content -->
        <div id="page-wrapper">
            <div class="container-fluid">
            <br/>
                <!-- <div class="row bg-title">
                    <div class="col-lg-3 col-md-4 col-sm-4 col-xs-12">
                        <h4 class="page-title">Dashboard 1</h4> </div>
                    <div class="col-lg-9 col-sm-8 col-md-8 col-xs-12"> <a href="#" target="_blank" class="btn btn-danger pull-right m-l-20 btn-rounded btn-outline hidden-xs hidden-sm waves-effect waves-light">Test</a>
                        <ol class="breadcrumb">
                            <li><a href="#">Dashboard</a></li>
                            <li class="active">Dashboard 1</li>
                        </ol>
                    </div>
                </div> -->
                <!-- /.row -->
                <!-- <div class="row"> -->
                    <!-- <div class="col-md-12 col-lg-12 col-sm-12"> -->
                        <!-- <div class="white-box"> -->
                            <!-- <div class="row row-in"> -->
                                <tiles:insertAttribute name="body" />
                            <!-- </div> -->
                        <!-- </div> -->
                    <!-- </div> -->
                <!-- </div> -->
                <!--row -->
                <!-- /.row -->
                <!--row -->
            <!-- /.container-fluid -->
            
        </div>
        <!-- /#page-wrapper -->
    </div>
    <!-- /#wrapper -->
    <footer class="footer text-center" style="float: left;"> <fmt:formatDate value="${date}" pattern="yyyy" /> &copy; Banglalink Digital Service </footer>
</body>
</html>