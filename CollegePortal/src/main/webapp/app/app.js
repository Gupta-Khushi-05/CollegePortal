"use strict";

//************** */ date and time /*****************
const now = new Date();
const opt = {
  hour: "numeric",
  minute: "numeric",
  day: "numeric",
  month: "long",
  year: "numeric",
  weekday: "long",
};
document.getElementById("day").textContent = new Intl.DateTimeFormat(
  "en-IN",
  opt
).format(now);

// ****************/ change profile /********************** */
function toggle(element) {
  element.style.display = element.style.display === "none" ? "block" : "none";
}

 function previewImage(event) {
    const preview = document.getElementById('preview-image');
    const file = event.target.files[0];
    const reader = new FileReader();

    reader.onload = function() {
      preview.src = reader.result;
    }

    if (file) {
      reader.readAsDataURL(file);
    }
  }
// *****************/ main menu btn /************ */

document.getElementById("main-menu").addEventListener("click", function () {
  console.log("hi");
  const element = document.getElementById("main-menu1");
  toggle(element);
});

// ******************/ scrool up /*******************************/

// var btn = document.getElementById("#button");

// window.addEventListener("scroll", function () {
//   if (window.scrollY > 200) {
//     btn.classList.add("show");
//   } else {
//     btn.classList.remove("show");
//   }
// });

// // btn.on("click", function (e) {
// //   e.preventDefault();
// //   $("html, body").animate({ scrollTop: 0 }, "300");
// // });

// ****************/ change profile /********************** */

// function onFileChange() {
//   var file = document.getElementById("profile-image").files[0];
//   if (!file.type.match("image.*")) {
//     alert("Please select an image file.");
//     return;
//   }
//   var fileName = file.name;
//   document.getElementById("profile-image").src = fileName;
// }

// function onSubmit() {

//   var file = document.getElementById("profile-image").files[0];
//   var xhr = new XMLHttpRequest();
//   xhr.open("POST", "profile-image.php");
//   xhr.setRequestHeader("Content-Type", "multipart/form-data");
//   xhr.send(file);
// }



