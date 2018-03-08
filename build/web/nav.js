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