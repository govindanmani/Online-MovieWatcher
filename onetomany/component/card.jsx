// // import React from "react";
// // import React, { useEffect, useState } from "react";
// // import axios from 'axios';
// // import { useParams } from "react-router-dom";

// // function Card()
// // {
// //   useEffect(() => {
// //     const {idvalue }=useParams; 
// //     const [dataItem, setDataItem] = useState({}); 
// //     // console.log(idvalue);
// //     const fetchdata=async ()=>{
// //       const api = `http://localhost:3001/adventure/${idvalue}`;
// //       // const api = 'http://localhost:3001/adventure';
  
// //      await axios.get(api)
// //         .then(response => {
// //           setDataItem(response.data);
// //         })
// //         .catch(error => {
// //           console.error("Error:", error);
// //         });
// //       }
// //       fetchdata();
// //       }, [idvalue]);
// //       return(
// //         <div>
// //             <div>
// //                 <div>{dataItem.id}</div>
// //                 <div><h2>{dataItem.author}</h2></div>
// //                  <div>Hello World</div>
// //             </div>
// //         </div>
// //     )
// // }
// // export default Card;
//                 // {
//                 //     // data && data.map(e=>
//                 //     //     {
//                 //     //        <div>
//                 //     //         <h2>{e.img}</h2>
//                 //     //         <h3>{e.title}</h3>
//                 //     //         <p>{e.author}</p>
//                 //     //         <h1>Card</h1>
//                 //     //         <h1>Add to favorite</h1>
//                 //     //        </div>
//                 //     //     })
                    
//                 // }



// // Card.js
// // import React, { useEffect, useState } from "react";
// // import axios from 'axios';
// // import { useParams } from "react-router-dom";

// // function Card() {
// //   const { idvalue } = useParams(); // Correct usage of useParams
// //   const [dataItem, setDataItem] = useState({}); // State for storing a single item

// //   useEffect(() => {
// //     const api = `http://localhost:3001/adventure/${idvalue}`;
  
// //     axios.get(api)
// //       .then(response => {
// //         setDataItem(response.data);
// //       })
// //       .catch(error => {
// //         console.error("Error:", error);
// //       });
// //   }, [idvalue]);

// //   return (
// //     <div>
// //       <div>
// //         <div><p>{dataItem.title}</p></div>
// //         <div><h2>{dataItem.author}</h2></div>
// //         <div>Hello World</div>
// //         <h5>Hello 

// //         </h5>
// //       </div>
// //     </div>
// //   );
// // }

// // export default Card;








// // import React, { useEffect, useState } from "react";
// // import axios from 'axios';
// // import { useParams } from "react-router-dom";

// // function Card() {
// //   const { idvalue } = useParams();
// //   const [dataItem, setDataItem] = useState({});

// //   const fetchdata = async () => {
// //     const api = `http://localhost:3001/adventure/${idvalue}`;
// //     try {
// //       const response = await axios.get(api);
// //       setDataItem(response.data);
// //     } catch (error) {
// //       console.error("Error:", error);
// //     }
// //   };

// //   useEffect(() => {
// //     fetchdata();
// //   }, [idvalue]);

// //   return (
// //     <div>
// //       <div>
// //         <p>{dataItem.id}</p>
// //         <img src={dataItem.img} alt={dataItem.img}></img>
// //         <h2>{dataItem.author}</h2>
// //         <p>{dataItem.title}</p>
// //         <div>Hello World</div>
// //       </div>
// //     </div>
// //   );
// // }

// // export default Card;

// import React, { useEffect, useState } from "react";
// import axios from 'axios';
// import { useParams } from "react-router-dom";

// function Card() {
//   const { idvalue } = useParams();
//   const [dataItem, setDataItem] = useState({});

//   const fetchdata = async () => {
//     const api = `http://localhost:3001/adventure/${idvalue}`;
//     try {
//       const response = await axios.get(api);
//       setDataItem(response.data);
//     } catch (error) {
//       console.error("Error:", error);
//     }
//   };

//   useEffect(() => {
//     fetchdata();
//   }, [idvalue]);

//   return (
//     <div>
//       <div>
//         <p>{dataItem.id}</p>
//         {/* console.log(dataItem.id); */}
//         <img src={dataItem.img} alt={dataItem.title}></img> {/* Display the image */}
//         <h2>{dataItem.author}</h2>
//         <p>{dataItem.title}</p>
//         <div>Hello World</div>
//       </div>
//     </div>
//   );
// }

// export default Card;




import React, { useEffect, useState } from "react";
import axios from 'axios';
import { useParams } from "react-router-dom";
import { Button } from "@mui/material";
import { grey } from "@mui/material/colors";
import Adventure from "./adventure";

function Card() {
  const [totalPrice, setTotalPrice] = useState(0);
  const [cartItems, setCartItems] = useState([]);
  const { idvalue } = useParams();
  const [dataItem, setDataItem] = useState({});
  
  const fetchData = async () => {
    try {
      // const response = await axios.get(`http://localhost:3001/adventure/${idvalue}`);
      const response = await axios.get(`/Adventure/${idvalue}`);
      setDataItem(response.data);

    } catch (error) {
      console.error("Error:", error);
    }
  };
  
  useEffect(() => {
    console.log(idvalue);
    fetchData();
  }, [idvalue]);

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
            <Button variant='contained' sx={{ backgroundColor: "#165D69", borderRadius: "10px",width: "100px" }} className="oo"onClick={addToCart}>Add to Cart</Button>
            <div>
            </div>
         </div>   
         </div>        
         <div style={{color:"black",marginTop:"50px",width:"500px"}}>
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
      <h1 style={{marginLeft:"40px"}}>Related Movie</h1>
      <br />
      <br />
      <Adventure />
    </div>
  );
}

export default Card;

        {/* <h1>print</h1>
        <div className="box">
        <p className="topic">{dataItem.id}</p>
        <img src={dataItem.img} alt={dataItem.title} className="img"/>
        <p className="title">{dataItem.title}</p>
        <h2 className="para">{dataItem.author}</h2>
        </div> */}