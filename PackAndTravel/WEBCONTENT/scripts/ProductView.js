/**
 * 
 */
/*function toggleTable() {
  var table = document.getElementById("productTable");
  var toggleButton = document.getElementById("toggleButton");
  
  if (table.style.display === "none") {
    table.style.display = "table";
    toggleButton.textContent = "-";
  } else {
    table.style.display = "none";
    toggleButton.textContent = "+";
  }
}*/

  function toggleContent(buttonId, contentId) {
      var button = document.getElementById(buttonId);
      var content = document.getElementById(contentId);
      if (content.classList.contains("hidden")) {
        content.classList.remove("hidden");
        button.textContent = "-";
      } else {
        content.classList.add("hidden");
        button.textContent = "+";
      }
    }