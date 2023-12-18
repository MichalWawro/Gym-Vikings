

function Login({username, password}){

    const[user, setUser] = useState();

    function login(username, password){
        // e.preventDefault()
        fetch(`http://localhost:8080/user/login`, {
          method: 'POST',
          headers: {'Content-Type': 'application/json'},
          body: JSON.stringify({username:username, password:password})
        })
        .then(response => response.json())
        .then(response =>{  
        console.log("tu response:", response)
        console.log("error status:", response.status)
        if(response.status !== 401){
          //setTryingToSign(false);
          //handleLoginChange(true);
          setUser(response);
        }
        else{
          alert("incorrect login or password")
        }
        }
        )
        .catch(error =>{
        console.error(error)
        alert("connection error")
      })
      }


    return(
    <>
    {user ? (<HomePageLoggedIn user={user}/>):(<div id="MainLoginDiv" >
    <button id="SignInExitButton" className="NavButton" type="button" onClick={() => setTryingToSign(false)}>
        X
    </button>
    <div id="LoginDiv" >
        <div style={{ display: "inline-block" }} >
            <div className="LoginDivBox" >login:</div>
            <div>
                <input className="LoginInputBox" id="LoginInput" />
            </div>
        </div>
        <div style={{ display: "inline-block" }} >
            <div className="LoginDivBox" >password:</div>
            <div>
                <input className="LoginInputBox" id="PasswordInput" type="password" />
            </div>
        </div>
    </div>
    <button id="SignInLoginButton" className="NavButton" type="button" onClick={
        () => {
            setTryingToSign(false);
            handleLoginChange(true);
            login(document.getElementById("LoginInput").value, document.getElementById("PasswordInput").value)
        }}>
        Login
    </button>
</div>)

}</>
    
    )
}