import React, { useEffect } from "react";
import {TextField,Typography,Button} from '@mui/material';
// import './login.css'
import './login1.css';
import { Route, useNavigate } from 'react-router-dom';
import axios from "axios";
import { useState } from "react";
import AddFunction1 from "./registration";
import {toast} from "sonner";

function AddFunction5()
{
  const[email,setEmail]=useState(); 
  const[pass,setPass]=useState();
  // const[user,setuser]=useState([]);
  const navigate = useNavigate();


  
  // const Verify = (e) =>{
  //   e.preventDefault();
  //   const url="http://localhost:3001/user";
  //   // const url="http://localhost:3001/login";
  //   axios.get(url).then(Response =>
  //     {
  //     setuser(Response.data);
  //   })
  //   // console.log(user);
  //   const isMatch = user.some((use)=> use.username==name && use.password==pass);
  //   if(isMatch){
  //     navigate('/');
  //   }else{
  //     alert("Failed");
  //   }
  // }
  const Verify = async (e) =>{
    e.preventDefault();

    axios //
      .post("/login", { email: email, password: pass })
      .then((res) => {
        toast.success("Successful Login");
        navigate('/');
      })
      .catch((err) => {
        console.log(err.response)
        
        if (err.response.status === 404) {
          toast.error("Invalid Email");
        } else if (err.response.status === 403) {
          toast.error("Mismatch Password");
        } else {
          toast.error("Internal Server Error");
        }
      })

    
    // await axios.get(url).then(Response =>
    //   {
    //   isMatch = Response.data.password == pass;
    // })
    // if(isMatch){
    // }else{
    //   alert("Failed");
    // }
  }
   return(
    <div className="log11">
     
     <form id="title11">
       <div id="head11">
         <Typography variant="h2" >
          Login
          </Typography>
       </div>
      <div id="text211">
          <TextField  variant="outlined" type="email" placeholder="Email" margin="normal"  
          onChange={(e)=>(setEmail(e.target.value))}/>

      </div >
      <div id="text3">
          <TextField variant="outlined" type="password" placeholder="password" margin="normal" 
          onChange={(e)=>(setPass(e.target.value))}
          />
      </div >
      <div id="button11">
       <Button  
       sx={{marginTop: 3 ,borderRadius:3}}
       variant="contained" color="warning" type="submit" onClick={Verify} >
       submit
       </Button>
       <div  className="iritate">
      <a href="http://localhost:3000/register">Registration</a>
       </div>
          
      </div>
    </form>
   
    </div>

   )
}
export default AddFunction5;