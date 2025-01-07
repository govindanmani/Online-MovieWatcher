import React from "react";
import {TextField,Typography,Button} from '@mui/material';
import './login1.css'
import { useNavigate } from 'react-router-dom';
import { useState } from "react";
import axios from "axios";
function AddFunction1()
{
    const navigate = useNavigate();
    const[name,setName]=useState(); 
    const[pass,setPass]=useState();

     function Tologin()
     {
      const api="/login";
      axios.post(api,
        {
          email:name,
          password:pass
        })
        // console.log(api,email,password);
        navigate('/');
      // const api="http://localhost:3001/user";
      // axios.post(api,
      //   {
      //     username:name,
      //     password:pass
      //   })
      //   navigate('/');
     }

   return(
    <div className="log11">
    <form id="title11">
       <div className="tit">
         <Typography variant="h3">Register</Typography>
       </div>
      <div id="text1">
          <TextField variant="outlined" type="text" margin="normal" placeholder="Name*" required 
          // value={name}
          //  onChange={(e)=>(setName(e.target.value))}
          />
      </div>
    
      <div id="text2">
          <TextField  variant="outlined" type="email" margin="normal" placeholder="Email*" required value={name}
          onChange={(e)=>(setName(e.target.value))}/>

      </div>
      <div id="text3">
          <TextField variant="outlined" type="password" margin="normal" placeholder="Password*"
           value={pass} onChange={(e)=>(setPass(e.target.value))}
          />
      </div>
      <div id="text3">
          <TextField variant="outlined" type="password" margin="normal" placeholder="confirm Password*" required/>
      </div>
      <div>
       <Button 
       onClick={Tologin}
       sx={{marginTop: 3 ,borderRadius:3}}
       variant="contained" color="warning" type="submit"  required
        >SignUp</Button>
       {/* <Button  >Login</Button> */}
       <br />
       <div className="iritate">
       <a href="http://localhost:3000/login">Login</a>
       </div>
      </div>
    </form>
    </div>
   )
}
export default AddFunction1;















// import React, { useState } from "react";
// import { TextField, Typography, Button } from '@mui/material';
// import './login1.css';
// import { useNavigate } from 'react-router-dom';
// import axios from "axios";

// function AddFunction1() {
//     const navigate = useNavigate();
//     const [name, setName] = useState(''); 
//     const [email, setEmail] = useState('');
//     const [pass, setPass] = useState('');
//     const [confirmPass, setConfirmPass] = useState('');

//     function Tologin() {
//         if (pass === confirmPass) {
//             const api = "/login";
//             axios.post(api, {
//                 email: email,
//                 password: pass
//             }).then(response => {
//                 console.log(response.data);
//                 // Redirect to login page or handle success
//                 navigate('/');
//             }).catch(error => {
//                 console.error("Error:", error);
//                 // Handle error
//             });
//         } else {
//             // Show error message that passwords do not match
//         }
//     }

//     return (
//         <div className="log11">
//             <form id="title11">
//                 <div className="tit">
//                     <Typography variant="h3">Register</Typography>
//                 </div>
//                 <div id="text1">
//                     <TextField variant="outlined" type="text" margin="normal" placeholder="Name*" required value={name} onChange={(e) => setName(e.target.value)} />
//                 </div>
//                 <div id="text2">
//                     <TextField variant="outlined" type="email" margin="normal" placeholder="Email*" required value={email} onChange={(e) => setEmail(e.target.value)} />
//                 </div>
//                 <div id="text3">
//                     <TextField variant="outlined" type="password" margin="normal" placeholder="Password*" required value={pass} onChange={(e) => setPass(e.target.value)} />
//                 </div>
//                 <div id="text3">
//                     <TextField variant="outlined" type="password" margin="normal" placeholder="Confirm Password*" required value={confirmPass} onChange={(e) => setConfirmPass(e.target.value)} />
//                 </div>
//                 <div>
//                     <Button onClick={Tologin} sx={{ marginTop: 3, borderRadius: 3 }} variant="contained" color="warning" type="submit">SignUp</Button>
//                     <br />
//                     <div className="iritate">
//                         <a href="http://localhost:3000/login">Login</a>
//                     </div>
//                 </div>
//             </form>
//         </div>
//     );
// }

// export default AddFunction1;
