import "./home.css";

import axios from "axios";
import React, { useEffect, useState } from "react";

import { Button } from "@mui/material";
import { useNavigate, useParams } from "react-router-dom";

function Anime() {
  const [data, setData] = useState([]);
  const { idvalue } = useParams();

  const navigate = useNavigate();

  useEffect(() => {
    axios
      .get("/Animation")
      .then((response) => {
        setData(response.data);
      })
      .catch((error) => {
        console.error("Error:", error);
      });
  }, []);

  const handleImageClick = (id) => {
    navigate(`/Cardanimation/${id}`);
  };

  return (
    <div className="hole">
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

export default Anime;
