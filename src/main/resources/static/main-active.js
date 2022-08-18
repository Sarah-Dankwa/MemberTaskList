window.addEventListener('load', () => {

tableElement = document.querySelector("#table");

    fetch("http://localhost:8081/home/getMembers").then((data) => {
        // console.log(data);
        return data.json();
    }).then((objectData) => {
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
    }).catch((err) => console.log(err));

})


tableElement.addEventListener('click', deleteMember);
tableElement.addEventListener('click', updateElement);

const backToForm = document.querySelector("#add-another");

backToForm.addEventListener('click', () => {
    window.location.href = "./index.html";
})




function deleteMember(e) {
    if (e.target.classList.contains("delete-member")) {

    }
    const deleteButton = e.target;
    var id = deleteButton.closest("#id").value;
    // var id = document.querySelector("id");
    // var id = parseInt(row.value);

    fetch(`http://localhost:8081/home/deleteMember/ ${id}`, {
        method: "DELETE",
        headers: {
            "Content-Type": "application/json"
        }
    })
        .then(response => console.log(response))
        .then(() => {
            console.log("Delete successful");

        })
        .catch(err => console.error(`error ${err}`));
};




function updateElement(e) {
    if (e.target.classList.contains("delete-member")) {
        return;
    }

}








    // const deleteMember = document.querySelector("#delete-member");















