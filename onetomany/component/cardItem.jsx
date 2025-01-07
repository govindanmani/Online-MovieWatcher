import React, { useEffect, useState } from "react";
import axios from "axios";
import { useParams } from "react-router-dom";
import { Button, colors } from "@mui/material";

function CardItem() {
  const { idvalue } = useParams();
  const [dataItem, setDataItem] = useState({});
  const [cartItems, setCartItems] = useState([]);
  const [totalPrice, setTotalPrice] = useState(0);

  const fetchData = async () => {
    try {
      // const response = await axios.get(`http://localhost:3001/profile/${idvalue}`);
      const response = await axios.get(`/movie`);
      setDataItem(response.data);
    } catch (error) {
      console.error("Error:", error);
    }
  };

  const addToCart = () => {
    const updatedCartItems = [...cartItems, dataItem];
    setCartItems(updatedCartItems);
    localStorage.setItem("cartItems", JSON.stringify(updatedCartItems));
    setTotalPrice(totalPrice + dataItem.price);
  };

  const removeFromCart = (itemId) => {
    const updatedCartItems = cartItems.filter((item) => item.id !== itemId);
    setCartItems(updatedCartItems);
    localStorage.setItem("cartItems", JSON.stringify(updatedCartItems));
    const removedItem = cartItems.find((item) => item.id === itemId);
    setTotalPrice(totalPrice - removedItem.price);
  };

  useEffect(() => {
    fetchData().then(() => {
      const storedCartItems =
        JSON.parse(localStorage.getItem("cartItems")) || [];
      setCartItems(storedCartItems);
      console.table(storedCartItems);
      const price = storedCartItems.reduce(
        (total, item) => total + (item.price || 0),
        0
      );
      setTotalPrice(price);
    });
  }, [idvalue]);

  return (
    // <div style={{ marginTop: "30px", marginBottom: "23px" }}>
    <div>
      <br />
      <br />
      <div>
        <h2
          style={{
            marginLeft: "80px",
            fontSize: "60px",
            color: "red",
            marginTop: "5px",
          }}
        >
          Cart Items:
        </h2>
        <br />
        <div
          className="holee"
          style={{
            display: "",
            border: "10px",
            borderRadius: "20px",
            borderColor: "black",
            display: "flex",
            flexDirection: "column",
            gap: "15px",
          }}
        >
          <br />
          {cartItems.map((item) => {
            return (
              <div
                className="boxxn"
                style={{
                  display: "flex",
                  width: "1100px",
                  height: "300px",
                  border: "10px",
                  borderRadius: "20px",
                  borderColor: "black",
                  backgroundColor: "grey",
                  marginLeft: "150px",
                  // marginTop: "100px",
                }}
                key={item.id}
              >
                <div className="topick" style={{ marginTop: "-00px" }}>
                  <img src={item.img} className="img"></img>
                  <br />
                  <br />
                  <div
                    style={{
                      style: "flex",
                      marginTop: "-170px",
                      marginLeft: "230px",
                    }}
                  >
                    <h2 id="title">{item.title}</h2>
                    <br />
                    {/* <h5 id="para">{item.author}</h5> */}
                    <br />
                    <h3>Total Price: ${item.price}</h3>
                    <br />
                    <h3>Rating : 4.5</h3>
                    <br />
                    <Button
                      variant="contained"
                      sx={{
                        backgroundColor: "#165D69",
                        borderRadius: "10px",
                        width: "100px",
                        marginLeft: "700px",
                        marginTop: "-25px",
                      }}
                      className="ook"
                      onClick={() => removeFromCart(item.id)}
                    >
                      Remove
                    </Button>
                  </div>
                  <br />
                </div>
                <br />
                <br />
              </div>
            );
          })}
        </div>
        <h3>Total Price: ${totalPrice}</h3>
        <br />
        <br />
      </div>
    </div>
  );
}

export default CardItem;
