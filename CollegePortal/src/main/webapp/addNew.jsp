<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />

    <link rel="shortcut icon" href="favicon/01.png" type="image/x-icon" />
    <title>Portal &dash; Bharat Institue of Technology</title>
    <link rel="stylesheet" href="css/scroll.css" />
    <link rel="stylesheet" href="css/styles2.css" />
    <link rel="stylesheet" href="css/profile.css" />
  </head>
  <body>
    <section class="sec">
      <header class="head">
        <a href="https://bitmeerut.edu.in" target="_blank">
          <img src="images/a.png" alt="logo" class="img"
        /></a>
        
         <!--<a class="user-link" href="profile.html"><ion-icon class="user-link" name="person-circle-outline"></ion-icon></a>-->

      </header>
      <nav class="nav-bar">
        <div class="side">
          <ion-icon class="icon" name="bookmark"></ion-icon>

          <div class="campus"> <img src="images/01.jpeg"  class="campus-img"/> </div>

          <a href="index.jsp"
            ><div class="dashboard">
              <div class="dash">
                <ion-icon name="folder-outline"></ion-icon>
                <strong>Dashboard</strong>
              </div>
            </div></a>

          <div class="side-con">
           <!--  <div class="con">
              <a class="con-link" href="profile.html"><ion-icon name="person-outline"></ion-icon> My Profile</a>
            </div>-->
             
            <div class="con">
              <a class="con-link" href="addNew.jsp"
                ><ion-icon name="add-circle-outline"></ion-icon> Add Student</a
              >
            </div>
            
            <div class="con">
              <a class="con-link" href="notice.jsp"
                ><ion-icon name="notifications-outline"></ion-icon>Notice</a
              >
            </div>
            <div class="con">
              <a class="con-link" href="sessional.jsp"
                ><ion-icon name="create-outline"></ion-icon>Sessionals
              </a>
            </div>
            <!-- <div class="con">
              <ion-icon name="hourglass-outline"></ion-icon>Attendence
            </div> -->
            <div class="con">
              <a class="con-link" href="placement.jsp"
                ><ion-icon name="ribbon-outline"></ion-icon>Placement Cell</a
              >
            </div>
            <div class="con">
              <a class="con-link" href="calender.jsp"
                ><ion-icon name="receipt-outline"></ion-icon>Academic
                Calender</a
              >
            </div>


            <div class="con">
              <a class="con-link" href="https://erp.aktu.ac.in" target="_blank"
                ><ion-icon name="log-in-outline"></ion-icon>AKTU Login</a
              >
            </div>
            <div class="con">
              <a
                class="con-link"
                href="https://erp.aktu.ac.in/webpages/oneview/oneview.aspx"
                target="_blank"
                ><ion-icon name="school-outline"></ion-icon>View Result</a
              >
            </div>
          </div>
          <div class="contact">
            <div class="contact-list">
               <a href="tel:7055100534"
                ><div class="link"><ion-icon name="call"></ion-icon></div
              ></a>
              <a href="https://twitter.com/notices_bit" target="_blank"
                ><div class="link"><ion-icon name="logo-twitter"></ion-icon></div
              ></a>
              <a href="mailto:info@bitmeerut.co.in"
                ><div class="link"><ion-icon name="mail"></ion-icon></div
              ></a>
            </div>
          </div>
        </div>
      </nav>

      <!-- ********************Start of content of the page******************* -->
      <div class="container">
        <div class="content">
          <div class="col-2 date-time">
            <div class="heading">
              <blockquote>
                <ion-icon name="folder-outline"></ion-icon
                ><strong> Dashboard /- </strong>My Profile
              </blockquote>
            </div>
            <div class="day"><h5 id="day">05 may 2023</h5></div>
          </div>
          <hr />

          <div class="col-1 activity">
            <a class="btn" href="pay.html"
              ><div class="fees">Pay Online</div></a
            >
            <a class="btn" href="notice.jsp"
              ><div class="notice">Notice</div></a
            >
            <a class="btn" href="placement.jsp"
              ><div class="placement">Placement</div></a
            >
          </div>
          <hr />

          <!-- *****************Main-Content of the page********************************* -->

          <div class="con-profile">
            <h2 class="profile-head">Add Student</h2>
             <form method="post" action="addStudent" enctype="multipart/form-data">

    <input type="file" name="profile-image" id="profile-image" style="display: none" onchange="previewImage(event)" />

    <input type="text" name="name" placeholder="NAME" required />

    <input type="email" name="email" placeholder="EMAIL" required />

    <input type="password" name="pass" placeholder="PASSWORD" required />

    

    <div class="profile-btn">
      <button class="sub-btn">Save and Submit</button>
     
    </div>
  </form>
          </div>

          <!-- *****************End of main-content*********************** -->
        </div>
      </div>

      <!-- *******************End of content*****************************  -->
    </section>

    <script
      type="module"
      src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.esm.js"
    ></script>
    <script
      nomodule
      src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.js"
    ></script>

    <script src="app/app.js"></script>
    
  </body>
</html>
