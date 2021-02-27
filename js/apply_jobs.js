let elem = document.getElementById("noofexp");
let elemInput = document.getElementById('noofexp-input');
function showEmployeeInformation(event)
{
    if(event.target.value=="Yes")
    {
        elem.style.cssText = "display:contents";
        elemInput.setAttribute('required','true');
    }
    else
    {
        elem.style.cssText = "display:none";
        elemInput.removeAttribute('required')
    }
}