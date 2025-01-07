import React, { useEffect, useState } from "react";
import axios from "axios";
import "./home.css";
// import './romance.css';
import { Button } from "@mui/material";
import { useNavigate, useParams } from "react-router-dom";
function Horor() {
  const { idvalue } = useParams();
  const navigate = useNavigate();

  const [data, setData] = useState([]);

  useEffect(() => {
    // const api = 'http://localhost:3001/horor';
    const api = "/horror";

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
    navigate(`/CardHoror/${id}`);
  };

  return (
    <div className="hole">
      {/* <div className="hole" style={{margin:"12px", display:"grid",gridTemplateColumns:"2fr 2fr 2fr "}}> */}
      {data &&
        data.map((dataItem) => {
          return (
            <div
              className="box"
              onClick={() => handleImageClick(dataItem.id)}
              key={dataItem.id}
            >
              <div className="topic">
                <img src={dataItem.img} className="img"></img>
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
              </div>
            </div>
          );
        })}
    </div>
  );
}

export default Horor;
