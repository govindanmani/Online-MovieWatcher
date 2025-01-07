import React, { useEffect, useState } from "react";
import axios from "axios";
import "./romance.css";
import { Button } from "@mui/material";
import { useNavigate, useParams } from "react-router-dom";
function Romance() {
  const { idvalue } = useParams();
  // console.log(idvalue);

  const navigate = useNavigate();
  const [data, setData] = useState([]);

  useEffect(() => {
    // const api = 'http://localhost:3001/comments';
    const api = "/Romance";

    axios
      .get(api)
      .then((response) => {
        setData(response.data);
      })
      .catch((error) => {
        console.error("Error:", error);
      });
  }, []);

  const handleImageClick = (id) => {
    navigate(`/CardRomance/${id}`);
  };

  return (
    <div className="hole">
      {/* <Navbar /> */}
      {/* <h1>hello</h1> */}
      {data &&
        data.map((dataItem) => {
          return (
            <div
              className="box"
              onClick={() => handleImageClick(dataItem.id)}
              key={dataItem.id}
            >
              <div className="topic">
                {/* <h1>{dataItem.id}</h1> */}
                <img src={dataItem.img} className="img"></img>
                <h2 id="title">{dataItem.title}</h2>
                <br />
                {/* {dataItem.img} */}
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
              </div>
            </div>
          );
        })}
      {/* <button>submit</button> */}
    </div>
  );
}
export default Romance;
