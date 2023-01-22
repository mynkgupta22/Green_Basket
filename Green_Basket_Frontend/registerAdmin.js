
document.querySelector("#admin_reg_form").addEventListener("submit",registerAdmin)

async function registerAdmin(event){
    event.preventDefault();
    var name = document.getElementById('adminName').value;
    var phone = document.getElementById('phoneNumber').value;
    var email = document.getElementById('adminEmail').value;
    var password = document.getElementById('adminPassword').value;

      var param = {
        adminName:name,
        contactNumber:phone,
        emailId:email,
        password:password,
        Address:address
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
    
    fetch("http://localhost:8088/admin", requestOptions)
      .then(response => response.text())
      .then(result => console.log(result))
      .catch(error => console.log('error', error));
    

}