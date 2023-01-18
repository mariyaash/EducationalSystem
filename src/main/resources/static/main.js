function login()
{
const loginCreateDTO=
{
email: document.getElementById("email").value,
password: document.getElementById("password").value
}
	const xhttp = new XMLHttpRequest();
	xhttp.onload = function()
	{
        const loginSuccessDTO=JSON.parse(this.responseText);
        document.getElementById("result").innerHTML=loginSuccessDTO.message;
	}
xhttp.open("POST", "/mutual/login");
xhttp.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
xhttp.send(JSON.stringify(loginCreateDTO));
return false;
}