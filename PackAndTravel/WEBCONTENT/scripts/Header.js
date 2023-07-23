function toggleDropdown() {
    let dropdownMenu = document.getElementById("dropdownMenu");
    dropdownMenu.classList.toggle("show");
  }

  window.onclick = function(event) {
    if (!event.target.matches('.fa-cog')) {
      let dropdowns = document.getElementsByClassName("dropdown-content");
      let i;
      for (i = 0; i < dropdowns.length; i++) {
        let openDropdown = dropdowns[i];
        if (openDropdown.classList.contains('show')) {
          openDropdown.classList.remove('show');
        }
      }
    }
  }
  
  function toggle(){
		if(document.getElementById("navStyle").style.display=="none"){
			document.getElementById("navStyle").style.display="block";
		}else{
			document.getElementById("navStyle").style.display="none";
		}
	}