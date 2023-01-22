document.querySelector("#user_login_form").addEventListener("submit",loginUser)

async function loginUser(event){
    event.preventDefault();
    
    var email = document.getElementById('userEmail').value;
    var password = document.getElementById('userPassword').value;
    var role  = document.getElementById('userRole').value;

      var param = {
        userId:email,
        password:password,
        role:role
      }

    console.log(param);


    var myHeaders = new Headers();
    myHeaders.append("Content-Type", "application/json");

    var raw = JSON.stringify(param);

    var requestOptions = {
    method: 'POST',
    headers: myHeaders,
    body: raw,
    redirect: 'follow'
    };

    fetch("http://localhost:8088/userlogin", requestOptions)
    .then(response => response.text())
    .then(result => alert(result))
    .catch(error => console.log('error', error));
    
    
 

}