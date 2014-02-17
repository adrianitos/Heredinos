<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en" class="no-js one-page-layout" data-classic-layout="false" data-mobile-only-classic-layout="true" data-inanimation="fadeInUp" data-outanimation="fadeOutDownBig"><!-- InstanceBegin template="/Templates/layout.dwt" codeOutsideHTMLIsLocked="false" -->

	<head>
    
		<meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1" />
        <meta name="description" content="cvCard - Responsive HTML5 vCard Template" />
        <meta name="keywords" content="vcard, html5, portfolio" />
        <meta name="author" content="Pixelwars" />

        <title>cvCard</title>

        <!-- FAV and TOUCH ICONS -->
        <link rel="shortcut icon" href="./images/ico/favicon.ico" />
        <link rel="apple-touch-icon" href="./images/ico/apple-touch-icon.png" />
		
		<script src="./js/modernizr.custom.js"></script>
         
        <!-- FONTS -->
        <link href='../../fonts.googleapis.com/css_8e1dc5f6.css' rel='stylesheet' type='text/css' />
        <link href='../../fonts.googleapis.com/css_d7b56e77.css' rel='stylesheet' type='text/css' />
        <link href='../../fonts.googleapis.com/css_adb7fa49.css' rel='stylesheet' type='text/css' />
            
        <!-- STYLES -->
        <link rel="stylesheet" type="text/css" media="print" href="./css/print.css" />
        <link rel="stylesheet" type="text/css" href="./css/normalize.css" />
        <link rel="stylesheet" type="text/css" href="./css/bootstrap.min.css" />
        <link rel="stylesheet" type="text/css" href="./js/nprogress/nprogress.css" />
        <link rel="stylesheet" type="text/css" href="./css/animate.css" />
        <link rel="stylesheet" type="text/css" href="./css/fonts/font-awesome/css/font-awesome.min.css" />
        <link rel="stylesheet" type="text/css" href="./css/fonts/fontello/css/fontello.css" />
        <link rel="stylesheet" type="text/css" href="./css/jquery.fancybox-1.3.4.css" />
        <link rel="stylesheet" type="text/css" href="./js/google-code-prettify/prettify.css" />
        <link rel="stylesheet" type="text/css" href="./css/uniform.default.css" />
        <link rel="stylesheet" type="text/css" href="./css/flexslider.css" />
        <link rel="stylesheet" type="text/css" href="./js/mediaelement/mediaelementplayer.css" />
        <link rel="stylesheet" type="text/css" href="./css/tooltipster.css" />
        <link rel="stylesheet" type="text/css" href="./css/style.css" />
        <link rel="stylesheet" type="text/css" href="./css/main.css" />
        
        <!--[if lte IE 9]>
            <script src="./js/html5shiv.js"></script>
            <script src="./js/respond.min.js"></script>
            <script src="./js/selectivizr-min.js"></script>
        <![endif]--> 
        
        <link rel="stylesheet" type="text/css" href="./style-switcher/style.css" />
        <link rel="stylesheet" class="base-skin" type="text/css" href="#" />
        
        
		<!-- InstanceBeginEditable name="head" -->
        <!-- InstanceEndEditable -->
        
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

	</head>
    
    
    
	<body>
   
   	<%@ page import="project.dao.*" %>
	<%@ page import="project.vo.*" %>
	<%@ page import="java.io.*,java.util.*,java.sql.*"%>
	<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

	<% 
		PersonaVO p = new PersonaVO();
	try{	
	if (request.getParameter("nomUser") !=null){
			String nomUser=request.getParameter("nomUser").trim();
			String password=request.getParameter("password").trim();
			UserDao miUser = new UserDao();
			PersonaDao miPersona = new PersonaDao();
			if(miUser.loginUsuari(nomUser,password)){
				//Entrar
				System.out.println("Correcte!");
				p = miPersona.buscarPersona(nomUser);
				System.out.println(p.getNomUser());
			}else{
				//Pag login + missatge usuari o pass incorrecte
				System.out.println("Incorrecte!");	
				response.sendRedirect("http://localhost:8080/Heredin/LOGIN/login.html");
				}
		}else{
			response.sendRedirect("http://localhost:8080/Heredin/LOGIN/login.html");
		}}catch(Exception e){
			e.getMessage();
		}
		%>
        
        
        <!-- CONTAINER -->
		<div class="container" id="container">
			
            
            
            <!-- HEADER -->
            <header class="header">
            
                <img src="./images/site/avatar.png" alt="avatar" />
			
                <p>Pagina personal, consulte sus datos y sus carteras actuales</p>
				
                <!-- NAV MENU -->
                <ul class="vs-nav">
                    
                    <!-- InstanceBeginEditable name="Menu-Content" -->
                    
                    <li><a href="#/resume">Wallets (carteras) y ultimos movimientos</a></li>
                    <li><a href="#/contact">Datos personales del usuario y información</a></li>
                
                    
                    <!-- InstanceEndEditable -->
                	
                </ul>
                <!-- NAV MENU -->
                
                <!-- SEARCH --> 
    
                <!-- SEARCH -->
                
			</header>
            <!-- HEADER -->
            
            
            
            
            
            <!-- WRAPPER -->
			<div class="wrapper">
            
            
            
				<!-- InstanceBeginEditable name="Page-Content" -->
                
                
				<!-- PAGE : ABOUT -->

                <!-- PAGE : ABOUT -->
                
                
                
                
                <!-- PAGE : PORTFOLIO -->

                <!-- PAGE : PORTFOLIO -->
                
                
                
                
                <!-- PAGE : CONTACT -->
				<section id="contact" class="page">
					<div class="content">
                        	
                           

                        <!-- row -->
                        <div class="row">
                            
                            
                            <!-- column 6/12 -->
                            <div class="col-md-12">
                                             
                                <h2 class="section-title"><span><i class="icon-address-book"></i>DATOS DEL USUARIO</span></h2>
                                
                                <!-- LETTER -->
                                <div class="letter">
                                    
                                    <h4 class="letter-title"><%= p.getNomComplert() %></h4>
                                    
                                    <div class="stamp">
                                      <img src="./images/site/stamp-image.png" alt="stamp" />
                                    </div>
                                  
                                    <div class="letter-info">
                                        <p><i class="icon-at"></i><%= p.getEmail() %></p>
                                        <p><i class="icon-phone"></i><%= p.getNumTelf() %></p>
                                        <p><i class="icon-location"></i><%= p.getAdresa() %></p>
                                    </div>
                                    
                                  </div>    
                                  <!-- LETTER -->
                               
                            
                              
                                  
                                <!-- GOOGLE MAP -->
                                  
                          </div>
                          <!-- column 6/12 --><!-- column 6/12 -->
                            
                            
                            
                        </div>    				
                        <!-- row -->      
                                          
                                              
                                          
                    </div>
				</section>
                <!-- PAGE : CONTACT -->
                
                
                
                
                <!-- PAGE : BLOG -->
                <!-- PAGE : BLOG -->
                
                
                
                
                <!-- PAGE : RESUME -->
				<section id="resume" class="page">
					<div class="content">
						<!-- CONTENT -->
                                       
                                        
                     	<!-- row -->
                        <div class="row">
                        
                        	
                            <!-- col 6/12 -->
                            <div class="col-md-6">
                                          
                                <!-- timeline -->
                                <div class="timeline">
                                
                                    <h2><i class="fa fa-flask"></i>ULTIMOS MOVIMIENTOS</h2>
                                    
                                    <div class="event current">
                                        <span class="date">22:43h</span>
                                        <h4> + 12.000 HEREDINES</h4>
                                        <h5>Transferencia a su favor</h5>
                                    </div>
                                    
                                    
                                    <div class="event">
                                        <span class="date">21:22h</span>
                                        <h4> - 2.000 HEREDINES</h4>
                                        <h5>Retirada de dinero</h5>
                                    </div>

                                    <div class="event">
                                        <span class="date">19:20h</span>
                                        <h4> - 6.000 HEREDINES</h4>
                                        <h5>Retirada de dinero</h5>
                                    </div>

                                    <div class="event">
                                        <span class="date">16:52h</span>
                                        <h4> - 9.000 HEREDINES</h4>
                                        <h5>Retirada de dinero</h5>
                                    </div>
                                    
                                   
                               
                               </div>
                               <!-- timeline -->
                               
                               
                               <!-- timeline -->
                             
                               
                              
                              </div> 
                              <!-- col 6/12 -->
                               
                               
                               
                               <!-- col 6/12 -->
                               <div class="col-md-6">
                                
                                <sql:setDataSource var="snapshot" driver="com.mysql.jdbc.Driver" url="jdbc:mysql://192.254.225.120:3306/kriptsof_heredin" user="kriptsof_admin1"  password="admin"/>
								<sql:query dataSource="${snapshot}" var="result">
									SELECT SUM(saldo) as total FROM cartera,cartera_persona,persona WHERE persona.nomUser='<%= p.getNomUser() %>' AND persona.id=cartera_persona.id_persona AND cartera.id=cartera_persona.id_cartera;
								</sql:query>
                                <h1>TOTAL:  <span><c:out value="${result.rows[0].total}"/><i>  Heredines</i></span></h1>
                                    <h2><span><i class="icon-cog-1"></i>CARTERAS</span></h2>
                                
                                    <!-- DEV SKILLS -->
                                    <div class="skillset">
                                    <h2 class="section-title"><span><i class="icon-cog-1"></i>Cartera principal</span></h2>
                                        <!-- .skill-unit -->
                                        <div class="skill-unit">
                                            <h4>132.620 H</h4>
                                            <div class="bar" data-percent="100">
                                                <div class="progress"></div>
                                            </div>
                                        </div>
                                        <!-- .skill-unit -->
                                         <h2 class="section-title"><span><i class="icon-cog-1"></i>Cartera número 2</span></h2>
                                        
                                        <!-- .skill-unit -->
                                        <div class="skill-unit">
                                            <h4>42.360 H</h4>
                                            <div class="bar" data-percent="50">
                                                <div class="progress"></div>
                                            </div>
                                        </div>
                                        <!-- .skill-unit -->

                                        <h2 class="section-title"><span><i class="icon-cog-1"></i>Cartera número 3</span></h2>
                                        
                                        <!-- .skill-unit -->
                                        <div class="skill-unit">
                                            <h4>72.320 H</h4>
                                            <div class="bar" data-percent="70">
                                                <div class="progress"></div>
                                            </div>
                                        </div>
                                        <!-- .skill-unit -->

                                        <h2 class="section-title"><span><i class="icon-cog-1"></i>Cartera número 4</span></h2>
                                        
                                        <!-- .skill-unit -->
                                        <div class="skill-unit">
                                            <h4>12.320 H</h4>
                                            <div class="bar" data-percent="20">
                                                <div class="progress"></div>
                                            </div>
                                        </div>
                                        <!-- .skill-unit -->
                                    
                                    </div>
                                    <!-- DEV SKILLS -->
                                    

                                    <!-- DESIGN SKILLS -->
                                    
                                    
                                    
                                
                                    <!-- DOWNLOAD BUTTON -->
                                    
                                
                               </div>
                               <!-- col 6/12 -->
                        
                        
                        </div>                       
                        <!-- row -->                   
                                            
                                           
                                            
                                		
                    </div>
                    <!-- CONTENT -->
					
				</section>
                <!-- PAGE : RESUME -->
                
                
                
            
            	<!-- InstanceEndEditable -->
            
            
                
			</div>
            <!-- WRAPPER -->
            
            
		</div>
        <!-- CONTAINER -->
        
        
        
        
        
        <!-- InstanceBeginEditable name="Body-End-Content" -->
        
        
        <!-- PORTFOLIO SINGLE AJAX CONTENT CONTAINER -->
        <div class="p-overlay"></div>
        <div class="p-overlay"></div>
        

        <!-- ALERT : used for contact form mail delivery alert -->
        <div class="site-alert animated"></div>
        
        
        <!-- InstanceEndEditable -->
        
        
		
        
        <!-- SCRIPTS -->
        <script src="./js/jquery-1.10.2.min.js"></script>
		<script src="./js/jquery-migrate-1.2.1.min.js"></script>
        <script src="./js/jquery.address-1.5.min.js"></script>
        <script src="./js/triple.layout.js"></script>
        <script src="./js/smoothscroll.js"></script>
        <script src="./js/nprogress/nprogress.js"></script>
        <script src="./js/fastclick.js"></script>
		<script src="./js/jquery.imagesloaded.min.js"></script>
        <script src="./js/jquery.isotope.min.js"></script>
        <script src="./js/jquery.flexslider-min.js"></script>
        <script src="./js/jquery.fitvids.js"></script>
        <script src="./js/jquery.validate.min.js"></script>
        <script src="./js/jquery.uniform.min.js"></script>
        <script src="./js/jquery.fancybox-1.3.4.pack.js"></script>
        <script src="./js/jquery.tooltipster.min.js"></script>
        <script src="./js/google-code-prettify/prettify.js"></script>
        <script src="./js/twitterFetcher_v10_min.js"></script>
        <script src="./js/mediaelement/mediaelement-and-player.min.js"></script>
        <script src="./js/send-mail.js"></script>
        <script src="./js/classie.js"></script>
        <script src="../../maps.googleapis.com/maps/api/js_3c9fd14e.js"></script>
        <script src="./js/main.js"></script>
        
        
        
        <!--************************** STYLE SWITCHER -->

        <!--************************** STYLE SWITCHER -->
        
		
        
	</body>
<!-- InstanceEnd --></html>