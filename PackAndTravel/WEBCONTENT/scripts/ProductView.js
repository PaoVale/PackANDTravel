
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