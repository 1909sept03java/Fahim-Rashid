window.onload=function(){
    document.getElementById("button").addEventListener("click",populate)

        let url='localhost:8082/ProjectOne/session';
    }


function populate(){
    fetch(url,{ method: "GET", headers: { "Accept": "application/json" } })

    .then((response)=>{
        let data=response.json();
        return data;
    })
    .then((data)=>{
        document.getElementById("username").innerText="Name: "+data.username;
        console.log(data);
    })
    .catch((error)=>{
        alert('Error')
    })
}




