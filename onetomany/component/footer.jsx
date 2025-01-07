import React from "react";
import "./footer.css";
// import { Link,Routes,Route } from "react-router-dom"
import { Button } from "@mui/material";
import { BrowserRouter, Route } from "react-router-dom";
import About from "./about";

function FoterDiss() {
  return (
    <div className="container41">
      <div className="final_box1">
        <div className="final11">
          <li>
            <h3>About Us</h3>
          </li>
          <li>
            <a href="/about">Terms and use</a>
          </li>
          <li>
            <a href="/events">Upcomming Movie</a>
          </li>
          <li>
            <a href="/news">Movie News</a>
          </li>
          <li>
            <a href="/login">Events</a>
          </li>
          <li>
            <a href="/events">Most Popular Movie</a>
          </li>
          <li>
            <a href="/contact">Contact Us</a>
          </li>
          <li>
            <a href="/privacy">Pivacy Police</a>
          </li>
        </div>
        <div className="final11">
          <li>
            <h3>Favourite to Watch</h3>
          </li>
          <li>
            <a href="/action">Action Movie </a>
          </li>
          <li>
            <a href="/romance">Romance Movie </a>
          </li>
          <li>
            <a href="/animation">Animation Movie </a>
          </li>
          <li>
            <a href="/Scitenfic">Scitenfic Movie </a>
          </li>
          <li>
            <a href="/thriller">Thriller Movie </a>
          </li>
          <li>
            <a href="/mistry">Mistry Movie</a>
          </li>
          <li>
            <a href="/adventure">Adventure Movie </a>
          </li>
          <li>
            <a href="/fantsy">Fantsy Movie </a>
          </li>
        </div>
        <div className="final11">
          <Button
            sx={{ marginTop: 3, borderRadius: 3 }}
            variant="contained"
            color="warning"
            type="submit"
          >
            Completion
          </Button>
          <br />
          <li>
            <h3>Contacts</h3>
          </li>
          <li>1/146,Anjaneyar kovil street,Periyasevalai</li>
          <li>Ulunderpet,Kallakurichi</li>
          <li>Phone:9843249607,6380087037</li>
          <li>Email:manikannan6380@gmail.com</li>
          <br />
          {/* </div>
                    <div className="icon"> */}
          <a href="">
            <i className="fa-brands fa-twitter"></i>
          </a>
          <a href="">
            <i className="fa-brands fa-facebook"></i>
          </a>
          <a href="">
            <i className="fa-brands fa-linkedin"></i>
          </a>
          <a href="">
            <i className="fa-brands fa-instagram"></i>
          </a>
        </div>
      </div>
    </div>
  );
}
export default FoterDiss;
