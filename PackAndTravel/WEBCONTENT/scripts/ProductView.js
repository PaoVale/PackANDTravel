
  function toggleContent(buttonId, contentId) {
      let button = document.getElementById(buttonId);
      let content = document.getElementById(contentId);
      if (content.classList.contains("hidden")) {
        content.classList.remove("hidden");
        button.textContent = "-";
      } else {
        content.classList.add("hidden");
        button.textContent = "+";
      }
    }