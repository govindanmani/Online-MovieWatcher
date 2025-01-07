// import React, { useEffect, useState } from "react";
// import axios from 'axios';
// import './home.css';
// import {Button} from '@mui/material'
// // import Navbar from "./navbar";
// function Use() {
//   const [data, setData] = useState([]);

//   useEffect(() => {
//     const api = 'http://localhost:3001/dataslide/posts';

//     axios.get(api)
//       .then(response => {
//         setData(response.data);
//       })
//       .catch(error => {
//         console.error("Error:", error);
//       });
//   }, []);

//   return (
//     <div className="hole">
//       {/* <Navbar /> */}
//       {/* <h1>hello</h1> */}
//       {
//           data && data.map(dataItem => {
//             return(
//               <div className="box">
//           <div key={dataItem.id} className="topic">
//             <img src={dataItem.img} className="imgimg"></img>
//             <h2 id="title">{dataItem.title}</h2>
//             <br />

//             <h5 id="para">{dataItem.author}</h5>
//             <Button variant='contained' sx={{ backgroundColor: "#165D69", borderRadius: "10px",width: "100px" }}  className="oo">watch</Button>
//          </div>
//          </div>
//             )
//           }
//         )
//       }
//       {/* <button>submit</button> */}
//     </div>
//   );
// }

// export default Use;

// //           //   <div key={dataItem.id}>
// //           //     <h1>{dataItem.id}</h1>
// //           //     <h3>{dataItem.body}</h3>
// //           //     <h3>{dataItem.postId}</h3>
// //           //  </div>

// // import React, { useEffect, useState } from "react";
// // import axios from 'axios';
// // import './home.css';
// // import { Button } from '@mui/material';
// // // import Navbar from "./navbar";

// // function Use() {
// //   const [data, setData] = useState([]);

// //   useEffect(() => {
// //     const api = 'http://localhost:3001/posts';

// //     axios.get(api)
// //       .then(response => {
// //         setData(response.data);
// //       })
// //       .catch(error => {
// //         console.error("Error:", error);
// //       });
// //   }, []);

// //   return (
// //     <div className="hole">
// //       {/* <Navbar /> */}
// //       {/* <h1>hello</h1> */}
// //       {data && data.map(dataItem => (
// //         <div key={dataItem.id} className="box">
// //           <div className="topic">
// //             <img src={dataItem.img} className="imgimg" alt={dataItem.title} />
// //             <h2 id="title">{dataItem.title}</h2>
// //             <br />
// //             <h5 id="para">{dataItem.author}</h5>
// //             <Button variant='contained' sx={{ backgroundColor: "#165D69", borderRadius: "10px", width: "100px" }} className="oo">watch</Button>
// //           </div>
// //         </div>
// //       ))}
// //       {/* <button>submit</button> */}
// //     </div>
// //   );
// // }

// // export default Use;

import React, { useEffect, useState } from "react";
import axios from "axios";
import "./home.css";
import { Button } from "@mui/material";
import { useNavigate, useParams } from "react-router-dom";

function Use() {
  const { idvalue } = useParams();
  // const [img,setImg]=useState();
  // const [title,SetTitle]=useState();
  // const [author,SetAuthor]=useState();

  const navigate = useNavigate();
  const [data, setData] = useState([]);

  useEffect(() => {
    // const api = 'http://localhost:3001/posts';
    const api = "/action";

    axios
      .get(api)
      .then((response) => {
        setData(response.data);
        console.log.apply(response.data);
      })
      .catch((error) => {
        console.error("Error:", error);
      });
  }, []);

  const handleImageClick = (id) => {
    navigate(`/CardAction/${id}`);
  };

  return (
    <div className="hole">
      {data &&
        data.map((dataItem) => (
          <div
            key={dataItem.id}
            className="box"
            onClick={() => handleImageClick(dataItem.id)}
          >
            <div className="topic">
              <img src={dataItem.img} className="imgimg" alt={dataItem.title} />
              <h2 id="title">{dataItem.title}</h2>
              <br />
              <h5 id="para">{dataItem.author}</h5>
              <Button
                variant="contained"
                sx={{
                  backgroundColor: "#165D69",
                  borderRadius: "10px",
                  width: "100px",
                }}
                className="oo"
                onClick={() => handleImageClick(dataItem.id)}
              >
                watch
              </Button>
              {/* <img src={dataItem.img} /> */}
            </div>
          </div>
        ))}
    </div>
  );
}

export default Use;

// import React, { useEffect, useState } from "react";
// import axios from 'axios';
// import './home.css';
// import { Button } from '@mui/material';
// import { useNavigate, useParams } from "react-router-dom";

// function Use() {
//   const { idvalue } = useParams();
//   // console.log(idvalue);

//   const navigate = useNavigate();
//   const [data, setData] = useState([]);

//   useEffect(() => {

//     const api = 'http://localhost:3001/posts';

//     axios.get(api)
//       .then(response => {
//         setData(response.data);
//       })
//       .catch(error => {
//         console.error("Error:", error);
//       });
//   }, []);

//   const handleImageClick = (id) => {
//     navigate(`/CardAction/${id}`);
//   };

//   return (
//     <div className="hole">
//       {data && data.map(dataItem => (
//         <div key={dataItem.id} className="box" onClick={() => handleImageClick(dataItem.id)}>
//           <div className="topic">
//             <img src={dataItem.img} className="imgimg" alt={dataItem.title} />
//             <h2 id="title">{dataItem.title}</h2>
//             <br />
//             <h5 id="para">{dataItem.author}</h5>
//             <Button variant='contained' sx={{ backgroundColor: "#165D69", borderRadius: "10px", width: "100px" }} className="oo"
//             onClick={() => handleImageClick(dataItem.id)}
//             >watch</Button>
//           </div>
//         </div>
//       ))}
//     </div>
//   );
// }

// export default Use;
