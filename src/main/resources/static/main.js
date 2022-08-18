window.addEventListener('load', () => {


const memberName = document.querySelector("#name");
const memberEmail = document.querySelector("#email");
const memberLocation = document.querySelector("#location");
const readMember = document.querySelector(".submit-member");

readMember.addEventListener('click', () => {
  
   const member = memberName.value;
   const email = memberEmail.value;
   const location = memberLocation.value;

    if(!member || !email || !location) {
        alert("Please fill in all sections")
    } else {

    const data = 
    {
        "memberName": member,
        "memberEmail": email,
        "memberLocation": location

    }

    fetch("http://localhost:8081/home/addMember", {
        method: "POST",
        headers: {
            "Content-type": "application/json"
        },
        body: JSON.stringify(data),
    })
        .then(res => res.json())
        .then(model => console.log(model))
        .catch(err => console.err(err))

        window.location.href = "./active.html";  

}


       
})
    
        

})

