window.onload = function () {
    document.getElementById("button").addEventListener("click", getUsers);
    
}




function getUsers() {
    fetch('https://randomuser.me/api/?results=25')
    .then((res)=>res.json())
    .then((data)=>{

       console.log(data);
  

      
       let ul=document.getElementById("list");

            for(var i =0;i<25;i++){
                let li =document.createElement("li");
                li.innerHTML=JSON.stringify('GENDER: '+data.results[i].gender + ' NAME: ' + data.results[i].name.first +" "+ data.results[i].name.last + 'EMAIL: '+data.results[i].email)
              
                ul.appendChild(li); 
            }      
       })
}
  


