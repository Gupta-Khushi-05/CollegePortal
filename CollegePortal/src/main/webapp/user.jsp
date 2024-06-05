<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />

    <link rel="shortcut icon" href="favicon/01.png" type="image/x-icon" />
    <title>LogIn Form &dash; Bharat Institue of Technology</title>

    <link rel="stylesheet" href="css/styles.css" />
  </head>
<body style="background-image: linear-gradient(
        to left,
        rgba(43, 36, 36, 0.47),
        rgba(19, 18, 18, 0.58)
      ),
      url('images/01.jpeg');
      background-size: cover;
      width: 100vw;
      height: 100vh;
      position: relative;">
  
  
  <input type="hidden" id="status"
		value="<%= request.getAttribute("status") %>" />
   
   
   
    <section class="sec">
     <a  href="admin.jsp"><ion-icon class="user" name="person-circle-outline"></ion-icon></a> 
     
      <div class="head"><h1>LogIn</h1></div>
      <div class="login-form">
        <form method="post" action="userLogin">
          <div class="input-box">
            <div class="box">
              <ion-icon name="person-outline"></ion-icon>
              <input
                type="text"
                name="uName"
                placeholder="Student Name"
                required
              />
            </div>

            <div class="box">
              <ion-icon name="lock-closed-outline"></ion-icon>
              <input
                type="password"
                name="uPass"
                placeholder="Student Password"
                required
              />
            </div>
            <div class="box1">
              <input type="checkbox" />
              <blockquote>Remember me.</blockquote>
            </div>
          </div>
          <button class="btn">LOGIN</button>
        </form>
      </div>
    </section>

    <img src="images/a.png" alt="logo" class="img" />

    <div class="links">
      <a href="https://www.instagram.com/bit__college__meerut/?hl=en" target="_blank"><ion-icon class="logo" name="logo-instagram"></ion-icon></a>
      <a href="https://www.linkedin.com/school/bitmeerutofficial/?originalSubdomain=in" target="_blank"><ion-icon class="logo" name="logo-linkedin"></ion-icon></a>
      <a href="https://bitmeerut.edu.in" target="_blank"
        ><ion-icon class="logo" name="logo-google"></ion-icon
      ></a>
      <a href="tel:7055100534"><ion-icon class="logo" name="call-outline"></ion-icon></a>
    </div>

    <script
      type="module"
      src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.esm.js"
    ></script>
    <script
      nomodule
      src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.js"
    ></script>
    
    
    <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>



	<script type="text/javascript">
		var status = document.getElementById("status").value;
		if (status == "success") {
			swal("Congrats", "LogIn Successfully", "success");
		} else if (status == "failed") {
			swal("Sorry", "Wrong Credentials ", "error");
		}
	</script>
    
  </body>
</html>
