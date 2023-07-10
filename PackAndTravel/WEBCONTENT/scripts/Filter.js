/**
 * 
 */
function toggleFilterOptions(filterId) {
            var filterOptions = document.getElementById(filterId);
            var filterExpand = document.querySelector("[data-filter-id='" + filterId + "']");
            
            if (filterOptions.style.display === "none") {
                filterOptions.style.display = "block";
                filterExpand.classList.add("expanded");
                filterExpand.textContent = "";
            } else {
                filterOptions.style.display = "none";
                filterExpand.classList.remove("expanded");
                filterExpand.textContent = "";
            }
        }