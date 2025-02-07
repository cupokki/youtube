
document.getElementById("checkBtn").addEventListener('click', function() {
    let memberId = document.getElementById("checkBtn").value;
    console.log("member : " + document.getElementById("checkBtn"));
    console.log("test : " + memberId);

    fetch("http://localhost:8080/api/" + memberId + "/duplicate")
        .then((response)=> {
            console.log("성공 " : response);
        })
        .catch((err)=> {
            console.log("에러 : " + err);
        })

//    alert('clicked');
    }
)