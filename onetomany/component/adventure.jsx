import React, { useEffect, useState } from "react";
import axios from "axios";
import "./home.css";
import { Button } from "@mui/material";
import { useNavigate, useParams } from "react-router-dom";

function Adventure() {
  const { idvalue } = useParams();
  // console.log(idvalue);

  const navigate = useNavigate();
  const [data, setData] = useState([]);

  useEffect(() => {
    // const api = 'http://localhost:3001/adventure';
    const api = "/Adventure";

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
    navigate(`/Card/${id}`);
  };

  return (
    <div className="hole">
      {data &&
        data.map((dataItem) => (
          <div
            className="box"
            key={dataItem.id}
            onClick={() => handleImageClick(dataItem.id)}
          >
            <div className="topic">
              <img src={dataItem.img} className="img" alt={dataItem.title} />
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
        ))}
    </div>
  );
}

export default Adventure;
