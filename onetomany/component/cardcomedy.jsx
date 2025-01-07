
// import React, { useEffect, useState } from "react";
// import axios from 'axios';
// import { useParams } from "react-router-dom";
// import { Button } from "@mui/material";
// import Comedy from "./comedy";

// function CardComedy() {
//   const { idvalue } = useParams();
//   const [dataItem, setDataItem] = useState({});
  
//   const fetchData = async () => {
//     try {
//       const response = await axios.get(`http://localhost:3001/profile/${idvalue}`);
//       setDataItem(response.data);
//     } catch (error) {
//       console.error("Error:", error);
//     }
//   };
  
//   useEffect(() => {
//     console.log(idvalue);
//     fetchData();
//   }, [idvalue]);

//   return (
//     <div>
//       <div className="hole">
        
//          <div className="box" style={{marginTop:"40px",marginLeft:"200px"}}>
//           <div key={dataItem.id} className="topic">
          
//             <img src={dataItem.img} className="img"></img>
//             <h2 id="title">{dataItem.title}</h2>
//             <br />
//             <h5 id="para">{dataItem.author}</h5>
//             <Button variant='contained' sx={{ backgroundColor: "#165D69", borderRadius: "10px",width: "100px" }} className="oo">watch</Button>
            
//          </div> 
//          </div>       
//       <div style={{color:"black",marginTop:"50px",width:"500px"}}>
//           <h2 id="title" style={{color:"black"}}>Movie Name : {dataItem.title}</h2>
//               <p>{dataItem.title}</p>
//             <br />
//              <h2 style={{color:"red"}}>Directed by : {dataItem.name}</h2>
//                <br />
//              <h2 style={{color:"brown"}}>Screenplay by : {dataItem.name1}</h2>
//                <br />
//                <h2 style={{color:"lightsalmon"}}>Based on : {dataItem.name2}</h2>
//               <br />
//            <h2 style={{color:"lightskyblue"}}>Produced by : {dataItem.name3}</h2>
//                <br />
//                <h2 style={{color:"grey"}}>Details : {dataItem.author}</h2>
//                <br />
//            </div>     
//       <br />
//       <br />
//       <br />
//       <h1>Related Movies:</h1>
//        </div>
//       <Comedy />
//     </div>
      
//       // </div>
//   );
// }

// export default CardComedy;


import React, { useEffect, useState } from "react";
import axios from 'axios';
import {  useParams } from "react-router-dom";
import { Button } from "@mui/material";
import { grey } from "@mui/material/colors";
import Comedy from "./comedy";

function Cardcomedy() {
  // const { idvalue } = useParams();
  const [totalPrice, setTotalPrice] = useState(0);
  const [cartItems, setCartItems] = useState([]);
  // const navigate = useNavigate();
  const { idvalue } = useParams();
  const [dataItem, setDataItem] = useState({});
  
  const fetchData = async () => {
    try {
      // const response = await axios.get(`http://localhost:3001/profile/${idvalue}`);
      const response = await axios.get(`/Comedy/${idvalue}`);
      setDataItem(response.data);

    } catch (error) {
      console.error("Error:", error);
    }
  };
  
  useEffect(() => {
    console.log(idvalue);
    fetchData();
  }, [idvalue]);

  // const handleImageClick = (id) => {
  //   navigate(`/CardItem/${id}`);
  // };

  const addToCart = () => {
    const updatedCartItems = [...cartItems, dataItem];
    setCartItems(updatedCartItems);
    localStorage.setItem('cartItems', JSON.stringify(updatedCartItems));
    setTotalPrice(totalPrice + dataItem.price);
  };


  useEffect(() => {
    fetchData();
    const storedCartItems = JSON.parse(localStorage.getItem('cartItems')) || [];
    setCartItems(storedCartItems);
    const price = storedCartItems.reduce((total, item) => total + item.price, 0);
    setTotalPrice(price);
  }, [idvalue]);
  return (
    <div>
      <div className="hole">
        
         <div className="box" style={{marginTop:"40px",marginLeft:"200px"}}>
          <div key={dataItem.id} className="topic">
          
            <img src={dataItem.img} className="img"></img>
            <h2 id="title">{dataItem.title}</h2>
            <br />
            <h5 id="para">{dataItem.author}</h5>
            <Button variant='contained' sx={{ backgroundColor: "#165D69", borderRadius: "10px",width: "100px" }} className="oo"
            onClick={addToCart}>Add to Cart
            </Button>
            <div>
            </div>
         </div>   
         </div>        
         <div style={{color:"black",marginTop:"50px",width:"500px",marginLeft:"50px"}}>
         <h2 id="title" style={{color:"black"}}>Movie Name : {dataItem.title}</h2>
              {/* <p>{dataItem.title}</p> */}
              <br />
              <h2 style={{color:"red"}}>Directed by : {dataItem.name}</h2>
              <br />
              <h2 style={{color:"brown"}}>Screenplay by : {dataItem.name1}</h2>
              <br />
              <h2 style={{color:"lightsalmon"}}>Based on : {dataItem.name2}</h2>
              <br />
              <h2 style={{color:"lightskyblue"}}>Produced by : {dataItem.name3}</h2>
              <br />
              <h2 style={{color:"grey"}}>Details : {dataItem.author}</h2>
              <br />
          </div>     
      </div>
      <br />
      <br />
      <br />
      <h1>Related Movies:</h1>
      <Comedy />
    </div>
  );
}

export default Cardcomedy;