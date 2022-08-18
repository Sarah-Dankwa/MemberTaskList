window.addEventListener('load', () => {

    const backToForm = document.querySelector("#add-another");

    backToForm.addEventListener('click' , () => {
        window.location.href = "./index.html"; 
    })
    

    fetch("http://localhost:8081/home/getMembers").then ((data) => {
        // console.log(data);
        return data.json();
    }) .then((objectData) => {
        console.log(objectData[0].id);
        let tableData = "";
        objectData.map((values) => {
            tableData += `<tr>
            <td>${values.id}</td>
            <td>${values.memberName}</td>
            <td>${values.memberEmail}</td>
            <td>${values.memberLocation}</td>
            <td>
                <button class="edit-member"><i class="fa-solid fa-pen-to-square"></i></button>
                <button class="delete-member"><i class="fa-solid fa-trash"></i></button>
            </td>
        </tr>`;

        });
        document.getElementById("table-body").innerHTML = tableData;
    })


    const deleteMember = document.querySelector("#delete-member");

    deleteMember.addEventListener('click', (e) => {
        e.preventDefault();


    })



  

        


    })

