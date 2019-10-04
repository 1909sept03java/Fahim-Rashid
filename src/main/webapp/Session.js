window.onload=function(){
    document.getElementById("id").innerHTML='Hello';

    let url="localhost:8082/ProjectOne/session";
    //sendAjaxGet(url,logMe);
    document.getElementById("button").addEventListener("click",getInfo);
    document.getElementById("id").innerHTML='Hello';


}

function getInfo(){
    fetch(url,{method:"GET", headers:{"Accept":"application/json"}})
    .then((response)=>{
        let data=response.json();
        return data;
    })
    .then((data)=>{
        let ul=document.getElementById("info")
            document.getElementById("id").innerHTML='Hello';

        let li=document.createElement("li");
        li.innerHTML=`<p>${data}</p>`;
        ul.append(li);

        console.log(data.username);
    })
}
	
