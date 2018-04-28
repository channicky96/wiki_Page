// Get the Sidebar
var sidebar = document.getElementById("sidebar");

// Get the DIV with overlay effect
var overlayBg = document.getElementById("myOverlay");

// Toggle between showing and hiding the sidebar, and add overlay effect
function openBar() {
    if (sidebar.style.display === 'block') {
        sidebar.style.display = 'none';
        overlayBg.style.display = "none";
    } else {
        sidebar.style.display = 'block';
        overlayBg.style.display = "block";
    }
}
// Close the sidebar
function closeBar() {
    sidebar.style.display = "none";
    overlayBg.style.display = "none";
}

function changeEmail(){
    var x = document.getElementById("changeEmail");
    if(x.className.indexOf("w3-show") === -1){
        x.className += " w3-show";
    }else{
        x.className = x.className.replace(" w3-show","");
    }
}

function changeNickname(){
    var x = document.getElementById("changeNickname");
    if(x.className.indexOf("w3-show") === -1){
        x.className += " w3-show";
    }else{
        x.className = x.className.replace(" w3-show","");
    }
}

function changePassword(){
    var x = document.getElementById("changePassword");
    if(x.className.indexOf("w3-show") === -1){
        x.className += " w3-show";
    }else{
        x.className = x.className.replace(" w3-show","");
    }
}

function accountChange(evt, accountc) {
  var i, x, tablinks;
  x = document.getElementsByClassName("account");
  for (i = 0; i < x.length; i++) {
      x[i].style.display = "none";
  }
  tablinks = document.getElementsByClassName("tablink");
  for (i = 0; i < x.length; i++) {
      tablinks[i].className = tablinks[i].className.replace(" w3-blue", "");
  }
  document.getElementById(accountc).style.display = "block";
  evt.currentTarget.className += " w3-blue";
}