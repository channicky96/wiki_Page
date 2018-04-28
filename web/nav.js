// Get the Sidebar
var sidebar = document.getElementById("sidebar");

// Get the DIV with overlay effect
var overlayBg = document.getElementById("overlay");

// Toggle between showing and hiding the sidebar, and add overlay effect
function openBar() {
    if (sidebar.style.display === 'block') {
        sidebar.style.display = 'none';
        overlay.style.display = "none";
    } else {
        sidebar.style.display = 'block';
        overlay.style.display = "block";
    }
}
// Close the sidebar
function closeBar() {
    sidebar.style.display = "none";
    overlay.style.display = "none";
}

function accountChange(evt, accountc) {
  var i, x, tablinks;
  x = document.getElementsByClassName("account");
  for (i = 0; i < x.length; i++) {
      x[i].style.display = "none";
  }
  tablinks = document.getElementsByClassName("tablink");
  for (i = 0; i < x.length; i++) {
      tablinks[i].className = tablinks[i].className.replace(" w3-blue w3-leftbar", "");
  }
  document.getElementById(accountc).style.display = "block";
  evt.currentTarget.className += " w3-blue w3-leftbar";
}